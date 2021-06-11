package com.demoqa.tests;

import com.demoqa.pages.US05_Buttons_Page;
import com.demoqa.pages.US13_NestedFrame_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class US13_NestedFrame_Test {
    US13_NestedFrame_Page nestedFrameObj = new US13_NestedFrame_Page();
    US05_Buttons_Page obj = new US05_Buttons_Page();
    @BeforeClass
    public void background(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        nestedFrameObj.alertFrameCard.click();
        //verify nested frame segment is working
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", nestedFrameObj.nestedFrameSegment);
        nestedFrameObj.nestedFrameSegment.click();


    }
    @Test
    public void nestedFrameTest(){
        //verify nested frame segment is working
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", nestedFrameObj.nestedFrameSegment);
        Assert.assertTrue(nestedFrameObj.nestedFrameSegment.isEnabled());
        nestedFrameObj.nestedFrameSegment.click();
        Assert.assertTrue(obj.mainHeaderText.isDisplayed());
    }
    @Test
    public void nestedFrameTest1() {
        //there should be 2 frame on the page
        List<WebElement> iframeList =Driver.getDriver().findElements(By.xpath("//iframe"));
        System.out.println("child gecmeden "+iframeList.size());
        Driver.getDriver().switchTo().frame(iframeList.get(0));
        iframeList.add(Driver.getDriver().findElement(By.xpath("//iframe")));
        Assert.assertEquals(iframeList.size(),2);
//        Driver.getDriver().switchTo().frame(nestedFrameObj.iframeList.get(0));
//        nestedFrameObj.iframeList.add(nestedFrameObj.iframe);
//        Assert.assertEquals(nestedFrameObj.iframeList.size(),2);
        //can not verify child frame text without switching parent frame
    }
    @Test
    public void nestedFrameTest2(){
        //verify "Parent Frame" text
        Assert.assertEquals(nestedFrameObj.parentFrameText.getText(),"Parent frame");
    }
    @Test
    public void nestedFrameTest3(){
        //verify "Child Iframe" text
        Driver.getDriver().switchTo().frame(nestedFrameObj.iframe);
        Assert.assertEquals(nestedFrameObj.childFrameText.getText(),"Child Iframe");
    }
    @Test
    public void nestedFrameTest4(){
        //Sample nested.. text color should be #212529
        //System.out.println(nestedFrameObj.sampleNestedText.getText());
        String info = Color.fromString(nestedFrameObj.sampleNestedText.getCssValue("color")).asHex();
        Assert.assertEquals(info,"#212529");
        //  System.out.println(nestedFrameObj.sampleNestedText.getCssValue("color"));
   //     Assert.assertEquals(nestedFrameObj.sampleNestedText.getCssValue("color"),"#212529");
    }
}
