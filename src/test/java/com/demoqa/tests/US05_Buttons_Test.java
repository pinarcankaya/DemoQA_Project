package com.demoqa.tests;

import com.demoqa.pages.US05_Buttons_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class US05_Buttons_Test {

    US05_Buttons_Page obj = new US05_Buttons_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeClass
    public void background(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
     //   Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        obj.elementCard.click();
//        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", obj.buttonsSegment);
//        obj.buttonsSegment.click();
    }
    @Test
    public void  buttonsTC01(){
        //verify tittle font-weight 300
        assertEquals(obj.mainHeaderText.getCssValue("font-weight"),"300");
    }
    @Test
    public void  buttonsTC02(){
        //double click , right click and click me button should displayed
//        assertTrue(obj.doubleClickButton.isDisplayed());
//        assertTrue(obj.rigthClickButton.isDisplayed());
//        assertTrue(obj.clickMeButton.isDisplayed());
        //with list
        for (WebElement button :obj.clickButtons) {
            assertTrue(button.isDisplayed());
        }
    }
    @Test
    public void  buttonsTC03(){
        //double click and verify the text is displayed
        actions.doubleClick(obj.doubleClickButton).perform();
        ReusableMethods.waitForVisibility(obj.doubleClickText,10);
        assertTrue(obj.doubleClickText.isDisplayed());
        //right click and verify the text is displayed
        actions.contextClick(obj.rigthClickButton).perform();
        ReusableMethods.waitForVisibility(obj.rightClickText,10);
        assertTrue(obj.rightClickText.isDisplayed());
        //clickMe and verify the text is displayed
        actions.click(obj.clickMeButton).perform();
        ReusableMethods.waitForVisibility(obj.clickMeText,10);
        assertTrue(obj.clickMeText.isDisplayed());
    }
}
