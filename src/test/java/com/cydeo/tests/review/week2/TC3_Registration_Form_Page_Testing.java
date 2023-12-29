package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class TC3_Registration_Form_Page_Testing {
    public static void main(String[] args) {
        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Verify title is as expected:
        String actualTitle = driver.getTitle();
        // Expected: "Registration Form"
        String expectedTitle = "Registration Form";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Title verification Passed");
        }else{
            System.out.println("Title verification Failed");

        }

        driver.close();
    }
}
