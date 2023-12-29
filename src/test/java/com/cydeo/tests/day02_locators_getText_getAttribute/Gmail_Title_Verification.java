package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Gmail_Title_Verification {
    public static void main(String[] args) {

        //TC #3: Back and forth navigation
        //1- Open a Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        //2- Go to: https://google.com
        driver.get("https://google.com");

        //3- Click to Gmail from top right.
        //Locating the Gmail link using "linkText" locator
        WebElement gmailLink = driver.findElement(By.linkText("Gmail"));

        //Click to the gmail link
        gmailLink.click();

        //4- Verify title contains:
        //Expected: Gmail
        String expectedTitle = "Gmail";
        String actualTitle = driver.getTitle();

        //System.out.println("actualGmailTitle = " + actualGmailTitle);

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Title Vertification Passed!");
        }else {
            System.out.println("Title Vertification Failed!");

        }

        //5- Go back to Google by using the .back();
       driver.navigate().back();

        //6- Verify title equals:
        //Expected: Google
        expectedTitle = "Google";
        actualTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Google title verification Passed!");
        }else {
            System.out.println("Google title verification Passed!");

        }


        driver.close();
    }
}
