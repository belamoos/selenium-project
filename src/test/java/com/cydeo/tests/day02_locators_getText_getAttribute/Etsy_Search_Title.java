package com.cydeo.tests.day02_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Etsy_Search_Title {
    public static void main(String[] args) throws InterruptedException {
        //HWP #1: Etsy Title Verification
        //1. Open Chrome browser
        //Setting up our chromedriver using WebDriverManager
        WebDriverManager.chromedriver().setup();

        //Creating a new ChromeDriver and storing it in "driver"
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //2. Go to https://www.etsy.com
        driver.get("https://www.etsy.com");

        //3. Search for “wooden spoon”
        WebElement searchButton = driver.findElement(By.id("global-enhancements-search-query"));
        Thread.sleep(3000);
        searchButton.sendKeys("Wooden spoon" + Keys.ENTER);


        //4. Verify title:
        //Expected: “Wooden spoon - Etsy”
        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = driver.getTitle();

        //create a simple if condition to compare our actual and expected titles
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Title Test Passed!");
        } else {
            System.out.println("Title Test Failed!");
        }

        //close the browser



    }

}
