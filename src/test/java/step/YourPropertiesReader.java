package step;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class YourPropertiesReader {
    private static Properties properties;

    public YourPropertiesReader(String propertyFileName) {
        properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(propertyFileName)) {
            properties.load(fileInputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static String getUrl() {
        return properties.getProperty("url");
    }
    public String getPropertyValue(String scenarioName, String propertyName) {
       // String key = scenarioName + "." + propertyName;
        return properties.getProperty(propertyName);
    }
}
