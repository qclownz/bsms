package net.gxu.bsms.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import net.gxu.bsms.entity.Member;
import net.gxu.bsms.service.MemberService;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;


public class Class2JsonTest {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        MemberService memberService = new MemberService();

//        Member member = memberService.getMemberById(10000);
//        System.out.println(member);
//
//        String s = JSON.toJSONString(member);  // JAVA对象转JSON字符串
//        System.out.println(s);



        List<Member> memberList = memberService.getMembersByName("阿西吧");
        JSONArray array= JSONArray.parseArray(JSON.toJSONString(memberList));
        System.out.println(array);



    }
}
