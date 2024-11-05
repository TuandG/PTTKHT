-- CREATE DATABASE LIBMAN;

-- Bảng tblHoTen766
CREATE TABLE tblHoTen766 (
                             id SERIAL PRIMARY KEY,
                             ho VARCHAR(50),
                             ten VARCHAR(50),
                             ten_dem VARCHAR(50)
);

-- Bảng tblDiaChi766
CREATE TABLE tblDiaChi766 (
                              id SERIAL PRIMARY KEY,
                              to_dan_pho VARCHAR(50),
                              phuong_xa VARCHAR(50),
                              quan_huyen VARCHAR(50),
                              tinh VARCHAR(50),
                              thanh_pho VARCHAR(50)
);

-- Bảng tblViTri766
CREATE TABLE tblViTri766 (
                             id SERIAL PRIMARY KEY,
                             ten VARCHAR(100),
                             mo_ta TEXT
);

-- Bảng tblThanhVien766
CREATE TABLE tblThanhVien766 (
                                 id SERIAL PRIMARY KEY,
                                 ten_dang_nhap VARCHAR(50) UNIQUE,
                                 mat_khau VARCHAR(100),
                                 ngay_sinh DATE,
                                 so_dien_thoai VARCHAR(15),
                                 ho_ten_id INT,
                                 dia_chi_id INT,
                                 vi_tri_id INT,
                                 CONSTRAINT fk_tv_ht FOREIGN KEY (ho_ten_id) REFERENCES tblHoTen766(id),
                                 CONSTRAINT fk_tv_dc FOREIGN KEY (dia_chi_id) REFERENCES tblDiaChi766(id),
                                 CONSTRAINT fk_tv_vt FOREIGN KEY (vi_tri_id) REFERENCES tblViTri766(id)
);

-- Bảng tblTheDocTrucTuyen766
CREATE TABLE tblTheDocTrucTuyen766 (
                                       id SERIAL PRIMARY KEY,
                                       ngay_bat_dau_hieu_luc DATE,
                                       ngay_ket_thuc_hieu_luc DATE,
                                       trang_thai BOOLEAN,
                                       thanh_vien_id INT,
                                       CONSTRAINT fk_tdtt_tv FOREIGN KEY (thanh_vien_id) REFERENCES tblThanhVien766(id)
);

-- Bảng tblPhieuMuon766
CREATE TABLE tblPhieuMuon766 (
                                 id SERIAL PRIMARY KEY,
                                 ngay_muon DATE,
                                 han_muon DATE,
                                 thanh_vien_id INT,
                                 CONSTRAINT fk_pm_tv FOREIGN KEY (thanh_vien_id) REFERENCES tblThanhVien766(id)
);
-- Bảng tblTaiLieu766
CREATE TABLE tblTaiLieu766 (
                               id SERIAL PRIMARY KEY,
                               ten VARCHAR(100),
                               ngay_xuat_ban DATE,
                               mo_ta TEXT,
                               so_luong INT
);

-- Bảng tblPhieuMuonTaiLieu766
CREATE TABLE tblPhieuMuonTaiLieu766 (
                                        id SERIAL PRIMARY KEY,
                                        ngay_tra DATE,
                                        phieu_muon_id INT,
                                        tai_lieu_id INT,
                                        CONSTRAINT fk_pmtl_pm FOREIGN KEY (phieu_muon_id) REFERENCES tblPhieuMuon766(id),
                                        CONSTRAINT fk_pmtl_tl FOREIGN KEY (tai_lieu_id) REFERENCES tblTaiLieu766(id)
);

-- Bảng tblTacGia766
CREATE TABLE tblTacGia766 (
                              id SERIAL PRIMARY KEY,
                              mo_ta TEXT,
                              ngay_sinh DATE,
                              ho_ten_id INT,
                              dia_chi_id INT,
                              CONSTRAINT fk_tg_ht FOREIGN KEY (ho_ten_id) REFERENCES tblHoTen766(id),
                              CONSTRAINT fk_tg_dc FOREIGN KEY (dia_chi_id) REFERENCES tblDiaChi766(id)
);



-- Bảng tblTheLoai766
CREATE TABLE tblTheLoai766 (
                               id SERIAL PRIMARY KEY,
                               ten VARCHAR(50),
                               mo_ta TEXT
);

-- Bảng tblTacGiaTaiLieu766 (quan hệ n-n giữa TacGia và TaiLieu)
CREATE TABLE tblTacGiaTaiLieu766 (
                                     id SERIAL PRIMARY KEY,
                                     tac_gia_id INT,
                                     tai_lieu_id INT,
                                     CONSTRAINT fk_tgtl_tg FOREIGN KEY (tac_gia_id) REFERENCES tblTacGia766(id),
                                     CONSTRAINT fk_tgtl_tl FOREIGN KEY (tai_lieu_id) REFERENCES tblTaiLieu766(id)
);

