package com.demoqa.tests;


import com.demoqa.pages.US014_ModalDialogs_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.concurrent.TimeUnit;

public class US14_ModalDialogs_Test {

    US014_ModalDialogs_Page modalDialogsPage = new US014_ModalDialogs_Page();
    Actions actions = new Actions(Driver.getDriver());
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @BeforeMethod
    public void setup() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(3000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        modalDialogsPage.alertsFrameWindows.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOf(modalDialogsPage.modalDialogs));
        modalDialogsPage.modalDialogs.click();
    }
    //TC063
    //1- Click "Small Modal" button
    //2- Assert this Modal dialog box/pupup oppened
    //3- Click close button
    //4- Click "Large Modal" button
    //5- Assert that the Modal dialog box/pupup oppened

    @Test
    public void modalDiaButtons() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(modalDialogsPage.smallButton));
        modalDialogsPage.smallButton.click();
        Thread.sleep(2000);
        Assert.assertTrue(modalDialogsPage.text.isDisplayed());

        wait.until(ExpectedConditions.visibilityOf(modalDialogsPage.smallLargeClose));
        modalDialogsPage.smallLargeClose.click();

        wait.until(ExpectedConditions.visibilityOf(modalDialogsPage.largeButton));
        modalDialogsPage.largeButton.click();

        Assert.assertTrue(modalDialogsPage.text.isDisplayed());
    }

    //TC064
    //1- Click "Small Modal" button
    //2- Verify that text of the Modal dialog box/pupup has 47 characters.
    @Test
    public void textCharSize() throws InterruptedException {
        Thread.sleep(3000);
        modalDialogsPage.smallButton.click();
        Thread.sleep(3000);
        int lengthofText = modalDialogsPage.text.getText().length();

        System.out.println(modalDialogsPage.text.getText());
        System.out.println(lengthofText );
        Assert.assertEquals(lengthofText ,47);

        modalDialogsPage.smallLargeClose.click();
    }

    //TC065
    //1- Click "Small Modal" button
    //2- Click close button
    //3- Verify that the dialog box is closed

    @Test
    public void verifyClose() throws InterruptedException {
        modalDialogsPage.smallButton.click();
        Thread.sleep(3000);

        // 1.yol: Dialog penceresindeki close button un "size"  "1" oldugunu ve kapandiktan sonra da buton
        // gorunmedigi icin "size"  "0" oldugunu dogrula.
        // Not:size() ini alabilmek icin elementi(closeLarge2) List icine aldik

        System.out.println(modalDialogsPage.closeSmall.size());
        modalDialogsPage.smallClose.click();
        Thread.sleep(3000);

        Assert.assertEquals(modalDialogsPage.closeSmall.size(), 0);
        System.out.println(modalDialogsPage.closeSmall.size());

//        2.yol: butonu false / true yaparak assert yap
        modalDialogsPage.smallButton.click();
        Thread.sleep(3000);
        modalDialogsPage.smallClose.click();
        Thread.sleep(3000);

        boolean button = ReusableMethods.isElementVisible(modalDialogsPage.smallClose);
        Assert.assertFalse(button);
        System.out.println("result = " + button);
    }

    //TC066
    //1- Click "Large Modal" button
    //2-Verify that the text has font-family "Roboto" in Modal dialog box
    @Test
    public void fontFamily(){
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

    @Test
    public void assertClose() throws InterruptedException {

        modalDialogsPage.buttons.click();
        Thread.sleep(3000);

        // 1.yol: Dialog penceresindeki close button un "size"  "1" oldugunu ve kapandiktan sonra da buton
        // gorunmedigi icin "size"  "0" oldugunu dogrula.
        // Not:size() ini alabilmek icin elementi(closeLarge2) List icine aldik

        System.out.println(modalDialogsPage.closeLarge2.size());

        modalDialogsPage.closeLarge.click();
        Thread.sleep(3000);

        Assert.assertEquals(modalDialogsPage.closeLarge2.size(), 0);
        System.out.println(modalDialogsPage.closeLarge2.size());



    }
    @AfterMethod
    public void tearDownMethod(){
        Driver.closeDriver();
    }

}