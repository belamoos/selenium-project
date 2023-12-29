package com.cydeo.tests.review.week2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class TC4_Registration_Form_Page_Filling_Form_Test {
    // 1. Open Chrome browser
    // 2. Go to https://practice.cydeo.com/registration_form
    // 3. Enter First name: "John"
    // 4. Enter Last name: "Smith"
    // 5. Enter Username: "johnsmith123"
    // 6. Enter Email address: "john.smith@email.com"
    // 7. Enter password: "John1234"
    // 8. Enter Phone number: "123-456-7890"
    // 9. Click to "Male" from Gender
    // 10. Enter Date of birth "01/28/1990"
    // 11. Select "Department of Engineering" from Department/Office dropdown
    // 12. Select "SDET" from Job title dropdown
    // 13. Click to "Java" from languages
    // 14. Click to "Sign up" button
    // 15. Verify text displayed on page
    //     Expected: "Well done!"

    public static void main(String[] args) throws InterruptedException {
        // 1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");

        // 3. Enter First name: "John"
        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("John");

        // 4. Enter Last name: "Smith"
        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Smith");

        // 5. Enter Username: "johnsmith123"
        WebElement userName = driver.findElement(By.xpath("//input[@placeholder='username']"));
        userName.sendKeys("johnsmith123");

        // 6. Enter Email address: "john.smith@email.com"
        WebElement emailAddress = driver.findElement(By.xpath("//input[@placeholder='email@email.com']"));
        emailAddress.sendKeys("john.smith@email.com");

        // 7. Enter password: "John1234"
        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.sendKeys("John1234");

        // 8. Enter Phone number: "123-456-7890"
        WebElement phoneNum = driver.findElement(By.xpath("//input[@name='phone']"));
        phoneNum.sendKeys("123-456-7890");

        // 9. Click to "Male" from Gender
        WebElement maleGender = driver.findElement(By.xpath("//input[@value='male']"));
        maleGender.click();

        // 10. Enter Date of birth "01/28/1990"
        WebElement birthDateBox = driver.findElement(By.xpath("//input[@name='birthday']"));
        birthDateBox.sendKeys("01/28/1990");

        // 11. Select "Department of Engineering" from Department/Office dropdown
        Select departmentDropDown = new Select(driver.findElement(By.xpath("//select[@name='department']")));
        departmentDropDown.selectByVisibleText("Department of Engineering");

        // 12. Select "SDET" from Job title dropdown
        Select jobTitleDropdown = new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitleDropdown.selectByVisibleText("SDET");

        // 13. Click to "Java" from languages
        WebElement languagesBox = driver.findElement(By.xpath("//input[@value='java']"));
        languagesBox.click();

        // 14. Click to "Sign up" button
        WebElement signInButton = driver.findElement(By.cssSelector("#wooden_spoon"));
        Thread.sleep(4000);
        signInButton.click();

        // 15. Verify text displayed on page
        //     Expected: "Well done!"

    }
}
