package com.demoqa.tests;


import com.demoqa.pages.US01_TextBox_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class US01_TextBox_Test {

    US01_TextBox_Page us01TextBoxPage = new US01_TextBox_Page();
    Actions actions=new Actions(Driver.getDriver());


    @BeforeTest
    public void setup() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test // ? Text Box Element butonunun hemen altinda yer almalidir.
    public void TC01() {
        us01TextBoxPage.elementsCard.click();
        System.out.println(us01TextBoxPage.menuList.get(0).getText());
        Assert.assertEquals(us01TextBoxPage.menuList.get(0).getText(),"Text Box");
    }

    @Test// ! Text Box yazisi header olarak bulunmalidir.
    public void TC02() {
        us01TextBoxPage.elementsCard.click();
        us01TextBoxPage.textBoxMenuLink.click();
        Assert.assertTrue(us01TextBoxPage.textBoxHeader.isDisplayed());
        System.out.println(us01TextBoxPage.textBoxHeader.getCssValue("font-size"));
        System.out.println(us01TextBoxPage.formList.get(0).getCssValue("font-size"));

    }

    // ?- Text Box'in tiklanabildigini check edin.+++
    //- Full Name, Email, Current Address ,  Permanent Address, Submit elementleri
    //gorunuyor olmali.++++
    //- Full Name, Email, Current Address , Permanent Address, text boxlarina veri
    //girilebilir olmali.  ++
    //- Email; asagida yazili 5 sarttan biri eksik oldugunda Email kayit edilememeli
    //1.@ isareti kullanilmadan kayit yapilamamali
    //2.@ isareti oncesi bos birakilmamali
    //3.@ isaretinden sonra ve "."dan once en az bir harf veya bir sayi olmali
    //4.@ isaretinden sonra en az bir harf veya sayi girildikten sonra"." olmali ve "." dan
    //sonra en az iki harf ve/veya iki sayi olmali
    //- Submit butonuna tiklanabilinmelidir
    @Test
    public void TC03() {
        us01TextBoxPage.elementsCard.click();
        us01TextBoxPage.textBoxMenuLink.click();
        Assert.assertTrue(us01TextBoxPage.textBoxMenuLink.isEnabled());

        actions.sendKeys(Keys.ARROW_DOWN).perform();
        actions.sendKeys(Keys.ARROW_DOWN).perform();

        String[] expected={"Full Name","Email","Current Address","Permanent Address","Submit"};

        for (int i = 0; i <=4; i++) {
            System.out.println(us01TextBoxPage.formList.get(i).getText());
            Assert.assertEquals(us01TextBoxPage.formList.get(i).getText(), expected[i]);
        }

        for (int i = 0; i <=4; i++){
            Assert.assertTrue(us01TextBoxPage.formList.get(i).isEnabled());

        }

    }
}