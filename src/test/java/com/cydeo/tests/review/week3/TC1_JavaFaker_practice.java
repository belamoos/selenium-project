package com.cydeo.tests.review.week3;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.CRM_Utils;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TC1_JavaFaker_practice {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.sleep(3);
        driver.quit();
    }

    @Test(priority = 1)
    public void JavaFakerTest() {
// TC: Java Faker practice
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/login
        driver.get("https://practice.cydeo.com/login");

        // 3. Enter username using java faker
        //driver.findElement(By.name("username"));
        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        Faker faker = new Faker();
        usernameInput.sendKeys(faker.name().username());

        // 4. Enter password using java faker
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        passwordInput.sendKeys(faker.number().digits(6));

        // 5. Click to Login button
        //WebElement logInBtn = driver.findElement(By.cssSelector(".btn.btn-primary"));
        WebElement logInBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        logInBtn.click();
        BrowserUtils.sleep(3);

        // 6. Verify text displayed on page
        //    Expected: "Your username is invalid!"
        WebElement messageDisplayed = driver.findElement(By.xpath("//*[normalize-space(text())='Your username is invalid!']"));
        String expectedText = "Your username is invalid!";
        String actualText = messageDisplayed.getText();
        Assert.assertTrue(actualText.contains(expectedText));
    }

    @Test(priority = 2)
    public void alertPractice() {
        //// TC : Alert practice
        //// 1. Open browser
        //// 2. Go to website: https://practice.cydeo.com/javascript_alerts
        driver.get("https://practice.cydeo.com/javascript_alerts");

        //// 3. Click to “Click for JS Prompt” button
        WebElement jsPrompt = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        jsPrompt.click();

        //// 4. Send “hello” text to alert
        Alert jsPromptAlert = driver.switchTo().alert();
        jsPromptAlert.sendKeys("hello");
        BrowserUtils.sleep(3);

        //// 5. Click to OK button from the alert
        jsPromptAlert.accept();

        //// 6. Verify “You entered: hello” text is displayed.
        WebElement textDisplayed = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedText = "You entered: hello";
        String actualText = textDisplayed.getText();
        Assert.assertEquals(actualText, expectedText);
    }

    @Test(priority = 3)
    public void iframePractice() {

        // TC : Iframe practice
        // 1. Users are already login and on the homepage of CRM app
        driver.get("https://login1.nextbasecrm.com/");
        CRM_Utils.logIn(driver, "hr1@cybertekschool.com", "UserUser");

        // 2. Users click the MESSAGE tab


        // 3. Users write test message
        // 4. Users click the SEND button
        // 5. Verify the message is displayed on the feed
    }


    //@Test (priority = 4)
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
        Set<String> windowsList = new HashSet<>(driver.getWindowHandles());

        //    9. Print out each window title
        for (String each : windowsList) {
            driver.switchTo().window(each);
            BrowserUtils.sleep(2);
            System.out.println(driver.getTitle());
            //System.out.println(driver.getCurrentUrl());
        }

        //driver.switchTo().window(parentWindowHandle);


    }

    @Test(priority = 5)
    public void tablesPractise() {
        // TC : Web table practice
        // 1. Open Chrome browser
        // 2. Go to https://practice.cydeo.com/tables
        driver.get("https://practice.cydeo.com/tables");

        // 3. Print table data as a single String, not so common, but useful sometimes

        System.out.print(driver.findElement(By.xpath("(//table[@id='table1']//th)[1]")).getText()+ ", ");
        System.out.print(driver.findElement(By.xpath("(//table[@id='table1']//th)[2]")).getText()+ ", ");
        System.out.print(driver.findElement(By.xpath("(//table[@id='table1']//th)[3]")).getText()+ ", ");
        System.out.print(driver.findElement(By.xpath("(//table[@id='table1']//th)[4]")).getText()+ ", ");
        System.out.print(driver.findElement(By.xpath("(//table[@id='table1']//th)[5]")).getText()+ ", ");
        System.out.println(driver.findElement(By.xpath("(//table[@id='table1']//th)[6]")).getText());

        // 4. verify tconway@earthlink.net is anywhere in the table
        // 5. print all column names in single line
        // 6. print each column name in separate lines using a loop and findElements method
    }

}