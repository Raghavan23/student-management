package com.student.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        Properties props = new Properties();
        InputStream input = DBConnection.class.getClassLoader().getResourceAsStream("db/db_config.properties");
        props.load(input);

        String url = props.getProperty("db.url");
        String username = props.getProperty("db.username");
        String password = props.getProperty("db.password");

        return DriverManager.getConnection(url, username, password);
    }
}
