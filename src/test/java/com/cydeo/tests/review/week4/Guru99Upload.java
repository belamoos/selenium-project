package com.cydeo.tests.review.week4;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Guru99Upload extends  BaseTest{

    @Test
    public void guru99_upload_test(){
        // TC: Guru99 Upload Test
        //1. Go to  “https://demo.guru99.com/test/upload”
        Driver.getDriver().get("https://demo.guru99.com/test/upload");
        //2. Upload file into Choose File
        WebElement uploadBtn = Driver.getDriver().findElement(By.id("uploadfile_0"));
        uploadBtn.sendKeys("C:\\Users\\user\\Desktop\\API_Testing_and_Development_with_Postman_A_practical_guide_to_creating_testing_and_managing_APIs_for_automated_software.epub");

        //3. Click terms of service check box
        WebElement termsBtn = Driver.getDriver().findElement(By.xpath("//input[@id='terms']"));
        termsBtn.click();

        //4. Click Submit File button
        WebElement submitBtn = Driver.getDriver().findElement(By.xpath("//button[@id='submitbutton']"));
        submitBtn.click();

        //5. Verify expected message appeared.
        // Expected: “1 file
        // has been successfully uploaded.

//        BrowserUtils.sleep(3);

        WebElement ActualText = Driver.getDriver().findElement(By.xpath("//center[.='1 file has been successfully uploaded.']"));
        String ActualMsg = ActualText.getText();
        String ExpectedMsg = "1 file\nhas been successfully uploaded.";

//        BrowserUtils.sleep(3);

        System.out.println("ActualText = " + ActualText.getText());
        Assert.assertEquals(ActualMsg, ExpectedMsg );

    }




}
