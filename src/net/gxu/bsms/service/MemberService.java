package net.gxu.bsms.service;

import net.gxu.bsms.entity.Member;
import net.gxu.bsms.dao.MemberMapper;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class MemberService {

    public Member getMemberById(int id) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话

        try {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            return memberMapper.getMemberById(id);

        } finally {
            sqlSession.close();
        }
    }

    public Member getMemberByTel(String tel) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话

        try {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            return memberMapper.getMemberByTel(tel);

        } finally {
            sqlSession.close();
        }
    }

    public List<Member> getMembersByName(String name) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话

        try {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            return memberMapper.getMembersByName(name);

        } finally {
            sqlSession.close();
        }
    }

    public List<Member> getAllMembers() {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话

        try {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            return memberMapper.getAllMembers();
        } finally {
            sqlSession.close();
        }
    }



    public int addMember(Member member) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            result = memberMapper.addMember(member);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    }

    public int updateMemberById(Member member) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            result = memberMapper.updateMemberById(member);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    }

    public int deleteMemberById(int id) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();  // 获取一个会话
        int result = 0;
        try {
            MemberMapper memberMapper = sqlSession.getMapper(MemberMapper.class);
            result = memberMapper.deleteMemberById(id);
            sqlSession.commit();
        } finally {
            sqlSession.close();
            return result;
        }
    }

}
