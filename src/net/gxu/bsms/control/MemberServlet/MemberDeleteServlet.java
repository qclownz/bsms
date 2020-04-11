package net.gxu.bsms.control.MemberServlet;

import net.gxu.bsms.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MemberDeleteServlet", urlPatterns = "/member/delete")
public class MemberDeleteServlet extends HttpServlet {
    MemberService memberService = new MemberService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();

        int memberId = Integer.valueOf(request.getParameter("memberId"));

        int flag = memberService.deleteMemberById(memberId);
        if (flag == 0)
            out.print("0");
        else
            out.print("1");
        out.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
    }
}
