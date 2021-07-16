package com.demoqa.tests;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;

import com.demoqa.pages.US28_Draggable_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US28_DragableTest {
    US28_Draggable_Page draggablePage = new US28_Draggable_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeMethod
    public void setup() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.driver.manage().window().maximize();
        Driver.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.clickWithJS(draggablePage.dragableInteractions);
    }

    @Test
    public void TC161() {
        List<Object> draggableMenus = new ArrayList<>();
        for (WebElement w : draggablePage.dragableMenuList) {
            draggableMenus.add(w.getText());
        }
        //System.out.println("1: "+draggableMenus);
        //System.out.println("2: "+draggableMenus.size());
        //System.out.println("3: "+draggableMenus.get(draggableMenus.size()-1));
        Assert.assertEquals("Dragabble", draggableMenus.get(draggableMenus.size() - 1));
    }

    @Test
    public void TC162() { //-Sayfanin basligi "Dragabble" olmalidilir
        ReusableMethods.clickWithJS(draggablePage.dragable);
        String actualTitle = "Dragabble";
        String expectedTitle = draggablePage.mainHeader.getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Test
    public void TC163() { //Sayfanin title`i "ToolsQA" olmalidir
        String actualTitle = "ToolsQA";
        String expectedTitle = Driver.driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void TC164() { //tab menusu Simple Axis Restricted Container Restricted Cursor Style
        List<String> expectedTab = new ArrayList<>();
        expectedTab.add("Simple");
        expectedTab.add("Axis Restricted");
        expectedTab.add("Container Restricted");
        expectedTab.add("Cursor Style");
        ReusableMethods.clickWithJS(draggablePage.dragable);
        List<Object> actualTab = new ArrayList<>();
        for (WebElement w : draggablePage.tabList
        ) {
            actualTab.add(w.getText());
        }

        Assert.assertEquals(actualTab, expectedTab);
    }

    @Test
    public void TC165() throws AWTException {//Simple Menusunde "Drage me" ifadesi maus ile hareket ettirelebilmeli
        ReusableMethods.clickWithJS(draggablePage.dragable);
        Robot robot = new Robot();
        ReusableMethods.waitFor(2);
        robot.keyPress(KeyEvent.VK_HOME);

        Point firstLocation = draggablePage.dragMe.getLocation();
        int x = 439; //     loc.getX();
        int y = 420; //  loc.getY();
        //System.out.println("x : " + x + "y : "+ y);
        robot.mouseMove(x, y);
        // actions.moveToElement(draggablePage.dragMe);
        ReusableMethods.waitFor(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.waitFor(1);
        robot.mouseMove(x + 100, y + 100);
        Point secondLocation = draggablePage.dragMe.getLocation();
        ReusableMethods.waitFor(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        Assert.assertNotEquals(firstLocation.getX(), secondLocation.getX());
        Assert.assertNotEquals(firstLocation.getY(), secondLocation.getY());
//        System.out.println(firstLocation.getX());
//        System.out.println(firstLocation.getY());
//        System.out.println(secondLocation.getX());
//        System.out.println(secondLocation.getY());

        //robot.mouseWheel(3);

        ReusableMethods.waitFor(1);

    }

    @Test
    public void TC166() {
        /*
        Axis Restricted menusunde "Only x" yatay sekilde  mouse ile haraket edebilsin
        ve "Only Y" ifadesi de dikey sekilde mausla hareket edebilsin
         */
        ReusableMethods.clickWithJS(draggablePage.dragable);
        draggablePage.axisRestricted.click();


        // only X
        Point restrictedX = draggablePage.onlyX.getLocation();
        int restrictedX_x = restrictedX.getX();
        int restrictedX_y = restrictedX.getY();
        ReusableMethods.waitFor(2);
        actions.dragAndDropBy(draggablePage.onlyX, 130, 150).build().perform();
        // actions.dragAndDropBy(draggablePage.onlyX, 150, 150);
        ReusableMethods.waitFor(2);
        Point secondrestrictedX = draggablePage.onlyX.getLocation();
        int secrestrictedX_x = secondrestrictedX.getX();
        int secrestrictedX_y = secondrestrictedX.getY();
        // actions.moveToElement(draggablePage.onlyX).click();

        System.out.println("restrictedX_x : " + restrictedX_x);
        System.out.println("restrictedX_y : " + restrictedX_y);
        System.out.println("secrestrictedX_x : " + secrestrictedX_x);
        System.out.println("secrestrictedX_y : " + secrestrictedX_y);

        //Only Y

        Point restrictedY = draggablePage.onlyY.getLocation();
        int restrictedY_x = restrictedY.getX();
        int restrictedY_y = restrictedY.getY();
        ReusableMethods.waitFor(2);
        actions.dragAndDropBy(draggablePage.onlyY, 250, 250).build().perform();
        // actions.dragAndDropBy(draggablePage.onlyX, 150, 150);
        ReusableMethods.waitFor(2);
        Point secondrestrictedY = draggablePage.onlyY.getLocation();
        int secrestrictedY_x = secondrestrictedY.getX();
        int secrestrictedY_y = secondrestrictedY.getY();
        // actions.moveToElement(draggablePage.onlyX).click();

        System.out.println("restrictedY_x : " + restrictedY_x);
        System.out.println("restrictedY_y : " + restrictedY_y);
        System.out.println("secrestrictedY_x : " + secrestrictedY_x);
        System.out.println("secrestrictedY_y : " + secrestrictedY_y);

        Assert.assertNotEquals(restrictedX_x, secrestrictedX_x);
        Assert.assertEquals(restrictedX_y, secrestrictedX_y);

        Assert.assertNotEquals(restrictedY_y, secrestrictedY_y);
        Assert.assertEquals(restrictedY_x, secrestrictedY_x);
//code da bug var ilk durum (Only X) icin sadece Y koordinatinda hareket ettirse kodum hatali cikar
    }

    @Test
    public void TC167() {
/*
Container Restricted menusunde  iki adet  maus hareketini test icin
alan bulunsun ve icinde ki kutular mausla hareket ettirilebilsin
 */
//        ReusableMethods.isElementVisible();
        ReusableMethods.clickWithJS(draggablePage.dragable);
        ReusableMethods.waitFor(3);
        draggablePage.containerRestricted.click();
        ReusableMethods.waitFor(3);
//        int Fpoint_X = draggablePage.first_ContainmentWrapper.getLocation().getX();
//        int Fpoinnt_Y = draggablePage.first_ContainmentWrapper.getLocation().getY();
//        actions.dragAndDropBy(draggablePage.first_ContainmentWrapper, 125, 125).perform();
//        ReusableMethods.waitFor(3);
//        int Spoint_X = draggablePage.first_ContainmentWrapper.getLocation().getX();
//        int Spoint_Y = draggablePage.first_ContainmentWrapper.getLocation().getY();
//        Assert.assertNotEquals(Fpoint_X,Spoint_X);
//        Assert.assertNotEquals(Fpoint_Y,Spoint_Y);
//actions.sendKeys(Keys.ARROW_DOWN);
//actions.sendKeys(Keys.ARROW_DOWN);
//actions.sendKeys(Keys.ARROW_DOWN);
//        ReusableMethods.waitFor(3);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.click(draggablePage.second_ContainedWithParent);
        int F_second_point_X = draggablePage.second_ContainedWithParent.getLocation().getX();
        int F_second_point_Y = draggablePage.second_ContainedWithParent.getLocation().getY();
        // actions.contextClick(draggablePage.second_ContainedWithParent).perform();
        ReusableMethods.waitFor(3);
        Dimension dimension = draggablePage.second_ContainedWithParent.getSize();
        System.out.println(dimension);
        System.out.println("FX : " + F_second_point_X);
        System.out.println("FY : " + F_second_point_Y);
        actions.clickAndHold(draggablePage.second_ContainedWithParent).moveByOffset(10, 10).release().build().perform();
        ReusableMethods.waitFor(3);
        int S_second_point_X = draggablePage.second_ContainedWithParent.getLocation().getX();
        int S_second_point_Y = draggablePage.second_ContainedWithParent.getLocation().getY();
        Assert.assertNotEquals(F_second_point_X, S_second_point_X);
        Assert.assertNotEquals(F_second_point_Y, S_second_point_Y);
        System.out.println("SX : " + S_second_point_X);
        System.out.println("SY : " + S_second_point_Y);

    }

    @Test
    public void TC168() {
/*Cursor Style menusunde  uc adet  button 🔳  sembolu bulunsun ve  sayfanin her yerine
mausla hareket ettirebilsin*/

        //center
        ReusableMethods.clickWithJS(draggablePage.dragable);
        draggablePage.cursorStyle.click();
        int f_center_x = draggablePage.center.getLocation().getX();
        int f_center_y = draggablePage.center.getLocation().getY();
        actions.dragAndDropBy(draggablePage.center, 150, 150).perform();
        int s_center_x = draggablePage.center.getLocation().getX();
        int s_center_y = draggablePage.center.getLocation().getY();

        ReusableMethods.waitFor(2);
        //left
        int f_left_x = draggablePage.left.getLocation().getX();
        int f_left_y = draggablePage.left.getLocation().getY();
        actions.dragAndDropBy(draggablePage.left, 150, 150).perform();
        int s_left_x = draggablePage.left.getLocation().getX();
        int s_left_y = draggablePage.left.getLocation().getY();
//        for (int i = 0; i <5; i++) {
//        actions.sendKeys(Keys.DOWN);
//        }
        ReusableMethods.waitFor(2);
        int f_bottom_x = draggablePage.bottom.getLocation().getX();
        int f_bottom_y = draggablePage.bottom.getLocation().getY();
        actions.dragAndDrop(draggablePage.bottom, draggablePage.center).perform();
        int s_bottom_x = draggablePage.bottom.getLocation().getX();
        int s_bottom_y = draggablePage.bottom.getLocation().getY();
        ReusableMethods.waitFor(2);
        //Assert.assertNotEquals(s_bottom_x, f_bottom_x);
        //Assert.assertNotEquals(s_bottom_y, f_bottom_y);
        Assert.assertNotEquals(s_center_y, f_center_y);
        Assert.assertNotEquals(s_center_x, f_center_x);
        Assert.assertNotEquals(s_left_x, f_left_x);
        Assert.assertNotEquals(s_left_y, f_left_y);
        System.out.println(f_center_x + " : " + f_center_y + " : " + s_center_x + " : " + s_center_y);
        System.out.println(f_bottom_x + " : " + f_bottom_y + " : " + s_bottom_x + " : " + s_bottom_y);
        System.out.println(f_left_x + " : " + f_left_y + " : " + s_left_x + " : " + s_left_y);
    }

    @AfterMethod
    public void closeWindow() {
        Driver.driver.close();
    }
}