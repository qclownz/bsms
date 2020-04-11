package net.gxu.bsms.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

public class SessionUtil {
    //唯一的工厂
    private static SqlSessionFactory factory = null;
    private static SessionUtil su;

    //私有化构造方法

    private SessionUtil() {
        try {//读取主配置文档

            InputStream is = Resources.getResourceAsStream("mybatis-config.tld");
            //创建会话工厂
            factory = new SqlSessionFactoryBuilder().build(is);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

    }

    /**
     * 单例模式设计
     */
    public static SessionUtil getInstance() {
        if (su == null)
            return new SessionUtil();
        return su;
    }

    /**
     * 返回新的会话
     */
    public static SqlSession getSession() {
        getInstance();
        return factory.openSession();
    }
}