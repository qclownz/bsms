package net.gxu.bsms.dao;

import net.gxu.bsms.entity.Member;

import java.util.List;

public interface MemberMapper {
    Member getMemberById(int id);
    Member getMemberByTel(String tel);
    List<Member> getMembersByName(String name);
    List<Member> getAllMembers();

    int addMember(Member member);

    int updateMemberById(Member member);

    int deleteMemberById(int id);

}
