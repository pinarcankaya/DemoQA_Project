package com.demoqa.tests;

import com.demoqa.pages.US014_ModalDialogs_Page;
import com.demoqa.pages.US21_ToolTips_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
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
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.clickStaleElement(toolTipsPage.widgets);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.clickStaleElement(toolTipsPage.toolTips);
    }
    //TC112
    //Sayfanin basliginin "Tool Tips "oldugunu assert edin.
    @Test
    public void mainHeader(){

        Assert.assertEquals(toolTipsPage.headerToolTips.getText(), "Tool Tips");
    }


    //TC113
    //Ust textte "Practice Tool Tips" yazdigini assert edin
    @Test
    public void paragraphName(){

        Assert.assertEquals(toolTipsPage.practiceToolTips.getText(),"Practice Tool Tips");
    }


    //TC114
    //Button yesil renk dolgulu ve beyaz yazi tipinde oldugunu assert edin
    @Test
    public void colorOfButton(){
        String backgroundColor = toolTipsPage.greenButton.getCssValue("background-color");
        String color = toolTipsPage.greenButton.getCssValue("color");
        System.out.println(backgroundColor);
        System.out.println(color);


        String convertBackground  = Color.fromString(backgroundColor).asHex();
        System.out.println(convertBackground);

        String convertColor  = Color.fromString(color).asHex();
        System.out.println(convertColor);

        Assert.assertEquals(backgroundColor, "rgba(40, 167, 69, 1)"); //Green
        Assert.assertEquals(color, "rgba(255, 255, 255, 1)"); //White
        Assert.assertEquals(convertBackground, "#28a745");
        Assert.assertEquals(convertColor, "#ffffff");
    }

    //TC115
    //Text box basligi " Hover me to see" olmali assert edin
    @Test
    public void greenButtonName(){

        String toolTip = toolTipsPage.boxHeader.getAttribute("placeholder"); // id olsaydi id teksini "toolTipTextField"
        System.out.println(toolTip);
        Assert.assertEquals(toolTip, "Hover me to see");

       // Assert.assertEquals(toolTipsPage.boxHeader.getText(), "Hover me to see"); // Burada placeholder aldigim halde actual bos geliyor, "Hover me to see" gelmiyor.
                                                                                    // Placeholder yazilari (teks box yazilari silik oluyor) ancak getAttribute le oluyor.
    }

    //TC116
    //Mouse Text box basligi üzerine geldiginde "You hovered over the Button" yazisi
    // siyah renk dolgulu box icinde ve beyaz yazi tipinde oldugunu assert edin.
    //background-color siyah #000000
    //color beyaz #fff

    @Test
    public void colorsOfHoverOver() throws InterruptedException {
        actions.moveToElement(toolTipsPage.emptyBox).build().perform();
        ReusableMethods.waitFor(2);
        String backgroundColor = toolTipsPage.hoverOverText.getCssValue("background-color");
        String color = toolTipsPage.hoverOverText.getCssValue("color");
        System.out.println(backgroundColor);
        System.out.println(color);

        Assert.assertEquals(backgroundColor, "rgba(0, 0, 0, 1)"); //Black
        Assert.assertEquals(color, "rgba(255, 255, 255, 1)"); //White
    }



    //TC117
    //Hover me to see basligi altinda "bos text kutusu " ve altinda bir metin oldugunu assert edin
    @Test
    public void emptyBox() throws InterruptedException {
        Assert.assertEquals(toolTipsPage.boxHeader.getText(), ""); // kutucugun bos oldugunu
        Assert.assertTrue(toolTipsPage.emptyBox.isEnabled()); // kutunun actif oldugunu anlıyoruz

        int locationBox = toolTipsPage.emptyBox.getLocation().getY();
        int locationText = toolTipsPage.container.getLocation().getY();
        System.out.println(locationBox);
        System.out.println(locationText);

        Assert.assertTrue(locationBox<locationText);

    }


    //TC118
    //Metnin icinde "Contrary ve 1.10.32"  bilgilerini icerdigini assert edin

    @Test
    public void containsSomeStrings(){
         // 1.yol yanlis yontem
//        System.out.println(toolTipsPage.container.getText());
//        Assert.assertFalse(toolTipsPage.container.isDisplayed(), "I want to make this TC false"); //isDisplayed in False vermesini ve bir mesaj vermek icin "I want to make this TC false"

        //2. yol contains'le
        String containerText = toolTipsPage.container.getText();
        System.out.println(containerText);
        Assert.assertTrue(containerText.contains("Contrary") && containerText.contains("1.10.32"));


   }
}
