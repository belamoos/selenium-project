package com.cydeo.tests.review.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TC1_Navigations_Get_methods_Practice {
    public static void main(String[] args) {
        // 1. Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 2. Go to: https://www.etsy.com
        driver.get("https://www.etsy.com");

        // 3. Navigate to https://www.amazon.com/
        driver.navigate().to("https://www.amazon.com/");

        // 4. Navigate back, forward and refresh
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        // 5. Write “selenium” in search box
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("selenium");

        // 6. Press search button to search
        WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
        searchButton.click();

        // 7. Verify title is "Amazon.com : selenium"
        String expectedTitle = "Amazon.com : selenium";
        String actualTitle = driver.getTitle();

        if(actualTitle.equals(expectedTitle)){
            System.out.println("The title verification Passed");
        }else {
            System.out.println("The title verification Failed");
        }
        // 8. Verify url contains "selenium"
        String expectedInURL = "selenium";
        String actualURL = driver.getCurrentUrl();
        if (actualURL.contains(expectedInURL)){
            System.out.println("The URL verification Passed");
        }else {
            System.out.println("The URL verification Failed");

        }



    }
}
