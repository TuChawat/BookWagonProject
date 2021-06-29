/**
 * Description : BooksWagon.java is test file which is having test cases for Bookswagon.
 * Author      : Tushar Chawat
 * Date        : 08/06/2021
 */

package com.bridgelabz.selenium.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Library implements IConstant {
    public static String getProperty(String CONFIG_PATH, String key)
    {
        String property = "";
        Properties prop = new Properties();

        try
        {
            prop.load(new FileInputStream(CONFIG_PATH));
            property = prop.getProperty(key);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return property;
    }
}
