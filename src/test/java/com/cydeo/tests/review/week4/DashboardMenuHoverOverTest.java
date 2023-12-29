package com.cydeo.tests.review.week4;

import com.cydeo.pages.DashboardPage;
import com.cydeo.pages.VytrackLoginPage;
import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

public class DashboardMenuHoverOverTest {
    @Test
    public void dashboard_menu_hover_over() {
        // TC: Vytrack app main menus test as Salesmanager
        // 1- Open a chrome browser
        // 2- Go to: https://qa3.vytrack.com/user/login
        Driver.getDriver().get(ConfigurationReader.getProperty("vytrack.url"));
        VytrackLoginPage vytrackLoginPage = new VytrackLoginPage();

        // 3. Enter username salesmanager120
        // 4. Enter password UserUser123
        // 5. Click to Login button
        vytrackLoginPage.loginAsSalesManager();

        BrowserUtils.sleep(3);

        // 6. Hover over each main menu
        Actions actions = new Actions(Driver.getDriver());

        DashboardPage  dashboardMenu = new DashboardPage();

        List <WebElement> menus = dashboardMenu.mainWebElements;
        for (WebElement menu : menus) {
            actions.moveToElement(menu).perform();
            BrowserUtils.sleep(3);
        }
        }
        
            
        }
        





