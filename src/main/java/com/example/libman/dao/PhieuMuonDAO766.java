package com.example.libman.dao;

import com.example.libman.model.PhieuMuon766;
import com.example.libman.model.ThongKeDocGiaTheoSoLanMuon766;
import com.example.libman.utils.RepositoryUtils;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhieuMuonDAO766 extends DAO766{
    public PhieuMuonDAO766() {
        super();
    }

    public List<PhieuMuon766> timKiemPhieuMuonTheoDocGia(ThongKeDocGiaTheoSoLanMuon766 thongKeDocGiaTheoSoLanMuon766) {
        List<PhieuMuon766> list = new ArrayList<>();
        try {
            String sql = """
                    SELECT
                        pm.id,
                        pm.ngay_muon,
                        pm.han_muon
                    FROM tblPhieuMuon766 pm 
                    WHERE pm.thanh_vien_id = ?
                    """;
            PreparedStatement ps = this.con.prepareStatement(sql);
            int index = 0;
            ps.setInt(++index, thongKeDocGiaTheoSoLanMuon766.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int i = 0;
                PhieuMuon766 p = new PhieuMuon766();
                p.setId(RepositoryUtils.getResultValue(rs.getObject(++i), Integer.class));
                p.setNgayMuon(RepositoryUtils.getResultValue(rs.getObject(++i), LocalDate.class));
                p.setHanMuon(RepositoryUtils.getResultValue(rs.getObject(++i), LocalDate.class));
                p.setThanhVien(thongKeDocGiaTheoSoLanMuon766);

                list.add(p);
            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return list;
        }
    }
}
