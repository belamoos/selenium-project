package com.cydeo.tests.review.week4;

import com.cydeo.pages.VytrackLoginPage;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class VytrackLoginTest {
    VytrackLoginPage VytrackDriverLogin;

   @BeforeMethod
           public void setup(){
       Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
       VytrackDriverLogin = new VytrackLoginPage();
   }
   @AfterMethod
   public void tear_down(){
       Driver.closeDriver();
   }


   @Test
    public void vytrack_driver_login_test() {
       // TC: Vytrack app login test as Driver
       // 1- Open a chrome browser
       // 2- Go to: https://qa3.vytrack.com/user/login


       // 3. Enter username User1

//       VytrackDriverLogin.userName.sendKeys(ConfigurationReader.getProperty("driver.username"));
//       VytrackDriverLogin.password.sendKeys(ConfigurationReader.getProperty("driver.password"));
//       VytrackDriverLogin.loginBtn.click();
       VytrackDriverLogin.loginAsDriver();

       // 4. Enter password UserUser123
       // 5. Click to Login button
   }
       @Test
       public void vytrack_sales_manager_login_test(){
           VytrackDriverLogin.loginAsSalesManager();

       }
    @Test
    public void vytrack_store_manager_login_test(){
        VytrackDriverLogin.loginAsStoreManager();

    }


    }


