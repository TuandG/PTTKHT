package com.example.libman.servlet.quanly;

import com.example.libman.dao.PhieuMuonDAO766;
import com.example.libman.dao.PhieuMuonTaiLieuDAO766;
import com.example.libman.model.PhieuMuon766;
import com.example.libman.model.PhieuMuonTaiLieu766;
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

@WebServlet(name = "chiTietPhieuMuonServlet766", value = "/chi-tiet-phieu-muon")
public class ChiTietPhieuMuonServlet766 extends HttpServlet {
    private PhieuMuonTaiLieuDAO766 phieuMuonTaiLieuDAO766;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("danh-sach-phieu-muon-theo-doc-gia");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        phieuMuonTaiLieuDAO766 = new PhieuMuonTaiLieuDAO766();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer index = ServletUtils.getParameter(req.getParameter("index"), Integer.class);
        if(index == null){
            resp.sendRedirect("view/quanly/gdDanhSachPhieuMuonTheoDocGia766.jsp");
            return;
        }
        HttpSession session = req.getSession();
        if(session.getAttribute("phieuMuons") == null) {
            resp.sendRedirect("view/quanly/gdDanhSachPhieuMuonTheoDocGia766.jsp");
            return;
        }
        List<PhieuMuon766> phieuMuons = (List<PhieuMuon766>) session.getAttribute("phieuMuons");
        PhieuMuon766 phieuMuon = phieuMuons.get(index);
        List<PhieuMuonTaiLieu766> phieuMuonTaiLieu = phieuMuonTaiLieuDAO766.timChiTietPhieuMuonTaiLieu(phieuMuon);
        session.setAttribute("chiTietPhieuMuons", phieuMuonTaiLieu);
        RequestDispatcher rd = req.getRequestDispatcher("/view/quanly/gdChiTietPhieuMuon766.jsp");
        rd.forward(req, resp);
    }
}
