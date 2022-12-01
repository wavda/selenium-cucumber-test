package tests.utils;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
    public Properties properties;

    public ConfigFileReader() throws IOException {
        properties = new Properties();
        FileReader reader = new FileReader("src/test/resources/config.properties");
        properties.load(reader);
    }
}
