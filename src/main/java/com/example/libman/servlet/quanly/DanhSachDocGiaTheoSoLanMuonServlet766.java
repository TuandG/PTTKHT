package com.example.libman.servlet.quanly;

import com.example.libman.dao.ThanhVienDAO766;
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
import java.time.LocalDate;
import java.util.List;

@WebServlet(value = "/danh-sach-doc-gia-theo-so-lan-muon", name = "danhSachDocGiaTheoSoLanMuonServlet766")
public class DanhSachDocGiaTheoSoLanMuonServlet766 extends HttpServlet {
    private ThanhVienDAO766 thanhVienDAO;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        thanhVienDAO = new ThanhVienDAO766();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/view/quanly/gdDanhSachDocGiaTheoSoLanMuon766.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LocalDate ngayMuon = ServletUtils.getParameter(req.getParameter("ngayMuon"), LocalDate.class);
        LocalDate hanMuon = ServletUtils.getParameter(req.getParameter("hanMuon"), LocalDate.class);
        String url;
        if(hanMuon.isBefore(ngayMuon)){
            String error = "Hạn mượn phải sau ngày mượn";
            req.setAttribute("error", error);
            url = "/view/quanly/gdThongKeDocGiaTheoSoLanMuon766.jsp";
        }
        else {
            List<ThongKeDocGiaTheoSoLanMuon766> thanhVienPhieuMuons = thanhVienDAO.thongKeDocGiaTheoSoLanMuon(ngayMuon, hanMuon);
            HttpSession session = req.getSession();
            session.setAttribute("danhSachThongKeDocGiaTheoSoLanMuon", thanhVienPhieuMuons);
            url = "/view/quanly/gdDanhSachDocGiaTheoSoLanMuon766.jsp";
        }
        RequestDispatcher rd = req.getRequestDispatcher(url);
        rd.forward(req, resp);
    }
}
