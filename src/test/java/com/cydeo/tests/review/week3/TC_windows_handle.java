package com.cydeo.tests.review.week3;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TC_windows_handle {
    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void windowsHandlePractice() {
        // TC : Windows handle practice
        //    1. Open browser
        //    2. Go to website: https://demoqa.com/browser-windows
        driver.get("https://demoqa.com/browser-windows");

        //    3. Click on New Tab button
        //    4. Click on New Window button
        //    5. Click on New Window Message button
        driver.findElement(By.xpath("//button[.='New Tab']")).click();
        driver.findElement(By.xpath("//button[.='New Window']")).click();
        driver.findElement(By.xpath("//button[.='New Window Message']")).click();

        //    6. Store parent window handle id in a variable
        String parentWindowHandle = driver.getWindowHandle();

        //    7. Store all window handle ids in to a Set
        Set<String> windowsList = driver.getWindowHandles();

        //    9. Print out each window title
        for (String each : windowsList) {
            driver.switchTo().window(each);
            BrowserUtils.sleep(10);
            System.out.println(driver.getTitle());
            //System.out.println(driver.getCurrentUrl());
        }

        //driver.switchTo().window(parentWindowHandle);
    }
}