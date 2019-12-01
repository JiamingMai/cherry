package com.kapok.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Service
public class ServerInitializer implements InitializingBean {

    private final String CONFIG_FILE_NAME = "config.properties";

    @Autowired
    private ServerConfig serverConfig;

    @Override
    public void afterPropertiesSet() throws Exception {
        // set configuration for this server
        String configFile = this.getClass().getClassLoader().getResource(CONFIG_FILE_NAME).getFile();
        try {
            Properties props = new Properties();
            props.load(new InputStreamReader(new FileInputStream(configFile), "UTF-8"));
            String value = props.getProperty("role");
            serverConfig.setRole(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
