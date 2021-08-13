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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

//Not: 72 ve 91 satirlar calismiyor

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
        this.actions.sendKeys(Keys.PAGE_DOWN).perform();
       // ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", this.modalDialogsPage.alertsFrameWindows);
        this.modalDialogsPage.alertsFrameWindows.click();
        this.actions.sendKeys(Keys.PAGE_DOWN).perform();
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", this.modalDialogsPage.modalDialogs);
        this.modalDialogsPage.modalDialogs.click();
    }
    //TC063
    //1- Click "Small Modal" button
    //2- Assert this Modal dialog box/pupup oppened
    //3- Click close button
    //4- Click "Large Modal" button
    //5- Assert that the Modal dialog box/pupup oppened

    @Test (priority = 2, dependsOnMethods = {"modalDialogs"})
    public void modalDiaButtons()  {
        //this.wait.until(ExpectedConditions.visibilityOf(modalDialogsPage.smallButton));
       //((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", this.modalDialogsPage.smallButton);
        ReusableMethods.waitFor(2);
        this.modalDialogsPage.smallButton.click();
        ReusableMethods.waitFor(2);
        Assert.assertTrue(modalDialogsPage.text.isDisplayed());

        this.wait.until(ExpectedConditions.visibilityOf(modalDialogsPage.smallLargeClose));
        this.modalDialogsPage.smallLargeClose.click();

        this.wait.until(ExpectedConditions.visibilityOf(modalDialogsPage.largeButton));
        this.modalDialogsPage.largeButton.click();

        Assert.assertTrue(modalDialogsPage.text.isDisplayed());
    }

    //TC064
    //1- Click "Small Modal" button
    //2- Verify that text of the Modal dialog box/pupup has 47 characters.
    @Test (priority = 3, dependsOnMethods = {"modalDialogs"})
    public void textCharSize() {
        ReusableMethods.waitFor(2);
        this.modalDialogsPage.smallButton.click();
        ReusableMethods.waitFor(2);
        int lengthOfText = modalDialogsPage.text.getText().length();

        System.out.println(modalDialogsPage.text.getText());
        System.out.println(lengthOfText );
        Assert.assertEquals(lengthOfText ,47);

        this.modalDialogsPage.smallLargeClose.click();
    }

    //TC065
    //1- Click "Small Modal" button
    //2- Click close button
    //3- Verify that the dialog box is closed

    @Test (priority = 4, dependsOnMethods = {"modalDialogs"})
    public void verifyClose()  {
        ReusableMethods.waitFor(3);
        this.modalDialogsPage.smallButton.click();
        ReusableMethods.waitFor(2);

        // 1.yol: Dialog penceresindeki close button un "size"  "1" oldugunu ve kapandiktan sonra da buton
        // gorunmedigi icin "size"  "0" oldugunu dogrula.
        // Not:size() ini alabilmek icin elementi(closeLarge2) List icine aldik

        System.out.println(modalDialogsPage.closeSmall.size());
        ReusableMethods.waitFor(2);
        this.modalDialogsPage.smallClose.click();
        ReusableMethods.waitFor(2);

        Assert.assertEquals(modalDialogsPage.closeSmall.size(), 0);
        System.out.println(modalDialogsPage.closeSmall.size());

//        2.yol: butonu false / true yaparak assert yap
        this.modalDialogsPage.smallButton.click();
        ReusableMethods.waitFor(2);
        this.modalDialogsPage.smallClose.click();
        ReusableMethods.waitFor(2);

        boolean button = ReusableMethods.isElementVisible(modalDialogsPage.smallClose);
        Assert.assertFalse(button);
        System.out.println("result = " + button);
    }

    //TC066
    //1- Click "Large Modal" button
    //2-Verify that the text has font-family "Roboto" in Modal dialog box
    @Test (priority = 5, dependsOnMethods = {"modalDialogs"})
    public void fontFamily(){
        ReusableMethods.waitFor(3);
        modalDialogsPage.largeButton.click();

        String bodyFont = modalDialogsPage.text.getCssValue("font-family");
        System.out.println(bodyFont);
        Assert.assertTrue(bodyFont.contains("Roboto"));

        if  (bodyFont.contains("Roboto") ) {
            System.out.println("Font family contains: Roboto");
        }else
        System.out.println("Font family does not contain: Roboto");
    }


    //TC067
    //1- Click "Large Modal" button
    //2- Click close button
    //3- Verify that the dialog box is closed

    @Test (priority = 6, dependsOnMethods = {"modalDialogs"})
    public void assertClose() {
        ReusableMethods.waitFor(4);
        //((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", this.modalDialogsPage.buttons);
        this.modalDialogsPage.buttons.click();


        // 1.yol: Dialog penceresindeki close button un "size"  "1" oldugunu ve kapandiktan sonra da buton
        // gorunmedigi icin "size"  "0" oldugunu dogrula.
        // Not:size() ini alabilmek icin elementi(closeLarge2) List icine aldik

        System.out.println(modalDialogsPage.closeLarge2.size());
        ((JavascriptExecutor)Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", this.modalDialogsPage.closeLarge);
        this.modalDialogsPage.closeLarge.click();

        ReusableMethods.waitFor(2);
        Assert.assertEquals(modalDialogsPage.closeLarge2.size(), 0);
        System.out.println(modalDialogsPage.closeLarge2.size());
    }
//    @AfterMethod
//    public void tearDownMethod(){
//        Driver.closeDriver();
//    }

}