-- Bảng tblTheLoaiTaiLieu766 (quan hệ n-n giữa TheLoai và TaiLieu)
CREATE TABLE tblTheLoaiTaiLieu766 (
                                      id SERIAL PRIMARY KEY,
                                      tai_lieu_id INT,
                                      the_loai_id INT,
                                      CONSTRAINT fk_tltl_tl FOREIGN KEY (tai_lieu_id) REFERENCES tblTaiLieu766(id),
                                      CONSTRAINT fk_tltl_tlo FOREIGN KEY (the_loai_id) REFERENCES tblTheLoai766(id)
);

-- Bảng tblNhaCungCap766
CREATE TABLE tblNhaCungCap766 (
                                  id SERIAL PRIMARY KEY,
                                  ten VARCHAR(100),
                                  mo_ta TEXT,
                                  dia_chi_id INT,
                                  CONSTRAINT fk_ncc_dc FOREIGN KEY (dia_chi_id) REFERENCES tblDiaChi766(id)
);

-- Bảng tblHoaDon766
CREATE TABLE tblHoaDon766 (
                              id SERIAL PRIMARY KEY,
                              ngay_nhap DATE,
                              nha_cung_cap_id INT,
                              thanh_vien_id INT,
                              CONSTRAINT fk_hd_ncc FOREIGN KEY (nha_cung_cap_id) REFERENCES tblNhaCungCap766(id),
                              CONSTRAINT fk_hd_tv FOREIGN KEY (thanh_vien_id) REFERENCES tblThanhVien766(id)
);

-- Bảng tblHoaDonNhapTaiLieu766
CREATE TABLE tblHoaDonNhapTaiLieu766 (
                                         id SERIAL PRIMARY KEY,
                                         so_luong INT,
                                         don_gia DECIMAL(10, 2),
                                         hoa_don_id INT,
                                         tai_lieu_id INT,
                                         CONSTRAINT fk_hdntl_hd FOREIGN KEY (hoa_don_id) REFERENCES tblHoaDon766(id),
                                         CONSTRAINT fk_hdntl_tl FOREIGN KEY (tai_lieu_id) REFERENCES tblTaiLieu766(id)
);

-- Thêm dữ liệu vào bảng tblHoTen766
INSERT INTO tblHoTen766 (ho, ten, ten_dem) VALUES
                                               ('Nguyen', 'An', 'Van'),
                                               ('Le', 'Binh', 'Thi'),
                                               ('Tran', 'Cuong', 'Van');

-- Thêm dữ liệu vào bảng tblDiaChi766
INSERT INTO tblDiaChi766 (to_dan_pho, phuong_xa, quan_huyen, tinh, thanh_pho) VALUES
                                                                                  ('1', 'Phuong A', 'Quan B', 'Tinh C', 'Thanh pho D'),
                                                                                  ('2', 'Phuong E', 'Quan F', 'Tinh G', 'Thanh pho H'),
                                                                                  ('3', 'Phuong I', 'Quan J', 'Tinh K', 'Thanh pho L');

-- Thêm dữ liệu vào bảng tblViTri766
INSERT INTO tblViTri766 (ten, mo_ta) VALUES
                                         ('Bạn đọc', 'Độc giả sử dụng hệ thống'),
                                         ('Nhân viên', 'Nhân viên của thư viện'),
                                         ('Quản lý', 'Người quản lý thư viện');

-- Thêm dữ liệu vào bảng tblThanhVien766
INSERT INTO tblThanhVien766 (ten_dang_nhap, mat_khau, ngay_sinh, so_dien_thoai, ho_ten_id, dia_chi_id, vi_tri_id) VALUES
                                                                                                                      ('bandoc', 'bandoc', '1990-01-01', '0123456789', 1, 1, 1),
                                                                                                                      ('nhanvien', 'nhanvien', '1992-02-02', '0987654321', 2, 2, 2),
                                                                                                                      ('quanly', 'quanly', '1994-03-03', '0111222333', 3, 3, 3);

-- Thêm dữ liệu vào bảng tblTheDocTrucTuyen766
INSERT INTO tblTheDocTrucTuyen766 (ngay_bat_dau_hieu_luc, ngay_ket_thuc_hieu_luc, trang_thai, thanh_vien_id) VALUES
    ('2024-01-01', '2024-12-31', TRUE, 1);

