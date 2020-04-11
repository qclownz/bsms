package net.gxu.bsms.test;

import net.gxu.bsms.entity.Book;
import net.gxu.bsms.entity.Member;
import net.gxu.bsms.service.MemberService;
import net.gxu.bsms.util.TimerUtil;

import java.util.Date;
import java.util.List;

public class MemberTest {
    public static void printMembers(List<Member> memberList) {
        for(Member member: memberList){
            System.out.println(member);
        }

    }
    public static void main(String[] args) {
        int i;
        Member member;
        List<Member> memberList;
        MemberService memberService = new MemberService();
//        member = memberService.getMemberById(10000);
        member = memberService.getMemberByTel("17635635");

//        memberList = memberService.getMembersByName("小");
//        memberList = memberService.getAllMembers();
//        printMembers(memberList);
//        System.out.println(member);

//        member = new Member(0.91f, "朱重七", "13736300211", new Date());
//        i = memberService.addMember(member);
//        member.setId(10012);
//        i = memberService.updateMemberById(member);
//        i = memberService.deleteMemberById(10012);
        System.out.println(member);


    }
}
//