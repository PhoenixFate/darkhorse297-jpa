package com.phoenix.test;

import org.apache.log4j.Logger;

/**
 *@author linbingwen
 *@2015年5月18日9:14:21
 */
public class TestLog {
    private static final Logger logger = Logger.getLogger(TestLog.class);

    /**
     * @param args
     */
    public static void main(String[] args) {
        // System.out.println("This is println message.");
        // 记录debug级别的信息
        logger.debug("This is debug message.");
        // 记录info级别的信息
        logger.info("This is info message.");
        // 记录error级别的信息
        logger.error("This is error message.");
    }

}