-- Thêm dữ liệu vào bảng tblPhieuMuon766
INSERT INTO tblPhieuMuon766 (ngay_muon, han_muon, thanh_vien_id) VALUES
                                                                     ('2024-08-01', '2024-08-15', 1),
                                                                     ('2024-08-02', '2024-08-16', 1),
                                                                     ('2024-08-03', '2024-08-17', 2);

-- Thêm dữ liệu vào bảng tblTaiLieu766
INSERT INTO tblTaiLieu766 (ten, ngay_xuat_ban, mo_ta, so_luong) VALUES
                                                                    ('Sách A', '2022-01-01', 'Một quyển sách hay', 10),
                                                                    ('Sách B', '2022-02-01', 'Một quyển sách khác', 5),
                                                                    ('Sách C', '2022-03-01', 'Sách phổ thông', 6);

-- Thêm dữ liệu vào bảng tblPhieuMuonTaiLieu766
INSERT INTO tblPhieuMuonTaiLieu766 (ngay_tra, phieu_muon_id, tai_lieu_id) VALUES
                                                                              ('2024-08-10', 1, 1),
                                                                              ('2024-08-11', 2, 2),
                                                                              (NULL, 3, 3);

-- Thêm dữ liệu vào bảng tblTacGia766
INSERT INTO tblTacGia766 (mo_ta, ngay_sinh, ho_ten_id, dia_chi_id) VALUES
                                                                       ('Tác giả nổi tiếng', '1970-01-01', 1, 1),
                                                                       ('Tác giả trẻ', '1985-05-05', 2, 2),
                                                                       ('Tác giả chuyên ngành', '1990-10-10', 3, 3);

-- Thêm dữ liệu vào
-- Thêm dữ liệu vào bảng tblPhieuMuonTaiLieu766
INSERT INTO tblPhieuMuonTaiLieu766 (ngay_tra, phieu_muon_id, tai_lieu_id) VALUES
                                                                              ('2024-08-10', 1, 1),
                                                                              ('2024-08-11', 2, 2),
                                                                              (NULL, 3, 3);

-- Thêm dữ liệu vào bảng tblTacGia766
INSERT INTO tblTacGia766 (mo_ta, ngay_sinh, ho_ten_id, dia_chi_id) VALUES
                                                                       ('Tác giả nổi tiếng', '1970-01-01', 1, 1),
                                                                       ('Tác giả trẻ', '1985-05-05', 2, 2),
                                                                       ('Tác giả chuyên ngành', '1990-10-10', 3, 3);

-- Thêm dữ liệu vào bảng tblTacGiaTaiLieu766 (quan hệ n-n giữa TacGia và TaiLieu)
INSERT INTO tblTacGiaTaiLieu766 (tac_gia_id, tai_lieu_id) VALUES
                                                              (1, 1),
                                                              (2, 2),
                                                              (3, 3);

-- Thêm dữ liệu vào bảng tblTheLoai766
INSERT INTO tblTheLoai766 (ten, mo_ta) VALUES
                                           ('Khoa học', 'Tài liệu về khoa học'),
                                           ('Văn học', 'Tài liệu về văn học'),
                                           ('Lịch sử', 'Tài liệu về lịch sử');

-- Thêm dữ liệu vào bảng tblTheLoaiTaiLieu766 (quan hệ n-n giữa TheLoai và TaiLieu)
INSERT INTO tblTheLoaiTaiLieu766 (tai_lieu_id, the_loai_id) VALUES
                                                                (1, 1),
                                                                (2, 2),
                                                                (3, 3);

-- Thêm dữ liệu vào bảng tblNhaCungCap766
INSERT INTO tblNhaCungCap766 (ten, mo_ta, dia_chi_id) VALUES
                                                          ('Nhà cung cấp A', 'Chuyên cung cấp tài liệu khoa học', 1),
                                                          ('Nhà cung cấp B', 'Chuyên cung cấp tài liệu văn học', 2),
                                                          ('Nhà cung cấp C', 'Chuyên cung cấp tài liệu lịch sử', 3);

-- Thêm dữ liệu vào bảng tblHoaDon766
INSERT INTO tblHoaDon766 (ngay_nhap, nha_cung_cap_id, thanh_vien_id) VALUES
                                                                         ('2024-08-05', 1, 2),
                                                                         ('2024-08-06', 2, 2),
                                                                         ('2024-08-07', 3, 2);

-- Thêm dữ liệu vào bảng tblHoaDonNhapTaiLieu766
INSERT INTO tblHoaDonNhapTaiLieu766 (so_luong, don_gia, hoa_don_id, tai_lieu_id) VALUES
                                                                                     (10, 100.00, 1, 1),
                                                                                     (5, 200.00, 2, 2),
                                                                                     (7, 150.00, 3, 3);
