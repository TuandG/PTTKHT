package com.example.libman.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ThanhVien766 {
    private int id;
    private String tenDangNhap;
    private String matKhau;
    private LocalDate ngaySinh;
    private String soDienThoai;
    private DiaChi766 diaChi;
    private HoTen766 hoTen;
    private ViTri766 viTri;
}
