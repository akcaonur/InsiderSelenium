package org.onurakca.config;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.io.*;
import java.util.Properties;

public class PropertiesFile {
    static Properties properties = new Properties();
    public static Logger log = LogManager.getLogger(PropertiesFile.class.getName());

    public static void main(String[] args) {
        readPropertiesFile();
    }
    public static Properties readPropertiesFile() {

        try {
            InputStream input = new FileInputStream("src/test/resources/config.properties");
            try {
                properties.load(input);
                log.info("browserType="+properties.getProperty("browser"));
                log.info("url="+properties.getProperty("url"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static void writePropertiesFile() {
        try {
            OutputStream output = new FileOutputStream("src/test/resources/config.properties");
            properties.setProperty("url", "https://useinsider.com/");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

}
