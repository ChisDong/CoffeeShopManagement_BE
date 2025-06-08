package CoffeeShopManagement.example.CoffeeShopManagement.Configuration;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.AuthenticationResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.http.converter.xml.AbstractJaxb2HttpMessageConverter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.oauth2.jose.jws.MacAlgorithm;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.crypto.spec.SecretKeySpec;

@Configuration
@EnableWebSecurity
public class SercurityConfig {
        @Autowired
        private AuthenticationService authenticationService;

        private final String[] PUBLIC_ENDPOINTS = { "/nhanviens", "/nhanviens/tokens", "/nhanviens/auths",
                        "/khachhangs", "/laytonggiolams/{maNv}", "/dangkylichs", "/laylichcuanhanviens/{maNv}",
                        "/laynhanvientronglichs/{maLlv}", "/dangkylichs", "/xoadangkylichs",
                        "/themdouongs", "/suadouongs", "/xoadouongs/{maDoUong}", "/menus", "/taolichs",
                        "/laylichs/bydays/{NgayBD}/{NgayKT}", "/lichs", "/sualichs/{id}", "/xoalichs/{id}", "/pings" };
        private final String[] NHANVIEN_ENDPOINTS = { "/nhanvien", "/lichs/bydays" };
        private final String[] ADMIN_ENDPOINS = { "/nhanvien", "/lichs/bydays" };

        @Value("${jwt.signerKey}")
        private String SIGNER_KEY;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
                httpSecurity
                                .authorizeHttpRequests(request -> request
                                                .requestMatchers("/pings").permitAll()
                                                .requestMatchers("/tonggios/**").permitAll()
                                                .requestMatchers(HttpMethod.POST, PUBLIC_ENDPOINTS).permitAll()
                                                .requestMatchers(HttpMethod.GET, PUBLIC_ENDPOINTS).permitAll()
                                                .requestMatchers(HttpMethod.DELETE, PUBLIC_ENDPOINTS).permitAll()
                                                .requestMatchers(HttpMethod.GET, NHANVIEN_ENDPOINTS).hasRole("EMPLOYEE")
                                                .requestMatchers(HttpMethod.DELETE, ADMIN_ENDPOINS).hasRole("ADMIN")
                                                .requestMatchers(HttpMethod.PUT, ADMIN_ENDPOINS).hasRole("ADMIN")
                                                .anyRequest().authenticated())
                                .csrf(AbstractHttpConfigurer::disable)
                                .oauth2ResourceServer(oauth2 -> oauth2.jwt(jwt -> jwt.decoder(jwtDecoder())
                                                .jwtAuthenticationConverter(jwtAuthenticationConverter())));

                return httpSecurity.build();
        }

        @Bean
        JwtDecoder jwtDecoder() {
                SecretKeySpec secretKeySpec = new SecretKeySpec(SIGNER_KEY.getBytes(), "HS512");
                return NimbusJwtDecoder
                                .withSecretKey(secretKeySpec)
                                .macAlgorithm(MacAlgorithm.HS512)
                                .build();
        };

        @Bean
        JwtAuthenticationConverter jwtAuthenticationConverter() {
                JwtGrantedAuthoritiesConverter jwtGrantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
                jwtGrantedAuthoritiesConverter.setAuthoritiesClaimName("role");
                jwtGrantedAuthoritiesConverter.setAuthorityPrefix("ROLE_");

                JwtAuthenticationConverter jwtConverter = new JwtAuthenticationConverter();
                jwtConverter.setJwtGrantedAuthoritiesConverter(jwtGrantedAuthoritiesConverter);
                return jwtConverter;
        }

}
