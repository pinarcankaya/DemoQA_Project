package com.demoqa.tests;

import com.demoqa.pages.US11_Alert_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US11_Alert_Test {

    US11_Alert_Page alertPage=new US11_Alert_Page();

    @BeforeMethod
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        alertPage.elementsCard.click();
    }

    @Test
    public void TC1101() {
    }
}
