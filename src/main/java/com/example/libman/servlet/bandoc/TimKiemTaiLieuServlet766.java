package com.example.libman.servlet.bandoc;

import com.example.libman.dao.TaiLieuDAO766;
import com.example.libman.model.TaiLieu766;
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

@WebServlet(name = "timKiemTaiLieuServlet766", value = "/tim-kiem-tai-lieu")
public class TimKiemTaiLieuServlet766 extends HttpServlet {
    private TaiLieuDAO766 taiLieuDAO766;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        taiLieuDAO766 = new TaiLieuDAO766();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String ten = ServletUtils.getParameter(req.getParameter("ten"), String.class);
        TaiLieu766 taiLieuTimKiem = new TaiLieu766();
        taiLieuTimKiem.setTen(ten);
        List<TaiLieu766> taiLieus = taiLieuDAO766.timTaiLieuTheoTen(taiLieuTimKiem);
//        req.setAttribute("taiLieus", taiLieus);
        HttpSession session = req.getSession();
        session.setAttribute("danhSachTaiLieu", taiLieus);
        RequestDispatcher rd = req.getRequestDispatcher("view/bandoc/gdDanhSachTaiLieu766.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.removeAttribute("taiLieus");
        resp.sendRedirect("view/bandoc/gdTimKiemTaiLieu766.jsp");
    }
}
