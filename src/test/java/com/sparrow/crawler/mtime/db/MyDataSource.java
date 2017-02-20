package com.sparrow.crawler.mtime.db;

import org.apache.tomcat.jdbc.pool.DataSource;

public class MyDataSource {

    public static DataSource getDataSource(String connectURI){

    	DataSource ds = new DataSource();
         //MySQL的jdbc驱动
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUsername("root");              //所要连接的数据库名
        ds.setPassword("112233");                //MySQL的登陆密码
        ds.setUrl(connectURI);

        return ds;

    }

}