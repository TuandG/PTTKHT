package com.example.libman.dao;

import com.example.libman.model.*;
import com.example.libman.utils.RepositoryUtils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class ThanhVienDAO766 extends DAO {
    public ThanhVienDAO766() {
        super();
    }

    public boolean kiemTraDangNhap(ThanhVien766 taiKhoan) {
        try {
            String sql = """
            SELECT
                tv.id,
                vt.id
            FROM tblthanhvien766 tv
            JOIN tblvitri766 vt on vt.id = tv.vi_tri_id
            where tv.ten_dang_nhap = ? and tv.mat_khau = ?
            """;
            PreparedStatement ps = this.con.prepareStatement(sql);
            int index = 0;
            ps.setString(++index, taiKhoan.getTenDangNhap());
            ps.setString(++index, taiKhoan.getMatKhau());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int i = 0 ;
                taiKhoan.setId(RepositoryUtils.getResultValue(rs.getObject(++i), Integer.class));
                ViTri766 viTri = new ViTri766();
                viTri.setId(RepositoryUtils.getResultValue(rs.getObject(++i), Integer.class));
                taiKhoan.setViTri(viTri);
            }
            ps.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
