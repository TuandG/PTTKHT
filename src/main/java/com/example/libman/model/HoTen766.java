package com.example.libman.model;

import lombok.Data;

@Data
public class HoTen766 {
    private int id;
    private String ten;
    private String ho;
    private String tenDem;

    @Override
    public String toString() {
        return this.ho + " " + this.ten + " " + this.tenDem;
    }
}
