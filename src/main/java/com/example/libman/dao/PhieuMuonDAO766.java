package com.example.libman.dao;

import com.example.libman.model.PhieuMuon766;
import com.example.libman.utils.RepositoryUtils;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PhieuMuonDAO766 extends DAO{
    public PhieuMuonDAO766() {
        super();
    }

    public List<PhieuMuon766> timKiemPhieuMuon(List<PhieuMuon766> phieuMuons) {
        List<Integer> phieuMuonIds = new ArrayList<>();
        if(phieuMuons != null && !phieuMuons.isEmpty()) {
            phieuMuonIds = phieuMuons.stream().map(PhieuMuon766::getId).toList();
        }
        List<PhieuMuon766> res = new ArrayList<>();
        if(phieuMuonIds.isEmpty())
            return res;
        try {
            String sql = """
                    SELECT
                        pm.id,
                        pm.ngay_muon,
                        pm.han_muon, 
                    FROM tblphieumuon766 pm WHERE pm.id in (?) 
                    """;
            Array ids = this.con.createArrayOf("INTEGER", phieuMuonIds.toArray());
            PreparedStatement ps = this.con.prepareStatement(sql);
            int i = 0;
            ps.setArray(++i, ids);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                PhieuMuon766 p = new PhieuMuon766();
                int index = 0;
                p.setId(RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class));
                p.setNgayMuon(RepositoryUtils.getResultValue(rs.getObject(++index), LocalDate.class));
                p.setHanMuon(RepositoryUtils.getResultValue(rs.getObject(++index), LocalDate.class));
                res.add(p);
            }
            ps.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
}
