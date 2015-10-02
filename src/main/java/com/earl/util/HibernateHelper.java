package com.earl.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

/**
 */
public final class HibernateHelper {
    /**
     * log4j实例对象.
     */
    private static Logger logger = LogManager.getLogger(HibernateHelper.class
            .getName());

    /**
     * Session工厂.
     */
    private static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    /**
     * 私有构造方法.
     * 
     */
    private HibernateHelper() {
    }

    /**
     * 创建Session工厂.
     * 
     * @return Session工厂.
     */
    private static SessionFactory buildSessionFactory() {
        logger.debug("进入buildSessionFactory方法");
        SessionFactory result = null;
        try {
            // 根据hibernate.cfg.xml创建Session工厂
            Configuration cfg = new Configuration().configure();
            
            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder();
            result = cfg.buildSessionFactory(ssrb.applySettings(cfg.getProperties()).build());
        } catch (Throwable e) {
            // 记录异常
            logger.error("初始化SessionFactory时，创建失败：", e);
            e.printStackTrace();
        }
        logger.debug("退出buildSessionFactory方法");
        return result;
    }

    /**
     * @return 获取的sessionFactory
     */
    public static SessionFactory getSessionFactory() {
        return SESSION_FACTORY;
    }
}
