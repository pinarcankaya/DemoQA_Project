package com.demoqa.tests;

import com.demoqa.pages.US28_Draggable_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class US28_DragableTest {
    US28_Draggable_Page draggablePage = new US28_Draggable_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeClass
    public void setup() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.clickWithJS(draggablePage.dragableInteractions);
    }

    @Test(priority = 1)
    public void TC161() { //"Dragabble" buttonu  Interactions linkinin altinda ve son element olarak bulunmali.
        List<Object> draggableMenus = new ArrayList<>();
        for (WebElement w : draggablePage.dragableMenuList) {
            draggableMenus.add(w.getText());
        }

        Assert.assertEquals("Dragabble", draggableMenus.get(draggableMenus.size() - 1));
    }

    @Test(priority = 2)
    public void TC162() { //-Sayfanin basligi "Dragabble" olmalidilir
        ReusableMethods.clickWithJS(draggablePage.dragable);
        String actualTitle = "Dragabble";
        String expectedTitle = draggablePage.mainHeader.getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }


    @Test(priority = 3)
    public void TC163() { //Sayfanin title`i "ToolsQA" olmalidir
        String actualTitle = "ToolsQA";
        String expectedTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test(priority = 4)
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

    @Test(priority = 5)
    public void TC165() throws AWTException {//Simple Menusunde "Drage me" ifadesi maus ile hareket ettirelebilmeli
        ReusableMethods.clickWithJS(draggablePage.dragable);
        Robot robot = new Robot();
        ReusableMethods.waitFor(2);
        robot.keyPress(KeyEvent.VK_HOME);

        Point firstLocation = draggablePage.dragMe.getLocation();
        int x = 439; //     loc.getX();
        int y = 420; //  loc.getY();
        robot.mouseMove(x, y);
        ReusableMethods.waitFor(1);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        ReusableMethods.waitFor(1);
        robot.mouseMove(x + 100, y + 100);
        Point secondLocation = draggablePage.dragMe.getLocation();
        ReusableMethods.waitFor(1);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        Assert.assertNotEquals(firstLocation.getX(), secondLocation.getX());
        Assert.assertNotEquals(firstLocation.getY(), secondLocation.getY());
        ReusableMethods.waitFor(1);

    }

    @Test(priority = 6)
    public void TC166() {
        /*
        Axis Restricted menusunde "Only x" yatay sekilde  mouse ile haraket edebilsin
        ve "Only Y" ifadesi de dikey sekilde mausla hareket edebilsin
         */
        ReusableMethods.clickWithJS(draggablePage.dragable);
        draggablePage.axisRestricted.click();


        // only X
        int restrictedX_x = draggablePage.onlyX.getLocation().getX();
        int restrictedX_y = draggablePage.onlyX.getLocation().getY();
        ReusableMethods.waitFor(2);
        actions.dragAndDropBy(draggablePage.onlyX, 130, 150).build().perform();
        ReusableMethods.waitFor(2);
        int secrestrictedX_x = draggablePage.onlyX.getLocation().getX();
        int secrestrictedX_y = draggablePage.onlyX.getLocation().getY();
        Assert.assertNotEquals(restrictedX_x, secrestrictedX_x);
        Assert.assertEquals(restrictedX_y, secrestrictedX_y);


        //Only Y

        Point restrictedY = draggablePage.onlyY.getLocation();
        int restrictedY_x = restrictedY.getX();
        int restrictedY_y = restrictedY.getY();
        ReusableMethods.waitFor(2);
        actions.dragAndDropBy(draggablePage.onlyY, 250, 250).build().perform();
        ReusableMethods.waitFor(2);
        Point secondrestrictedY = draggablePage.onlyY.getLocation();
        int secrestrictedY_x = secondrestrictedY.getX();
        int secrestrictedY_y = secondrestrictedY.getY();


        Assert.assertNotEquals(restrictedY_y, secrestrictedY_y);
        Assert.assertEquals(restrictedY_x, secrestrictedY_x);
    }

    @Test(priority = 7)
    public void TC167() {
/*
Container Restricted menusunde  iki adet  maus hareketini test icin
alan bulunsun ve icinde ki kutular mausla hareket ettirilebilsin
 */
        ReusableMethods.clickWithJS(draggablePage.dragable);
        ReusableMethods.waitFor(3);
        draggablePage.containerRestricted.click();
        ReusableMethods.waitFor(3);
        //Container Restricted menusunde  iki adet  maus hareketini test icin
        //alan bulunsun
        Assert.assertEquals(draggablePage.restcrictedkutulari.size(), 2);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        actions.click(draggablePage.second_ContainedWithParent);
        int F_second_point_X = draggablePage.second_ContainedWithParent.getLocation().getX();
        int F_second_point_Y = draggablePage.second_ContainedWithParent.getLocation().getY();
        ReusableMethods.waitFor(3);
        actions.clickAndHold(draggablePage.second_ContainedWithParent).moveByOffset(10, 10).release().build().perform();
        ReusableMethods.waitFor(3);
        int S_second_point_X = draggablePage.second_ContainedWithParent.getLocation().getX();
        int S_second_point_Y = draggablePage.second_ContainedWithParent.getLocation().getY();
        Assert.assertNotEquals(F_second_point_X, S_second_point_X);
        Assert.assertNotEquals(F_second_point_Y, S_second_point_Y);


    }

    @Test(priority = 8)
    public void TC168() {
/*Cursor Style menusunde  uc adet  button 🔳  sembolu bulunsun ve  sayfanin her yerine
mausla hareket ettirebilsin*/
        Random random_X = new Random();
        Random random_Y = new Random();
        int number_X = random_X.nextInt(100);
        int number_Y = random_Y.nextInt(100);
            ReusableMethods.clickWithJS(draggablePage.dragable);
            draggablePage.cursorStyle.click();
        for (int i = 0; i <2 ; i++) {

            //center
            int f_center_x = draggablePage.center.getLocation().getX();
            int f_center_y = draggablePage.center.getLocation().getY();
            actions.dragAndDropBy(draggablePage.center,number_X,number_Y).perform();
            int s_center_x = draggablePage.center.getLocation().getX();
            int s_center_y = draggablePage.center.getLocation().getY();
            ReusableMethods.waitFor(2);
            //left
            int f_left_x = draggablePage.left.getLocation().getX();
            int f_left_y = draggablePage.left.getLocation().getY();
            actions.dragAndDropBy(draggablePage.left, number_X, number_Y).perform();
            ReusableMethods.waitFor(2);
            int s_left_x = draggablePage.left.getLocation().getX();
            int s_left_y = draggablePage.left.getLocation().getY();

            ReusableMethods.waitFor(2);
            //bottom
            int f_bottom_x = draggablePage.bottom.getLocation().getX();
            int f_bottom_y = draggablePage.bottom.getLocation().getY();
            actions.dragAndDropBy(draggablePage.bottom, number_X,number_Y).perform();
            int s_bottom_x = draggablePage.bottom.getLocation().getX();
            int s_bottom_y = draggablePage.bottom.getLocation().getY();
            ReusableMethods.waitFor(2);
            Assert.assertNotEquals(s_bottom_x, f_bottom_x);
            Assert.assertNotEquals(s_bottom_y, f_bottom_y);
            Assert.assertNotEquals(s_center_y, f_center_y);
            Assert.assertNotEquals(s_center_x, f_center_x);
            Assert.assertNotEquals(s_left_x, f_left_x);
            Assert.assertNotEquals(s_left_y, f_left_y);
        }
    }

    @AfterClass
    public void closeWindow() {
        Driver.getDriver().close();
    }
}
