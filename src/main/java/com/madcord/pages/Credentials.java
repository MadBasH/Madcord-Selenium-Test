package com.madcord.pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Credentials {
    private Properties properties = new Properties();

    public Credentials() {
        try {
            FileInputStream input = new FileInputStream("credentials.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return properties.getProperty("username");
    }

    public String getPassword() {
        return properties.getProperty("password");
    }
}
