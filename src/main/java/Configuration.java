package main.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {
    private Properties prop;
    private static Configuration instance = null;

    private Configuration() {
        // Exists only to defeat instantiation.
    }

    public static Configuration getInstance() {
        if(instance == null) {
            instance = new Configuration();
            instance.prop = new Properties();
            instance.readProperties();

        }
        return instance;
    }

    private void readProperties() {

        InputStream input = null;

        try {

            input = new FileInputStream("config.properties");
            // load a properties file
            instance.prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Properties getProperties() {
        return this.prop;
    }


}
