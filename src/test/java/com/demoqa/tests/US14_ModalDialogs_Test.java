package com.demoqa.tests;


import com.demoqa.pages.US014_ModalDialogs_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;



public class US14_ModalDialogs_Test {

    US014_ModalDialogs_Page modalDialogsPage = new US014_ModalDialogs_Page();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @Test (
            priority = 1
    )
    public void modalDialogs() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.clickStaleElement(modalDialogsPage.alertsFrameWindows);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", this.modalDialogsPage.modalDialogs);
        modalDialogsPage.modalDialogs.click();

    }
    //TC063
    //1- Click "Small Modal" button
    //2- Assert this Modal dialog box/pupup oppened
    //3- Click close button
    //4- Click "Large Modal" button
    //5- Assert that the Modal dialog box/pupup oppened

    @Test (priority = 2, dependsOnMethods = {"modalDialogs"})
    public void modalDiaButtons()  {
        this.modalDialogsPage.smallButton.click();
        ReusableMethods.waitFor(1);
        Assert.assertTrue(modalDialogsPage.text.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(modalDialogsPage.smallLargeClose));
        modalDialogsPage.smallLargeClose.click();

        wait.until(ExpectedConditions.visibilityOf(modalDialogsPage.largeButton));
        modalDialogsPage.largeButton.click();

        Assert.assertTrue(modalDialogsPage.text.isDisplayed());
        modalDialogsPage.smallLargeClose.click();
        //ReusableMethods.waitFor(1);
    }

    //TC064
    //1- Click "Small Modal" button
    //2- Verify that text of the Modal dialog box/pupup has 47 characters.
    @Test (priority = 3, dependsOnMethods = {"modalDialogs"})
    public void textCharSize() {
        ReusableMethods.clickWithJS(modalDialogsPage.smallButton);
        ReusableMethods.waitFor(1);
        int lengthOfText = modalDialogsPage.text.getText().length();

        System.out.println(modalDialogsPage.text.getText());
        System.out.println(lengthOfText );
        Assert.assertEquals(lengthOfText ,47);

        modalDialogsPage.smallLargeClose.click();
        //ReusableMethods.waitFor(1);
    }

    //TC065
    //1- Click "Small Modal" button
    //2- Click close button
    //3- Verify that the dialog box is closed

    @Test (priority = 4, dependsOnMethods = {"modalDialogs"})
    public void verifyClose()  {

        ReusableMethods.clickStaleElement(modalDialogsPage.smallButton);
        ReusableMethods.waitFor(1);

        // 1.yol: Dialog penceresindeki close button un "size"  "1" oldugunu ve kapandiktan sonra da buton
        // gorunmedigi icin "size"  "0" oldugunu dogrula.
        // Not:size() ini alabilmek icin elementi(closeLarge2) List icine aldik

        System.out.println(modalDialogsPage.closeSmall.size());
        ReusableMethods.waitFor(1);
        modalDialogsPage.smallClose.click();
        ReusableMethods.waitFor(1);

        Assert.assertEquals(modalDialogsPage.closeSmall.size(), 0);
        System.out.println(modalDialogsPage.closeSmall.size());

//        2.yol: butonu false / true yaparak assert yap.
        modalDialogsPage.smallButton.click();
        ReusableMethods.waitFor(1);
        modalDialogsPage.smallClose.click();
        ReusableMethods.waitFor(1);

        boolean button = ReusableMethods.isElementVisible(modalDialogsPage.smallClose); //button visible mi? degil, degilse false olsun
        Assert.assertFalse(button);
        System.out.println("result = " + button);

    }

    //TC066
    //1- Click "Large Modal" button
    //2-Verify that the text has font-family "Roboto" in Modal dialog box
    @Test (priority = 5, dependsOnMethods = {"modalDialogs"})
    public void fontFamily(){
        ReusableMethods.clickStaleElement(modalDialogsPage.largeButton);
        String bodyFont = modalDialogsPage.text.getCssValue("font-family");
        System.out.println(bodyFont);
        Assert.assertTrue(bodyFont.contains("Roboto"));

        if  (bodyFont.contains("Roboto") ) {
            System.out.println("Font family contains: Roboto");
        }else
        System.out.println("Font family does not contain: Roboto");
        modalDialogsPage.smallLargeClose.click();

    }


    //TC067
    //1- Click "Large Modal" button
    //2- Click close button
    //3- Verify that the dialog box is closed

    @Test (priority = 6, dependsOnMethods = {"modalDialogs"})
    public void assertClose() {
        ReusableMethods.clickStaleElement(modalDialogsPage.buttons);

        // 1.yol: Dialog penceresindeki close button un "size"  "1" oldugunu ve kapandiktan sonra da buton
        // gorunmedigi icin "size"  "0" oldugunu dogrula.
        // Not:size() ini alabilmek icin elementi(closeLarge2) List icine aldik

        System.out.println(modalDialogsPage.closeLarge2.size());
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", this.modalDialogsPage.closeLarge);
        modalDialogsPage.closeLarge.click();

        ReusableMethods.waitFor(2);
        Assert.assertEquals(modalDialogsPage.closeLarge2.size(), 0);
        System.out.println(modalDialogsPage.closeLarge2.size());
    }
//    @AfterMethod
//    public void tearDownMethod(){
//        Driver.closeDriver();
//    }

}