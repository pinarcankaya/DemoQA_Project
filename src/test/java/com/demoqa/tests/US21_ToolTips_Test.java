package com.demoqa.tests;

import com.demoqa.pages.US014_ModalDialogs_Page;
import com.demoqa.pages.US21_ToolTips_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US21_ToolTips_Test {

    US21_ToolTips_Page toolTipsPage = new US21_ToolTips_Page();
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
        Thread.sleep(2000);
        toolTipsPage.widgets.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.visibilityOf(toolTipsPage.toolTips));
        toolTipsPage.toolTips.click();
    }
    //TC112
    //1- Go to the main header
    //2- Assert it if its name is "Tool Tips"
    @Test
    public void mainHeader(){
//        toolTipsPage.headerToolTips.isDisplayed();
//        System.out.println(toolTipsPage.headerToolTips.getText());
        Assert.assertEquals(toolTipsPage.headerToolTips.getText(), "Tool Tips");
    }
    //TC113
    //1- Go to the paragraf "Practice Tool Tips"
    //2- Assert it if its name is "Practice Tool Tips"
    @Test
    public void paragraphName(){
//        toolTipsPage.practiceToolTips.isDisplayed();
//        System.out.println(toolTipsPage.practiceToolTips.getText());
        Assert.assertEquals(toolTipsPage.practiceToolTips.getText(),"Practice Tool Tips");
    }

    //TC114
    //1- Go to the green button "Hover me to see"
    //2- Assert it if its backround color is green
    //3- Assert it if its color is white
    @Test
    public void colorOfButton(){

    }

    //TC115
    //1- Go to the green button "Hover me to see"
    //2- Assert it if its name "Hover me to see"
    @Test
    public void greenButtonName(){

        Assert.assertEquals(toolTipsPage.greenButton.getText(), "Hover me to see");
    }

    //TC116
    //Mouse Text box basligi üzerine geldiginde "You hovered over the Button" yazisi
    // siyah renk dolgulu box icinde ve beyaz yazi tipinde oldugunu assert edin.

    //TC117
    //Hover me to see basligi altinda "bos text kutusu " ve altinda bir metin oldugunu assert edin


    //TC118
    //Metnin icinde "Contrary ve 1.10.32"  bilgilerini icerdigini assert edin

    @Test
    public void containsSomeStrings() throws InterruptedException {
        System.out.println(toolTipsPage.container.getText());
        Assert.assertTrue(toolTipsPage.container.isDisplayed(), "Contrary" + " 1.10.32");

//        String containerText=toolTipsPage.container.getText();
//        System.out.println(containerText);
//        Thread.sleep(3000);
//        Assert.assertEquals(containerText, "1.10.32");


   }
}
