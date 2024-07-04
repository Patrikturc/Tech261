package com.sparta.pt.database;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class DatabaseProperties {
    private final String filePath;

    public DatabaseProperties(String filePath) {
        this.filePath = filePath;
    }

    public Properties getProperties() {
        Properties properties = new Properties();
        try {
            properties.load(new FileReader(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Failed to load properties file: " + filePath, e);
        }
        return properties;
    }
}
