package kz.epam.webb.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Prep {
    public static void main(String[] args) {
        Properties properties = new Properties();
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream("database.properties");
            properties.load(inputStream);
            String str = inputStream.toString();
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
