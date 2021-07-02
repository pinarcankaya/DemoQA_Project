package com.demoqa.tests;

import com.demoqa.pages.US21_ToolTips_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US21_ToolTips_Test {

    Actions actions = new Actions(Driver.getDriver());
    US21_ToolTips_Page toolTipsPage = new US21_ToolTips_Page();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.scrollTo(toolTipsPage.widgetMenuCard);
        toolTipsPage.widgetMenuCard.click();
        ReusableMethods.waitFor(2);
        ReusableMethods.scrollTo(toolTipsPage.toolTipsMenuLink);
        toolTipsPage.toolTipsMenuLink.click();
    }

    //Sayfanin basliginin "Tool Tips "oldugunu assert edin.
    @Test
    public void TC112() {

    }

    //Ust textte "Practice Tool Tips" yazdigini assert edin
    @Test
    public void TC113() {

    }

    //Button yesil renk dolgulu ve beyaz yazi tipinde oldugunu assert edin
    @Test
    public void TC114() {
        String buttonBackgroundColor=ReusableMethods.getHexColor(toolTipsPage.hoverMeToSeeButton,("background-color"));
        System.out.println(buttonBackgroundColor);
        Assert.assertEquals(buttonBackgroundColor,"#28a745");
        String buttonTextColor=ReusableMethods.getHexColor(toolTipsPage.hoverMeToSeeButton,("color"));
        System.out.println(buttonTextColor);
        Assert.assertEquals(buttonTextColor,"#ffffff");
    }

    //Text box basligi " Hover me to see" olmali assert edin
    @Test
    public void TC115() {
        String placeHolder=toolTipsPage.bosTextBox.getAttribute("placeholder");
        System.out.println(placeHolder);

        Assert.assertEquals(placeHolder,"Hover me to see");


    }

    //Mouse Text box basligi üzerine geldiginde "You hovered over the Button" yazisi siyah renk dolgulu
    // box icinde ve beyaz yazi tipinde oldugunu assert edin.
    @Test
    public void TC116() {
        actions.moveToElement(toolTipsPage.hoverMeToSeeButton).build().perform();
        String text = toolTipsPage.hoverText.getText();
        System.out.println(text);

        String backgroundColor = ReusableMethods.getHexColor(toolTipsPage.hoverText, ("background-color"));
        System.out.println(backgroundColor);

        Assert.assertEquals(backgroundColor,"#000");

        ReusableMethods.waitFor(1);
        String textColor =ReusableMethods.getHexColor(toolTipsPage.hoverText,("color"));
        System.out.println(textColor);

        Assert.assertEquals(textColor,"#212529");


    }

    //Hover me to see basligi altinda "bos text kutusu " ve altinda bir metin oldugunu assert edin
    @Test
    public void TC117() {
        int hoverButtonHeight = toolTipsPage.hoverMeToSeeButton.getLocation().y;//276
        int bosTextHeight = toolTipsPage.bosTextBox.getLocation().y;  //338
        int doluTextHeight = toolTipsPage.container.getLocation().y;  //400
        System.out.println(hoverButtonHeight);//276
        System.out.println(bosTextHeight);//338
        System.out.println(doluTextHeight);//400

        boolean koordinat = false;
        if (hoverButtonHeight < bosTextHeight && bosTextHeight < doluTextHeight) {
            koordinat = true;
            System.out.println("expected result koordinatlara uygun");
        }
        Assert.assertTrue(koordinat);


    }

    //Metnin icinde "Contrary ve 1.10.32  bilgilerini icerdigini assert edin
    @Test
    public void TC118() {
        String containerText = toolTipsPage.container.getText();
        System.out.println(containerText);
        Assert.assertTrue(containerText.contains("Contrary") && containerText.contains("1.10.32"));
    }

}
