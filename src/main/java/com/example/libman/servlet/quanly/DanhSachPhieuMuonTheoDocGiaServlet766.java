package com.example.libman.servlet.quanly;

import com.example.libman.dao.PhieuMuonDAO766;
import com.example.libman.model.BanDoc766;
import com.example.libman.model.PhieuMuon766;
import com.example.libman.model.ThanhVien766;
import com.example.libman.model.ThongKeDocGiaTheoSoLanMuon766;
import com.example.libman.utils.ServletUtils;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "danhSachPhieuMuonTheoDocGiaServlet766", value = "/danh-sach-phieu-muon-theo-doc-gia")
public class DanhSachPhieuMuonTheoDocGiaServlet766 extends HttpServlet {
    private PhieuMuonDAO766 phieuMuonDAO766;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        phieuMuonDAO766 = new PhieuMuonDAO766();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if(session.getAttribute("danhSachThongKeDocGiaTheoSoLanMuon") == null) {
            resp.sendRedirect("view/quanly/gdThongKeDocGiaTheoSoLanMuon766.jsp");
            return;
        }
        Integer index = ServletUtils.getParameter(req.getParameter("index"), Integer.class);
        if(index == null) {
            resp.sendRedirect("view/quanly/gdThongKeDocGiaSoLanMuon766.jsp");
            return;
        }
        List<ThongKeDocGiaTheoSoLanMuon766> thanhVienPhieuMuons = (List<ThongKeDocGiaTheoSoLanMuon766>) session.getAttribute("danhSachThongKeDocGiaTheoSoLanMuon");
        if(thanhVienPhieuMuons.isEmpty()) {
            resp.sendRedirect("view/quanly/gdThongKeDocGiaSoLanMuon766.jsp");
            return;
        }
        ThongKeDocGiaTheoSoLanMuon766 thongKeDocGiaTheoSoLanMuon766 = thanhVienPhieuMuons.get(index);
        List<PhieuMuon766> danhSachPhieuMuon = phieuMuonDAO766.timKiemPhieuMuonTheoDocGia(thongKeDocGiaTheoSoLanMuon766);
        session.setAttribute("danhSachPhieuMuon", danhSachPhieuMuon);
        RequestDispatcher rd = req.getRequestDispatcher("/view/quanly/gdDanhSachPhieuMuonTheoDocGia766.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/quanly/gdDanhSachPhieuMuonTheoDocGia766.jsp");
        requestDispatcher.forward(req, resp);
    }
}
