package com.example.libman.model;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class TaiLieu766 {
    private int id;
    private String ten;
    private LocalDate ngayXuatBan;
    private String moTa;
    private int soLuong;
    private Set<TacGia766> tacGias;
    private Set<TheLoai766> theLoais;

    public String getTenTacGia() {
        StringBuilder sb = new StringBuilder();
        for(TacGia766 tacGia : tacGias) {
            sb.append(tacGia.getHoTen().toString()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }

    public String getTenTheLoai() {
        StringBuilder sb = new StringBuilder();
        for(TheLoai766 theLoai : theLoais) {
            sb.append(theLoai.getTen()).append(", ");
        }
        return sb.substring(0, sb.length() - 2);
    }
}
