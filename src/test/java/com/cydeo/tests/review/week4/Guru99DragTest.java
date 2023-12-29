package com.cydeo.tests.review.week4;

import com.cydeo.utilities.Driver;
import org.testng.annotations.Test;

public class Guru99DragTest {

    @Test
    public void guru99_drag_drop_test(){
        // TC: Guru99 Drag and Drop Test
        // 1- Open a chrome browser
        // 2- Go to: https://demo.guru99.com/test/drag_drop.html
        Driver.getDriver().get("https://demo.guru99.com/test/drag_drop.html");
        // 3- Drag “BANK” and drop into Account area under Debit Side
        // 4- Drag “5000” and drop into Amount area under Debit Side
    }
}
