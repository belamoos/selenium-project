package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroBank_header {
    public static void main(String[] args) {

        //HWP #2: Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");


        //3. Verify header text
        //Expected: “Log in to ZeroBank”

        String expectedHeader = "Log in to ZeroBank";
        WebElement logIn = driver.findElement(By.tagName("h3"));
        String actualHeader = logIn.getText();

        //verification of actual vs expected
        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Header verification Pased!");
        } else {
            System.out.println("Header verification Failed!");

        }

        driver.close();
    }

}
