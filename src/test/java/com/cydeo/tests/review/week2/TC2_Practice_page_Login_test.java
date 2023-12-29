package com.cydeo.tests.review.week2;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class TC2_Practice_page_Login_test {
    public static void main(String[] args) {

        // 1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username: "tomsmith"
        WebElement usernameInput = driver.findElement(By.name("username"));
        usernameInput.sendKeys("tomsmith");

        // 4. Enter password: "SuperSecretPassword"
        WebElement passworIput = driver.findElement(By.xpath("//input[@type=\"password\"]"));
        passworIput.sendKeys("SuperSecretPassword");

        // 5. Click to Login button
        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));
        loginButton.click();

        // 6. Verify text displayed on page
//            Expected: "You logged into a secure area!"
        WebElement textDisplayed = driver.findElement(By.cssSelector(".flash.success"));
        String actualText = textDisplayed.getText().trim();
        String expectedText = "You logged into a secure area!\n×";
        System.out.println(actualText);
        if (actualText.equals(expectedText)) {
            System.out.println("Text displayed verification Passed");
        } else {
            System.out.println("Text displayed verification Failed");
        }

    }

}
