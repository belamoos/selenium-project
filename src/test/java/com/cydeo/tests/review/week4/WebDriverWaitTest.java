package com.cydeo.tests.review.week4;

import com.cydeo.pages.WebDriverWaitPage;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class WebDriverWaitTest {
@Test
    public void webdriverwait_test(){
    // TC: WebdriverWait practice
// 1. Go to https://practice.cydeo.com/dynamic_loading/1
    Driver.getDriver().get("https://practice.cydeo.com/dynamic_loading/1");
    WebDriverWaitPage waitPage = new WebDriverWaitPage();

// 2. Click to start
    waitPage.startBtn.click();

// 3. Wait until loading bar disappears
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.invisibilityOf(waitPage.loadingBar));

// 4. Assert username inputbox is displayed
    Assert.assertTrue(waitPage.username.isDisplayed());
    // the implicit wait is not enough to let the username webelement to be displayed

// 5. Enter username: tomsmith
    waitPage.username.sendKeys("tomsmith");
    // the implicit wait allows to sendKeys even if the webElement is not displayed.(Maybe because it's done very fast)

// 6. Enter password: incorrectpassword
    waitPage.username.sendKeys("incorrectpassword");

// 7. Click to Submit button
    waitPage.submitBtn.click();

// 8. Assert “Your password is invalid!” text is displayed.
    Assert.assertTrue(waitPage.errorMsg.isDisplayed());
}

}
