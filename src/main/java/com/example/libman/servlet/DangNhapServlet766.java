package com.example.libman.servlet;

import com.example.libman.dao.ThanhVienDAO766;
import com.example.libman.model.ThanhVien766;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "dangNhap", value = "/dang-nhap")
public class DangNhapServlet766 extends HttpServlet {
    private ThanhVienDAO766 thanhVienDAO766;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        thanhVienDAO766 = new ThanhVienDAO766();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String tenDangNhap = req.getParameter("tenDangNhap");
        String matKhau = req.getParameter("matKhau");

        ThanhVien766 taiKhoan = new ThanhVien766();
        taiKhoan.setTenDangNhap(tenDangNhap);
        taiKhoan.setMatKhau(matKhau);

        if(thanhVienDAO766.kiemTraDangNhap(taiKhoan)) {
            HttpSession session = req.getSession();
            session.setAttribute("thanhVien", taiKhoan);
            String url = "";
            if(taiKhoan.getViTri().getId() == 1)
                url = "view/bandoc/gdDocGiaChinh766.jsp";
            else if(taiKhoan.getViTri().getId() == 2)
                url = "view/nhanvien/gdNhanVienChinh766.jsp";
            else
                url = "view/quanly/gdNhanVienQuanLyChinh766.jsp";
            resp.sendRedirect(url);
        } else {
            resp.sendRedirect("view/gdDangNhap766.jsp");
        }
    }
}
