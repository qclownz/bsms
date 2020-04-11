package net.gxu.bsms.control.SystemServlet;

import net.gxu.bsms.entity.Admin;
import net.gxu.bsms.service.AdminService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "UpdateAdminServlet", urlPatterns = "/adminpwd")
public class UpdateAdminServlet extends HttpServlet {

    AdminService adminService = new AdminService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
        String adinName = request.getParameter("adminName");
        String adminPwd = request.getParameter("adminPwd");

        Admin admin = new Admin(adinName, adminPwd);
        int flag = adminService.updatePwd(admin);
        out.print(String.valueOf(flag));
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();


    }
}
