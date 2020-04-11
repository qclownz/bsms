package net.gxu.bsms.service;

import net.gxu.bsms.dao.AdminMapper;
import net.gxu.bsms.dao.InfoMapper;
import net.gxu.bsms.entity.AllInfo;
import net.gxu.bsms.entity.NowInfo;
import org.apache.ibatis.session.SqlSession;

public class InfoService {

    public AllInfo getAllInfo() {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();
        try {
            InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);
            return infoMapper.getAllInfo();
        } finally {
            sqlSession.close();
        }
    }

    public NowInfo getNowInfo() {
        SqlSession sqlSession = net.gxu.bsms.util.SessionUtil.getSession();
        try {
            InfoMapper infoMapper = sqlSession.getMapper(InfoMapper.class);
            return infoMapper.getNowInfo();
        } finally {
            sqlSession.close();
        }
    }
}
