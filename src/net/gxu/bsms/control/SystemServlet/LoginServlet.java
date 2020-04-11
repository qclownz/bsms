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

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    AdminService adminService = new AdminService();
    Admin admin = null;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
        // 获取请求参数
        String name = request.getParameter("usename");
        String pwd = request.getParameter("usepwd");
        // 返回数据
        admin = adminService.getAdminByName(name);
        if (admin == null) {
            out.print("-1");
        } else {
            if (pwd.equals(admin.getPassword())) {
                out.print("1");
            } else {
                out.print("0");
            }
        }
        // 关闭数据传送
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
