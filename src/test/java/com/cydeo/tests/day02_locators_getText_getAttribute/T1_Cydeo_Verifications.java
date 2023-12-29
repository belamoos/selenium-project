package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class T1_Cydeo_Verifications {
    public static void main(String[] args) {

        //TC #1: Cydeo practice tool verifications
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //2. Go to https://practice.cydeo.com
        driver.navigate().to("https://practice.cydeo.com");

        //3. Verify URL contains
        //Expected: cydeo
        String expectedInURL = "cydeo";
        String actualURL = driver.getCurrentUrl();

        if (actualURL.contains(expectedInURL)) {
            System.out.println("URL verification Passed!");
        } else {
            System.out.println("URL verification Passed!");

        }

        //4. Verify title:
        //Expected: Practice
        String expectedTitle = "Practice";
        String actualTitle = driver.getTitle(); //--> returns "Practice"

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Pass!");
        }


        //close the browser
        driver.close();
    }
}
