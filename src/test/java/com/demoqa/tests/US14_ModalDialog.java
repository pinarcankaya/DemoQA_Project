package com.demoqa.tests;

import com.demoqa.pages.US14_ModalDialog_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US14_ModalDialog {

    US14_ModalDialog_Page modalDialogPage = new US14_ModalDialog_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        modalDialogPage.alertFrameWindowsCard.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollTo(modalDialogPage.modalDialogMenuLink);
    }

    //Modal Dialogs menu linkine tiklandiginda sayfada gorulen iki button calisir olmali
    @Test
    public void TC63() {
        modalDialogPage.modalDialogMenuLink.click();
        Assert.assertTrue(modalDialogPage.smallButton.isEnabled());
        Assert.assertTrue(modalDialogPage.largeButton.isEnabled());


    }

    //Modal dialogs menusunde sayfada gorulen Small Modal buttonuna tiklandiginda acilan penceredeki
    // text 47 charakter e sahip olmalidir.
    @Test
    public void TC64() {
        modalDialogPage.modalDialogMenuLink.click();
        modalDialogPage.smallButton.click();
        ReusableMethods.waitForVisibility( modalDialogPage.smallModalText,10);
        int smallText = modalDialogPage.smallModalText.getText().length();
        Assert.assertEquals(smallText,47);
    }


    //Small buttonunna tiklandiginda acilan penceredeki Close button u pencereyi kapatmalidir.
    @Test
    public void TC65() {
        modalDialogPage.modalDialogMenuLink.click();
        modalDialogPage.smallButton.click();
        Assert.assertTrue(modalDialogPage.smallCloseButton.isDisplayed());

        String beforeClose=modalDialogPage.smallModalWindow.getAttribute("class");
        System.out.println(beforeClose);
        modalDialogPage.smallCloseButton.click();
        String afterClose=modalDialogPage.smallModalWindow.getAttribute("class");
        System.out.println(afterClose);

        Assert.assertNotEquals(beforeClose,afterClose);



    }

    //Modal dialogs menusunde sayfada gorulen Large Modal buttonuna tiklandiginda acilan penceredeki
    // text in font-familie ailesinde "Robota" olmalidir.
    @Test
    public void TC66() {
        modalDialogPage.modalDialogMenuLink.click();
        modalDialogPage.largeButton.click();
        String textFontFamily=modalDialogPage.largeModalText.getCssValue("font-family");
        Assert.assertTrue(textFontFamily.contains("Roboto"));
    }


    //Large Modal buttonuna tiklandiginda acilan pencerede Close button ' u pencereyi kapatmalidir.
    @Test
    public void TC67() {
        modalDialogPage.modalDialogMenuLink.click();
        modalDialogPage.largeButton.click();

        String beforeClose=modalDialogPage.largeModalWindow.getAttribute("class");
        System.out.println(beforeClose);
        Assert.assertTrue(beforeClose.contains("show"));
        modalDialogPage.largeCloseButton.click();
        String afterClose=modalDialogPage.largeModalWindow.getAttribute("class");
        System.out.println(afterClose);

        Assert.assertFalse(afterClose.contains("show"));
    }
}
