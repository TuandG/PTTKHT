package com.example.libman.dao;

import com.example.libman.model.*;
import com.example.libman.utils.RepositoryUtils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class ThanhVienDAO766 extends DAO766 {
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
    public List<ThongKeDocGiaTheoSoLanMuon766> thongKeDocGiaTheoSoLanMuon(LocalDate ngayBatDau, LocalDate ngayKetThuc){
        List<ThongKeDocGiaTheoSoLanMuon766> list = new ArrayList<>();
        try {
            String sql = """
                with dt as (SELECT
                    tv.id,
                    tv.ho_ten_id,
                    count(*) as so_lan_muon
                FROM tblThanhVien766 tv
                     JOIN tblPhieuMuon766 pm on pm.thanh_vien_id = tv.id
                WHERE pm.ngay_muon >= ? and pm.han_muon <= ?
                GROUP BY tv.id)
                SELECT
                    dt.id,
                    dt.so_lan_muon,
                    ht.id,
                    ht.ten,
                    ht.ten_dem,
                    ht.ho
                FROM dt
                JOIN tblHoTen766 ht on dt.ho_ten_id = ht.id;
                """;
            PreparedStatement ps = this.con.prepareStatement(sql);
            int i = 0;
            ps.setDate(++i, Date.valueOf(ngayBatDau));
            ps.setDate(++i, Date.valueOf(ngayKetThuc));
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int index = 0;
                ThongKeDocGiaTheoSoLanMuon766 tk = new ThongKeDocGiaTheoSoLanMuon766();
                tk.setId(RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class));
                tk.setSoPhieuMuon(RepositoryUtils.getResultValue(rs.getObject(++index), Long.class));

                HoTen766 hoTen = new HoTen766();
                hoTen.setId(RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class));
                hoTen.setTen(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));
                hoTen.setTenDem(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));
                hoTen.setHo(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));

                tk.setHoTen(hoTen);

                list.add(tk);
            }
            ps.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }
}
