package net.gxu.bsms.service;

import net.gxu.bsms.dao.AdminMapper;
import net.gxu.bsms.entity.Admin;
import org.apache.ibatis.session.SqlSession;

public class AdminService {

    // 查询管理员
    public Admin getAdminByName (String name) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();
        try {
            AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
            return adminMapper.getAdminByName(name);
        } finally {
            sqlSession.close();
        }
    }

    // 修改管理员密码
    public int updatePwd(Admin admin) {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();
        int result = 0;
        try {
        AdminMapper adminMapper = sqlSession.getMapper(AdminMapper.class);
        result = adminMapper.updatePwd(admin);
        sqlSession.commit();
        }
        finally {
            sqlSession.close();
            return result;
        }

    }




}


