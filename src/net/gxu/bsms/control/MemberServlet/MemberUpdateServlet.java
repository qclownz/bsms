package net.gxu.bsms.control.MemberServlet;

import net.gxu.bsms.entity.Member;
import net.gxu.bsms.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MemberUpdateServlet", urlPatterns = "/member/update")
public class MemberUpdateServlet extends HttpServlet {
    MemberService memberService = new MemberService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();

        int memberId = Integer.valueOf(request.getParameter("memberId"));
        String memberName = request.getParameter("memberName");
        float memberDiscount = Float.valueOf(request.getParameter("memberDiscount"));
        String memberTel = request.getParameter("memberTel");

        Member member = new Member(memberId, memberDiscount, memberName, memberTel);
        int flag = memberService.updateMemberById(member);
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
