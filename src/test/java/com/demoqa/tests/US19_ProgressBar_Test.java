package com.demoqa.tests;

import com.demoqa.pages.US19_ProgressBar_Page;
import com.demoqa.pages.US21_ToolTips_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US19_ProgressBar_Test {

    Actions actions = new Actions(Driver.getDriver());
    US19_ProgressBar_Page progressBarPage = new US19_ProgressBar_Page();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.scrollTo(progressBarPage.widgetMenuCard);
        progressBarPage.widgetMenuCard.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollTo(progressBarPage.progressBarMenuLink);
        progressBarPage.progressBarMenuLink.click();
    }

    @Test
    public void TC97() {
    }

    @Test
    public void TC98() {
    }


    @Test
    public void TC99() {
    }

    @Test
    public void TC100() {
    }

    @Test
    public void TC101() {
    }

    @Test
    public void TC102() {
    }
    @Test
    public void TC103() {
    }
    @Test
    public void TC104() {
    }
}
