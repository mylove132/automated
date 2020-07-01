package com.xdf.bling.qa.common.config;

import com.xdf.bling.qa.common.enums.ConfigType;
import com.xdf.bling.qa.common.utils.PropertiesUtil;
import com.xdf.bling.qa.common.utils.ZookeeperUtil;

public class InitializationConfigFile {

    public void initConfig (ConfigType configType, String serviceName) {
        PropertiesUtil propertiesUtil = new PropertiesUtil();
        ZookeeperUtil zookeeperUtil = new ZookeeperUtil();
        switch (configType) {
            case ZOOKEEPER:
                zookeeperUtil.load(serviceName);
                break;
            case PROPERTIES:
                propertiesUtil.loadProperties();
                break;
        }
    }

}

