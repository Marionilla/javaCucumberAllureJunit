package com.saucedemo.proj.config;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class YourPropertiesReader {
    private static final YourPropertiesReader instance = new YourPropertiesReader();
    private Properties properties;

    private YourPropertiesReader() {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream("src/test/java/com/saucedemo/proj/config/test.properties")) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static YourPropertiesReader getInstance() {
        return instance;
    }


    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
