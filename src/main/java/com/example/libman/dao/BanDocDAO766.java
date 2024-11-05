package com.example.libman.dao;

import com.example.libman.model.*;
import com.example.libman.utils.RepositoryUtils;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class BanDocDAO766 extends DAO{
    public List<BanDoc766> timPhieuMuonTheoThoiGian(LocalDate ngayMuon, LocalDate hanMuon) {
        try {
            String sql = """
                    SELECT
                        tv.id,
                        ht.id,
                        ht.ten,
                        ht.ho,
                        ht.ten_dem,
                        dc.id,
                        pm.id,
                        pm.ngay_muon,
                        pm.han_muon
                    FROM tblthanhvien766 tv
                    JOIN tblhoten766 ht on ht.id = tv.ho_ten_id
                    JOIN tbldiachi766 dc on dc.id = tv.dia_chi_id
                    JOIN tblphieumuon766 pm on tv.id = pm.thanh_vien_id
                    WHERE pm.ngay_muon >= ? and pm.han_muon <= ?
                    ORDER BY pm.ngay_muon
                    """;
            PreparedStatement ps = con.prepareStatement(sql);
            int i = 0;
            ps.setDate(++i, Date.valueOf(ngayMuon));
            ps.setDate(++i, Date.valueOf(hanMuon));
            ResultSet rs = ps.executeQuery();
            List<BanDoc766> list = new ArrayList<>();
            Map<Integer, BanDoc766> thanhVienMap = new HashMap<>();
            while (rs.next()) {
                int index = 0;
                int thanhVienId = RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class);
                BanDoc766 thanhVien = null;
                if (!thanhVienMap.containsKey(thanhVienId)) {
                    thanhVien = new BanDoc766();
                    thanhVien.setId(thanhVienId);

                    HoTen766 hoTen = new HoTen766();
                    hoTen.setId(RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class));
                    hoTen.setTen(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));
                    hoTen.setHo(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));
                    hoTen.setTenDem(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));

                    DiaChi766 diaChi = new DiaChi766();
                    diaChi.setId(RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class));

                    thanhVien.setHoTen(hoTen);
                    thanhVien.setDiaChi(diaChi);
                    thanhVien.setPhieuMuons(new HashSet<>());
                    thanhVienMap.put(thanhVienId, thanhVien);
                } else {
                    thanhVien = thanhVienMap.get(thanhVienId);
                }

                index = 6;
                PhieuMuon766 phieuMuon766 = new PhieuMuon766();
                phieuMuon766.setId(RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class));
                phieuMuon766.setNgayMuon(RepositoryUtils.getResultValue(rs.getObject(++index), LocalDate.class));
                phieuMuon766.setHanMuon(RepositoryUtils.getResultValue(rs.getObject(++index), LocalDate.class));

                Set<PhieuMuon766> phieuMuons = thanhVien.getPhieuMuons();
                phieuMuons.add(phieuMuon766);
                thanhVien.setPhieuMuons(phieuMuons);
                thanhVienMap.put(thanhVienId, thanhVien);
            }
            for (Map.Entry<Integer, BanDoc766> entry : thanhVienMap.entrySet()) {
                list.add(entry.getValue());
            }
            ps.close();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
