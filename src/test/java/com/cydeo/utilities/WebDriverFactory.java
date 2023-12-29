package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriverFactory {
    public static WebDriver getDriver(String Browser){
        if (Browser.equalsIgnoreCase("Chrome")){
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        }else if (Browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();

        }else if (Browser.equalsIgnoreCase("Firefox")){
            WebDriverManager.safaridriver().setup();
            return new SafariDriver();
        }else{
            System.out.println("The browser name is invalid or not supported by this method");
            return null;
        }
    }
}
