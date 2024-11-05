package com.example.libman.dao;

import com.example.libman.model.*;
import com.example.libman.utils.RepositoryUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.*;

public class TaiLieuDAO766 extends DAO766{
    public TaiLieuDAO766() {
        super();
    }
    public List<TaiLieu766> timTaiLieuTheoTen(TaiLieu766 taiLieuTimKiem){
        try {
            List<TaiLieu766> list = new ArrayList<TaiLieu766>();
            String sql = """
                SELECT
                    tl.id,
                    tl.ten,
                    tl.ngay_xuat_ban,
                    tl.mo_ta,
                    tl.so_luong,
                    tlo.id,
                    tlo.ten,
                    tlo.mo_ta,
                    tg.id,
                    tg.ngay_sinh,
                    tg.mo_ta,
                    ht.id,
                    ht.ten,
                    ht.ho,
                    ht.ten_dem
                FROM tbltailieu766 tl
                JOIN tbltacgiatailieu766 tgtl on tgtl.tai_lieu_id = tl.id
                JOIN tbltacgia766 tg on tg.id = tgtl.tac_gia_id
                JOIN tbltheloaitailieu766 tltl on tltl.tai_lieu_id = tl.id
                JOIN tbltheloai766 tlo on tlo.id = tltl.the_loai_id
                JOIN tblhoten766 ht on ht.id = tg.ho_ten_id
                where tl.ten like ?
                ORDER BY tl.id
            """;
            PreparedStatement ps = this.con.prepareStatement(sql);
            ps.setString(1, "%"+taiLieuTimKiem.getTen()+"%");
            ResultSet rs = ps.executeQuery();
            HashMap<Integer, TaiLieu766> taiLieuMap = new HashMap<>();
            HashMap<Integer, TheLoai766> theLoaiMap = new HashMap<>();
            HashMap<Integer, TacGia766> tacGiaMap = new HashMap<>();
            while(rs.next()){
                int index = 0;
                int taiLieuId = rs.getInt(++index);
                TaiLieu766 taiLieu = new TaiLieu766();
                if(!taiLieuMap.containsKey(taiLieuId)){
                    taiLieu.setId(taiLieuId);
                    taiLieu.setTen(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));
                    taiLieu.setNgayXuatBan(RepositoryUtils.getResultValue(rs.getObject(++index), LocalDate.class));
                    taiLieu.setMoTa(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));
                    taiLieu.setSoLuong(RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class));
                    taiLieu.setTacGias(new HashSet<>());
                    taiLieu.setTheLoais(new HashSet<>());
                }
                else
                    taiLieu = taiLieuMap.get(taiLieuId);

                index = 5;
                int theLoaiId = RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class);
                TheLoai766 theLoai = new TheLoai766();
                if(!theLoaiMap.containsKey(theLoaiId)){
                    theLoai.setId(theLoaiId);
                    theLoai.setTen(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));
                    theLoai.setMoTa(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));

                    theLoaiMap.put(theLoaiId, theLoai);
                }
                else
                    theLoai = theLoaiMap.get(theLoaiId);

                index = 8;
                int tacGiaId = RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class);
                TacGia766 tacGia = new TacGia766();
                if(!tacGiaMap.containsKey(tacGiaId)){
                    tacGia.setId(tacGiaId);
                    tacGia.setNgaySinh(RepositoryUtils.getResultValue(rs.getObject(++index), LocalDate.class));
                    tacGia.setMoTa(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));

                    HoTen766 hoTen = new HoTen766();
                    hoTen.setId(RepositoryUtils.getResultValue(rs.getObject(++index), Integer.class));
                    hoTen.setTen(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));
                    hoTen.setHo(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));
                    hoTen.setTenDem(RepositoryUtils.getResultValue(rs.getObject(++index), String.class));

                    tacGia.setHoTen(hoTen);

                    tacGiaMap.put(tacGiaId, tacGia);
                }
                else
                    tacGia = tacGiaMap.get(tacGiaId);

                Set<TacGia766> tacGias = taiLieu.getTacGias();
                Set<TheLoai766> theLoais = taiLieu.getTheLoais();

                tacGias.add(tacGia);
                theLoais.add(theLoai);

                taiLieu.setTheLoais(theLoais);
                taiLieu.setTacGias(tacGias);
                taiLieuMap.put(taiLieuId, taiLieu);
            }
            for(Map.Entry<Integer, TaiLieu766> entry : taiLieuMap.entrySet()){
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
