package com.demoqa.tests;

import com.demoqa.pages.US04_RadioButton_Page;
import com.demoqa.pages.US05_Buttons_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US05_Buttons_Test {


    US05_Buttons_Page us05ButtonsPage = new US05_Buttons_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        us05ButtonsPage.elementsCard.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

    }

    //Elements accordion menusu altinda bulunan Buttons linkine tiklandiginda acilan sayfada Buttons yazisinin
    // font-weight degerinin 300 oldugunu assert edinizn!
    @Test
    public void TC0501() {
        us05ButtonsPage.buttonsMenu.click();
        String font_weight = us05ButtonsPage.buttonsMenu.getCssValue("font-weight");
        Assert.assertEquals(font_weight, "300");

    }

    //Buttons sayfasinda Double Click Me, Right Click Me ve Click Me butonlari goruntulenebilir olmalidir.
    @Test
    public void TC0502() {
        us05ButtonsPage.buttonsMenu.click();
        for (WebElement w: us05ButtonsPage.buttonList){
            Assert.assertTrue(w.isDisplayed());
        }


    }

    //Double Click Me butonuna tiklandiginda "You have done a double click" , Right Click Butonuna tiklandiginda
   // "You have done a right click" ve Click Me butonuna tiklandiginda ise "You have done a dynamic click" text leri goruntulenebilir oldugunu assert ediniz.
    @Test
    public void TC0503() {
        us05ButtonsPage.buttonsMenu.click();
        for (WebElement w:us05ButtonsPage.clickMessageList){
            System.out.println(w.getText());
        }

//       actions.doubleClick(us05ButtonsPage.buttonList.get(0)).perform();
//       String doubleClickMessage=us05ButtonsPage.clickMessageList.get(0).getText();
//       Assert.assertEquals(doubleClickMessage,"You have done a double click");
//
//       actions.contextClick(us05ButtonsPage.clickMessageList.get(1)).perform();
//        String rightClickMessage=us05ButtonsPage.clickMessageList.get(1).getText();
//        Assert.assertEquals(doubleClickMessage,"You have done a right click");
//
//        actions.click(us05ButtonsPage.clickMessageList.get(2)).perform();
//        String clickMeClickMessage=us05ButtonsPage.clickMessageList.get(2).getText();
//        Assert.assertEquals(doubleClickMessage,"You have done a dynamic click");
    }

    @AfterClass
    public void quit(){
        Driver.closeDriver();
    }

}