package com.cydeo.tests.day01_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {
    public static void main(String[] args) throws InterruptedException {

        //1- Setting up the webdriver manager:
        WebDriverManager.chromedriver().setup();

        //2- Instantiating Chrome browser Driver:
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //3- Testing if the driver and the browser are working as expected:
        driver.get("https://www.google.com");

        Thread.sleep(2000);

        driver.navigate().to("https://www.youtube.com");

        Thread.sleep(3000);

        driver.navigate().back();

        Thread.sleep(2000);

        driver.navigate().forward();

        Thread.sleep(3000);

        driver.get("http://www.google.com");


        driver.findElement(By.className("gLFyf")).sendKeys("Headphones", Keys.ENTER);





    }

}
