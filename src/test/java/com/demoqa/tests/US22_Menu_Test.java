package com.demoqa.tests;

import com.demoqa.pages.US21_ToolTips_Page;
import com.demoqa.pages.US22_Menu_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US22_Menu_Test {

    Actions actions = new Actions(Driver.getDriver());
    US22_Menu_Page menuPage = new US22_Menu_Page();

    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        ReusableMethods.scrollTo(menuPage.widgetMenuCard);
        menuPage.widgetMenuCard.click();
        ReusableMethods.waitFor(2);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
       // ReusableMethods.scrollTo(menuPage.menuLink);
        menuPage.menuLink.click();
    }

    //- Sayfanın başlığı "Menu" olmalıdir.
    @Test
    public void TC119() {
    }


    //-Text boxlar yesil renk dolgu ve beyaz yazi tipinde olmalidir
    @Test
    public void TC120() {
        ReusableMethods.waitFor(1);
        for (WebElement w : menuPage.menuContainerList) {
            String menuBackgroundColor = ReusableMethods.getHexColor(w, "background-color");
            System.out.println(menuBackgroundColor);
            Assert.assertEquals(menuBackgroundColor, "#24af15");
        }
    }

    //-Text boxların başlıklari "Main Item 1" , "Main Item 2" , "Main Item 3" olmalıdir.
    @Test
    public void TC121() {

        String arr[]={"Main Item 1","Main Item 2","Main Item 3"};
        for (int i = 0; i <menuPage.mainItemList.size() ; i++) {
            Assert.assertEquals(menuPage.mainItemList.get(i).getText(),arr[i]);
        }

    }

    //-Üst Text box hover yapilinca box ici koyu yesil renk olsun
    @Test
    public void TC122() {
        for (WebElement w : menuPage.menuContainerList) {
            actions.moveToElement(w).build().perform();
            String menuBackgroundColor = ReusableMethods.getHexColor(w, "background-color");
            System.out.println(menuBackgroundColor);
        }
    }
    //-Üst Text box 2 hover yapilinca 3 adet sub Text Box asagiya acilsin.
    @Test
    public void TC123() {
    }

    //-Sirasiyla isimleri "Sub Item", "Sub Item" ve "SUB SUB LIST »" seklinde gorulsun
    @Test
    public void TC124() {
    }

    //"-""SUB SUB LIST »"" Sub Text Box hover yapildiginda koyu yesil renk olsun ve
    //  sag tarafa 2 adet Sub Sub Text Box acilsin"
    @Test
    public void TC125() {
    }

    //-Isimleri sirasiyla "Sub Sub Item 1" ve"Sub Sub Item 2" seklinde gorulsun
    @Test
    public void TC126() {
    }


    //-Sub Sub Text Box'lar hover edildiginde koyu yesil renk alsin
    @Test
    public void TC127() {
    }


}
