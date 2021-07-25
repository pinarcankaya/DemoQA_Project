package com.demoqa.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

public class Omer {
    public static void saveAsPicture(WebElement webElement) {
        try {
            Robot robot = new Robot();
            Actions actions = new Actions(Driver.getDriver());
            actions.contextClick(webElement);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_DOWN);
            robot.keyRelease(KeyEvent.VK_DOWN);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void setClipboard(String string) {
        StringSelection selection = new StringSelection(string);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
    }

    public static void rightClick(int x, int y) {
        Actions actions = new Actions(Driver.getDriver());
        try {
            Robot robot = new Robot();
            robot.delay(200);
            robot.mouseMove(x, y);
            robot.delay(200);
            actions.contextClick();
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    public static void rightClick(WebElement webElement) {
        Actions actions = new Actions(Driver.getDriver());
        actions.contextClick(webElement);
    }

    public static WebElement isClickable(WebElement webElement, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeout);
       return wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }
public static void isDisplayed(WebElement webElement){
        webElement.isDisplayed();
}
    public static  boolean isClickable(WebElement webElement){
        JavascriptExecutor ex=(JavascriptExecutor)Driver.getDriver();
        ex.executeScript("arguments[0].click()", webElement);
        return true;
    }
}
