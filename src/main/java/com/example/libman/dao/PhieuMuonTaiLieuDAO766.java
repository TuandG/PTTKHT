package com.example.libman.dao;

import com.example.libman.model.PhieuMuon766;
import com.example.libman.model.PhieuMuonTaiLieu766;
import com.example.libman.model.TaiLieu766;
import com.example.libman.utils.RepositoryUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhieuMuonTaiLieuDAO766 extends DAO{
    public PhieuMuonTaiLieuDAO766() {
        super();
    }

    public List<PhieuMuonTaiLieu766> timChiTietPhieuMuonTaiLieu(PhieuMuon766 phieuMuon){
        try {
            List<PhieuMuonTaiLieu766> phieuMuonTaiLieus = new ArrayList<>();
            int phieuMuonId = phieuMuon.getId();
            String sql = """
                    SELECT
                        tl.id,
                        tl.ten,
                        pmtl.ngay_tra
                    FROM tblphieumuontailieu766 pmtl
                    JOIN tbltailieu766 tl on tl.id = pmtl.tai_lieu_id
                    JOIN tblphieumuon766 pm on pmtl.phieu_muon_id = pm.id
                    WHERE pm.id = ?
                    """;
            PreparedStatement ps = this.con.prepareStatement(sql);
            int i = 0;
            ps.setInt(++i, phieuMuonId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int index = 0;

                TaiLieu766 tl = new TaiLieu766();
                tl.setId(RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class));
                tl.setTen(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));

                PhieuMuonTaiLieu766 pmtl = new PhieuMuonTaiLieu766();
                pmtl.setNgayTra(RepositoryUtils.getResultValue(rs.getObject(++index), LocalDate.class));
                pmtl.setPhieuMuon(phieuMuon);
                pmtl.setTaiLieu(tl);
                phieuMuonTaiLieus.add(pmtl);
            }
            ps.close();
            return phieuMuonTaiLieus;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
