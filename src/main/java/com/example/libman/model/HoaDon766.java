package com.example.libman.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HoaDon766 {
    private int id;
    private LocalDate ngayNhap;
    private NhaCungCap766 nhaCungCap;
    private NhanVienThuVien766 nhanVienThuVien;
}
