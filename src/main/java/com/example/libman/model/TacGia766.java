package com.example.libman.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TacGia766 {
    private int id;
    private HoTen766 hoTen;
    private LocalDate ngaySinh;
    private DiaChi766 diaChi;
    private String moTa;
}
