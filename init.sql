-- init.sql: Database initialization script for Docker Compose MySQL

USE IS216;

-- ========================
-- Table: KHÁCH HÀNG (Customers)
-- ========================
CREATE TABLE IF NOT EXISTS khachhang (
    MAKH VARCHAR(100) PRIMARY KEY,
    TENKH VARCHAR(100),
    SODIENTHOAI VARCHAR(100)
);

-- ========================
-- Table: NHÂN VIÊN (Employees)
-- ========================
CREATE TABLE IF NOT EXISTS nhanvien (
    MANV VARCHAR(100) PRIMARY KEY,
    MATKHAU VARCHAR(100),
    HOTENNV VARCHAR(100),
    EMAIL VARCHAR(100),
    SOCCCD VARCHAR(100),
    VITRILAM VARCHAR(100),
    ROLE ENUM('EMPLOYEE', 'ADMIN') NOT NULL,
    LUONG DECIMAL(10,2)
);

-- ========================
-- Table: ĐỒ UỐNG (Drinks)
-- ========================
CREATE TABLE IF NOT EXISTS douong (
    MADOUONG VARCHAR(100) PRIMARY KEY,
    TENDOUONG VARCHAR(100),
    LOAIDOUONG VARCHAR(100),
    GIADOUONG DECIMAL(10,2),
    TRANGTHAI BOOLEAN
);

-- ========================
-- Table: LỊCH LÀM VIỆC (Work Schedule)
-- ========================
CREATE TABLE IF NOT EXISTS lichlamviec (
    id VARCHAR(100) PRIMARY KEY,
    NVTAOLICH VARCHAR(100),
    MANV VARCHAR(100),
    NGAYBATDAU VARCHAR(100),
    NGAYKETTHUC VARCHAR(100),
    THOIGIANBATDAU VARCHAR(100),
    THOIGIANKETHUC VARCHAR(100),
    SOLUONG INT,
    FOREIGN KEY (MANV) REFERENCES nhanvien(MANV)
);

-- ========================
-- Table: ĐĂNG KÝ (Schedule Registration)
-- ========================
CREATE TABLE IF NOT EXISTS dangky (
    MALLV VARCHAR(100),
    MANV VARCHAR(100),
    PRIMARY KEY (MALLV, MANV),
    FOREIGN KEY (MALLV) REFERENCES lichlamviec(id),
    FOREIGN KEY (MANV) REFERENCES nhanvien(MANV)
);

-- ========================
-- Trigger: Check SOLUONG before inserting registration
-- Prevent registration if schedule is full
-- ========================
DELIMITER //
CREATE TRIGGER trg_check_soluong_before_insert
BEFORE INSERT ON dangky
FOR EACH ROW
BEGIN
    DECLARE so_con_lai INT DEFAULT 0;
    SELECT SOLUONG INTO so_con_lai FROM lichlamviec WHERE id = NEW.MALLV;
    IF so_con_lai <= 0 THEN
        SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không thể đăng ký: ca làm đã đủ người';
    END IF;
END;
//
DELIMITER ;

-- ========================
-- Trigger: Decrease SOLUONG after successful registration
-- ========================
DELIMITER //
CREATE TRIGGER trg_giam_soluong_after_insert
AFTER INSERT ON dangky
FOR EACH ROW
BEGIN
    UPDATE lichlamviec SET SOLUONG = SOLUONG - 1 WHERE id = NEW.MALLV;
END;
//
DELIMITER ;

-- ========================
-- Trigger: Increase SOLUONG after cancellation (deletion)
-- ========================
DELIMITER //
CREATE TRIGGER trg_tang_soluong_after_delete
AFTER DELETE ON dangky
FOR EACH ROW
BEGIN
    UPDATE lichlamviec SET SOLUONG = SOLUONG + 1 WHERE id = OLD.MALLV;
END;
//
DELIMITER ;

-- ========================
-- Table: HÓA ĐƠN (Invoices)
-- ========================
CREATE TABLE IF NOT EXISTS hoadon (
    MAHD VARCHAR(100) PRIMARY KEY,
    MAKH VARCHAR(100),
    MANV VARCHAR(100),
    NGAYMUA DATETIME,
    TONGTIEN DECIMAL(10,2),
    FOREIGN KEY (MAKH) REFERENCES khachhang(MAKH),
    FOREIGN KEY (MANV) REFERENCES nhanvien(MANV)
);

-- ========================
-- Table: CHI TIẾT HÓA ĐƠN (Invoice Details)
-- ========================
CREATE TABLE IF NOT EXISTS chitiethoadon (
    MAHD VARCHAR(100),
    MADOUONG VARCHAR(100),
    SOLUONG INT,
    DONGIA DECIMAL(10,2),
    THANHTIEN DECIMAL(10,2),
    PRIMARY KEY (MAHD, MADOUONG),
    FOREIGN KEY (MAHD) REFERENCES hoadon(MAHD),
    FOREIGN KEY (MADOUONG) REFERENCES douong(MADOUONG)
);


