package net.gxu.bsms.control.MemberServlet;

import com.alibaba.fastjson.JSON;
import net.gxu.bsms.entity.Member;
import net.gxu.bsms.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "MemberSelectServlet", urlPatterns = "/member/select")
public class MemberSelectServlet extends HttpServlet {

    MemberService memberService = new MemberService();
    String memberJson;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");  // 响应类型
        PrintWriter out = response.getWriter();
        String need = request.getParameter("need");

        List<Member> memberList = new ArrayList<>();
        Member member;
        switch (need) {
            case "0":
                int memberId = Integer.valueOf(request.getParameter("memberSelectInfo"));
                member = memberService.getMemberById(memberId);
                if(member == null)
                    break;
                memberList.add(member);
                break;
            case "1":
                String memberName = request.getParameter("memberSelectInfo");
                memberList = memberService.getMembersByName(memberName);
                break;
            case "2":
                String memberTel = request.getParameter("memberSelectInfo");
                member = memberService.getMemberByTel(memberTel);
                if(member == null)
                    break;
                memberList.add(member);
                break;
            case "3":
                memberList = memberService.getAllMembers();
                break;
        }
        memberJson = JSON.toJSONString(memberList);
        out.print(memberJson);
        out.close();

    }
}
