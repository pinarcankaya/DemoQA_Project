package com.demoqa.tests;


import com.demoqa.pages.US02_Check_Box_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.security.auth.login.Configuration;
import javax.swing.*;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class US02_Check_Box_Test {

    US02_Check_Box_Page us02CheckBox = new US02_Check_Box_Page();
    Actions actions = new Actions(Driver.getDriver());

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test  // Check Box'in Element Butonu'nun altinda oldugunu verify edin.

    public void TC_05() {
        us02CheckBox.elementsCard.click();
        Assert.assertTrue(us02CheckBox.checkBoxKutu.isDisplayed());

    }

    @Test // "Check Box" yazisini assert ediniz ve gorundugunu dogrulayin
    public void TC_06() {
        //us02CheckBox.elementsCard.click();
        us02CheckBox.checkBoxBaslik.click();
        Assert.assertTrue(us02CheckBox.checkBoxBaslik.isDisplayed());
    }

    @Test // Check Box'in tiklanabildigini locate ettikten sonra secerek, test edin.
    public void TC_07() {
        //us02CheckBox.elementsCard.click();
        us02CheckBox.checkBoxKutu.click();
        us02CheckBox.artiButton.click();

        for (int i = 1; i <= 17; i++) {
            String input = "(//input)[" + i + "]"; //  17 tane menu var
            WebElement checkbox = Driver.getDriver().findElement(By.xpath(input));
            Assert.assertTrue(checkbox.isEnabled());

        }
    }

    @Test
                /* - Check Box butonunun altinda ACCEPTANCE CRITERIA'da belirtilen sekilde
            (Home, Desktop, Notes, Commands, Documents, WorkSpace, React, Angular,
                    Veu, Office, Public, Private, Classified, General, Downloads,
            Word File.doc, Excel,  Excel File.doc) elementlerinin gorundugunu dogrulayin!*/
    public void TC_08() {
        //us02CheckBox.elementsCard.click();
        us02CheckBox.checkBoxKutu.click();
        us02CheckBox.artiButton.click();

        Map<Integer, String> checkBoxKutu = new HashMap<>();
        for(int i=1; i<=17; i++) {
            String locateCheckboxText= "(//span[@class='rct-title'])["+ i + "]";
            String checkboxText = Driver.getDriver().findElement(By.xpath(locateCheckboxText)).getText();
            checkBoxKutu.put(i,checkboxText);
        }
        String [] realCheckboxTexts = {" ","Home", "Desktop", "Notes", "Commands", "Documents", "WorkSpace", "React", "Angular",
                "Veu", "Office", "Public", "Private", "Classified", "General", "Downloads", "Word File.doc", "Excel File.doc"};
        int i = 0;
        for(String w :realCheckboxTexts) {
            if(i>=1) {
                Assert.assertEquals(w,checkBoxKutu.get(i));
                System.out.println(w + " = " + checkBoxKutu.get(i));
            }
            i++;
        }
    }


    @Test    // TC008 'de belirtilen Web Elementlerinin secilebildigini locate
            // ettikten sonra sirasiyla secerek, test edin!
    public void TC_09() {
        //us02CheckBox.elementsCard.click();
        us02CheckBox.checkBoxKutu.click();
        us02CheckBox.artiButton.click();
        for(int i =1; i<=17; i++ ) {
            String xpathInput= "(//input)[" + i + "]";
            WebElement checkbox = Driver.getDriver().findElement(By.xpath(xpathInput));
            JavascriptExecutor jsExecuter = (JavascriptExecutor) Driver.getDriver();
            jsExecuter.executeScript("arguments[0].click();",checkbox);
        }

    }

    @Test // "Home,  Documents,   Private, Downloads, Word File.doc, Check Box'lari secildiginde
                // secildiklerine dair cikna uyari yazisini dogrulayin!"
    public void TC_10() {
        //us02CheckBox.elementsCard.click();
        us02CheckBox.checkBoxKutu.click();
        us02CheckBox.artiButton.click();

        for(int i =1; i<=17; i++ ) {
            String xpathInput= "(//input)[" + i + "]";
            WebElement checkbox = Driver.getDriver().findElement(By.xpath(xpathInput));
            JavascriptExecutor jsExecuter = (JavascriptExecutor) Driver.getDriver();
            jsExecuter.executeScript("arguments[0].click();",checkbox);
            Assert.assertTrue(us02CheckBox.text.isDisplayed());

        }
    }
}