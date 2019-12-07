package com.kapok;

import com.kapok.model.discovery.ServerConfig;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

@Service
public class ServerInitializer implements InitializingBean {

    private final String CONFIG_FILE_NAME = "config.properties";

    /**
     * this flag represent if config.properties has been loaded
     */
    private boolean loaded = false;

    @Autowired
    protected ServerConfig serverConfig;

    public void loadConfig() {
        // set configuration for this server
        if (!loaded) {
            String configFile = this.getClass().getClassLoader().getResource(CONFIG_FILE_NAME).getFile();
            try {
                Properties props = new Properties();
                props.load(new InputStreamReader(new FileInputStream(configFile), "UTF-8"));
                serverConfig.setRole(props.getProperty("role"));
                serverConfig.setAddress(props.getProperty("address"));
                serverConfig.setCoordinatorAddress(props.getProperty("coordinator.address"));
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                loaded = true;
            }
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        loadConfig();
    }

}
