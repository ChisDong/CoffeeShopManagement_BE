package CoffeeShopManagement.example.CoffeeShopManagement.Service;

import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.AuthenticationRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Request.IntrospectRequest;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.AuthenticationResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.DTO.Response.IntrospectResponse;
import CoffeeShopManagement.example.CoffeeShopManagement.Respository.NhanVienRespository;
import com.nimbusds.jose.*;
import com.nimbusds.jose.crypto.MACSigner;
import com.nimbusds.jose.crypto.MACVerifier;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.text.ParseException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Service
public class AuthenticationService {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationService.class);
    @Autowired
    private NhanVienRespository nhanVienRespository;

    //@Nonfinal de khong inject
    @Value("${jwt.signerKey}")
    protected String SIGNER_KEY;

    public IntrospectResponse authenticateToken(IntrospectRequest request) throws JOSEException, ParseException {
        var token = request.getToken();
        JWSVerifier verifier =  new MACVerifier(SIGNER_KEY.getBytes());

        SignedJWT signedJWT = SignedJWT.parse(token);

        Date expiredTime = signedJWT.getJWTClaimsSet().getExpirationTime();

        var verified = signedJWT.verify(verifier); // trả ra boolean

        IntrospectResponse introspectResponse = new IntrospectResponse();
        introspectResponse.setValid(verified && expiredTime.after(new Date()));
        return introspectResponse;
    }

    //khúc này lấy password ra phải mã hoá lại 1 lần nữa, có thể không mã hoá cũng được nhưng mã hoá có vẻ hợp ly hon
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        var nhanVien = nhanVienRespository.findById(request.getMaNv());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        boolean authenticated = passwordEncoder.matches(request.getMatKhau(), nhanVien.get().getMatKhau());
        //kiểm tra xem có authenticated thành công hay không, cái này cần bổ xung
        //trong truong hop nay mac dinh la true
        var token = generateToken(request.getMaNv());
        AuthenticationResponse authenticationResponse = new AuthenticationResponse();
        authenticationResponse.setToken(token);
        authenticationResponse.setAuthenticated(authenticated);
        return authenticationResponse;
    }

    private  String generateToken(String userId){
        JWSHeader header = new JWSHeader(JWSAlgorithm.HS512);
        // payload
        JWTClaimsSet jwtClaimsSet = new JWTClaimsSet.Builder()
                .subject(userId)
                .issuer("coffeshop.com")
                .issueTime(new Date())
                .expirationTime(new Date(
                        Instant.now().plus(1, ChronoUnit.HOURS).toEpochMilli()
                ))
                .claim(userId, "custom")
                .build();
        Payload payload = new Payload(jwtClaimsSet.toJSONObject());

        JWSObject jwsObject = new JWSObject(header, payload);
        try {
            jwsObject.sign(new MACSigner(SIGNER_KEY.getBytes()));
            return jwsObject.serialize();
        }catch (JOSEException e){
            log.error("cannot create token", e);
            throw new RuntimeException(e);
        }
    }

}
