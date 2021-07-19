package com.demoqa.tests;

import com.demoqa.pages.US20_Tabs_Page;

import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.apache.commons.io.input.ReaderInputStream;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class US20_Tabs_Test {
    US20_Tabs_Page obj = new US20_Tabs_Page();
    String expectedBlueHex = "#007bff";
    String expectedGrayHex = "#495057";
    String expectedGrayHexMore = "#6c757d";

    @Test(priority = 1)
    public void goToDemoQA() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.clickWithJS(obj.widgetsCard);
        ReusableMethods.waitForClickablility(obj.tabsButton, 3);
        ReusableMethods.clickWithJS(obj.tabsButton);
    }

    @Test(priority = 2, dependsOnMethods = "goToDemoQA")
    public void verifyHeader() {
        ReusableMethods.waitForVisibility(obj.tabsHeader, 5);
        Assert.assertTrue(obj.tabsHeader.isDisplayed());
    }

    @Test(priority = 3, dependsOnMethods = "goToDemoQA")
    public void verifyText() {
        Assert.assertTrue(obj.loramText.isDisplayed());
    }

    @Test(priority = 4, dependsOnMethods = "goToDemoQA")
    public void tabsDisplayed() {
//        for (int i = 0; i < obj.tabs.size(); i++) {
//            int locationX = obj.tabs.get().getLocation().getX();  //82
//            int locationY = obj.tabs.get().getLocation().getX(); //86
////            System.out.println(locationX);
////            System.out.println(locationY);
////            Assert.assertTrue(locationX<locationY);
//         //   Assert.assertTrue(obj.tabs.get(i).g);
//            if(locationX<locationY){
//
//            }
//
//        }
                String[] arr={"What", "Origin", "Use", "More"};
        for (int i = 0; i <obj.tabs.size() ; i++) {
            Assert.assertEquals(obj.tabs.get(i).getText(),arr[i]);
            System.out.println(obj.tabs.get(i).getLocation().getX());
        }

        int whatX = obj.tabs.get(0).getLocation().getX();
        System.out.println(whatX);
        int originX =obj.tabs.get(1).getLocation().getX();
        int useX = obj.tabs.get(2).getLocation().getX();
        int moreX = obj.tabs.get(3).getLocation().getX();

        boolean durum = false;
        if(whatX<originX && originX<useX && useX<moreX){
            System.out.println("Sonuc : True");
            durum = true;
        }
        Assert.assertTrue(durum);
    }

//    @Test(priority = 5, dependsOnMethods = "goToDemoQA")
//    public void whatTab() {
//        obj.originTab.click();
//        String color = obj.whatTab.getCssValue("color");
//        String actualBlueHex = Color.fromString(color).asHex();
//        Assert.assertEquals(actualBlueHex, expectedBlueHex);
//        obj.whatTab.click();
//        String actualGrayHex = Color.fromString(obj.whatTab.getCssValue("color")).asHex();
//        Assert.assertEquals(actualGrayHex, expectedGrayHex);
//
//    }

    @Test(priority = 5, dependsOnMethods = "goToDemoQA")
    public void tabColorAndText() {
        obj.tabs.get(obj.tabs.size()-2).click();//use tab click
        for (int j = 0; j < obj.tabs.size()-1; j++) {
            String color = obj.tabs.get(j).getCssValue("color");
            String actualBlueHex = Color.fromString(color).asHex();
            Assert.assertEquals(actualBlueHex, expectedBlueHex);
            ReusableMethods.waitFor(2);
            obj.tabs.get(j).click();
            String actualGrayHex = Color.fromString(obj.tabs.get(j).getCssValue("color")).asHex();
            Assert.assertEquals(actualGrayHex, expectedGrayHex);
           // System.out.println(obj.tabs.get(j).getText());
            Assert.assertTrue(obj.textList.get(j).isDisplayed());
          //  System.out.println(j+".tour");
            ReusableMethods.waitFor(2);
        }
        String moreTextColor = Color.fromString(obj.moreTab.getCssValue("color")).asHex();
        Assert.assertEquals(moreTextColor,expectedGrayHexMore);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Driver.closeDriver();
 }
}
