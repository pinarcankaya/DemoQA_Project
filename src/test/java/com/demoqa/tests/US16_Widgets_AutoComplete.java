package com.demoqa.tests;

import com.demoqa.pages.US08_DynamicProperties_Page;
import com.demoqa.pages.US16_AutoComplete_page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US16_Widgets_AutoComplete {


    protected WebDriver driver=driver = Driver.getDriver();
    protected WebDriverWait wait=wait = new WebDriverWait(driver, 10);
    JavascriptExecutor jse= (JavascriptExecutor) driver;
    US16_AutoComplete_page us16_page = new US16_AutoComplete_page();
    Actions actions = new Actions(Driver.getDriver());
    SoftAssert soft = new SoftAssert();

    @BeforeMethod
    public void setUp() {

        driver.get(ConfigurationReader.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        wait.until(ExpectedConditions.elementToBeClickable(us16_page.Widgets));
        us16_page.Widgets.click();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us16_page.AutoComplete));
        us16_page.AutoComplete.click();


    }

    @AfterClass
    public void close() {  Driver.closeDriver();   }

    @Test(priority = 1)
    public void TC_74() {

        //- Sayfanın başlığı "Auto Complete" olmalıdir.


        String actualResult = new US08_DynamicProperties_Page().MainHeader.getText();
        System.out.println("actualResult = " + actualResult);
        String expectedResult = "Auto Complete";

        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test(priority = 2)
    public void TC_75() {

        //-Üst Text boxların başlığı "Type multiple color names" olmalıdır.

        String actualText = us16_page.TopTextBoxHeader.getText();
        System.out.println(actualText);
        String expectedText = "Type multiple color names";

        Assert.assertEquals(actualText, expectedText);
    }


    @Test(priority = 3)
    public void TC_76() {

        //-Alt Text boxların başlığı "Type single color name" olmalıdır.
        String actualText = us16_page.BottomTextBoxHeader.getText();
        System.out.println("actualText = " + actualText);
        String expectedText = "Type single color name";

        Assert.assertEquals(actualText, expectedText);
    }

    @Test(priority = 4)
    public void Tc77() {

        //Üst Text box.a yazılan harfleri içeren renkler aşağıya listelenmelidir.

       actions.click(us16_page.TopBox).sendKeys("R").build().perform();

        List<String> expectedColors = new ArrayList<>();
        expectedColors.add("Red");
        expectedColors.add("Green");
        expectedColors.add("Purple");


        for (int i = 0; i < expectedColors.size(); i++) {
            Assert.assertEquals(us16_page.colors.get(i).getText(), expectedColors.get(i));
            System.out.println("Actual result : "+us16_page.colors.get(i).getText());
            System.out.println("Expected result : "+expectedColors.get(i));
        }

        System.out.println("**************************************************");

        actions.click(us16_page.TopBox).sendKeys("w").build().perform();
        List<String> expectedColors2 = new ArrayList<>();
        expectedColors2.add("Yellow");
        expectedColors2.add("White");

        for (int i = 0; i < expectedColors2.size(); i++) {
            Assert.assertEquals(us16_page.colors.get(i).getText(), expectedColors2.get(i));
            System.out.println("Actual result : "+us16_page.colors.get(i).getText());
            System.out.println("Expected result : "+expectedColors2.get(i));

        }


    }

    @Test(priority = 5)
    public void Tc78(){

       // Kullanıcı Üst Text boxta listelenen renklerden bir tane renk seçebilmelidir.

        actions.click(us16_page.TopBox).sendKeys("R").build().perform();

        actions.click(us16_page.colors.get(0)).build().perform();

        Assert.assertEquals(us16_page.selectedColor.getText(),"Red");

    }

    @Test(priority = 6)
    public void Tc79(){
        //Kullanıcı Üst Text boxta listeden birden fazla renk seçebilmelidir.

        actions.click(us16_page.TopBox).sendKeys("w").build().perform();

        actions.click(us16_page.colors.get(0)).build().perform();

        actions.click(us16_page.TopBox).sendKeys("r").build().perform();

        actions.click(us16_page.colors.get(1)).build().perform();

        System.out.println(us16_page.UpBoxSelectedColors.size());

        Assert.assertTrue(us16_page.UpBoxSelectedColors.size()>1);

    }

    @Test(priority = 7)
    public void tc80(){

        //Kullanıcı Üst Text boxta seçtiği bir rengi silebilmelidir

        actions.click(us16_page.TopBox).sendKeys("w").build().perform();

        actions.click(us16_page.colors.get(0)).build().perform();

        actions.click(us16_page.TopBox).sendKeys("r").build().perform();

        actions.click(us16_page.colors.get(1)).build().perform();

        int beforeDelete= us16_page.UpBoxSelectedColors.size();
        System.out.println("beforeDelete = " + beforeDelete);

        actions.click(us16_page.delete.get(0)).build().perform();

        int afterDelete= us16_page.UpBoxSelectedColors.size();
        System.out.println("afterDelete = " + afterDelete);


        Assert.assertTrue(beforeDelete-1==afterDelete);

    }

    @Test(priority = 8)
    public void tc81(){

        //Kullanıcı Üst Text boxtaseçtiği birden fazla rengi silebilmelidir.

        actions.click(us16_page.TopBox).sendKeys("w").build().perform();

        actions.click(us16_page.colors.get(0)).build().perform();

        actions.click(us16_page.TopBox).sendKeys("r").build().perform();

        actions.click(us16_page.colors.get(1)).build().perform();

        int beforeDelete= us16_page.UpBoxSelectedColors.size();
        System.out.println("beforeDelete = " + beforeDelete);

        actions.click(us16_page.delete.get(0)).build().perform();

        actions.click(us16_page.delete.get(0)).build().perform();


        int afterDelete= us16_page.UpBoxSelectedColors.size();
        System.out.println("afterDelete = " + afterDelete);


        Assert.assertTrue(beforeDelete-2==afterDelete);


    }

    @Test(priority = 9)
    public void tc82(){

        //Alt Text box.a yazılan harfleri içeren renkler aşağıya listelenmelidir.

        actions.click(us16_page.BottomBox).sendKeys("e").build().perform();


        for(int i=0; i<us16_page.bottomBoxList.size();i++){

            Assert.assertTrue(us16_page.bottomBoxList.get(i).isDisplayed());
            System.out.println(us16_page.bottomBoxList.get(i).getText());
        }

    }

    @Test(priority = 10)
    public void tc83(){

        //Kullanıcı Alt Text boxta listelenen renklerden bir tane renk seçebilmelidir.


        actions.click(us16_page.BottomBox).sendKeys("e").build().perform();

        actions.click(us16_page.bottomBoxList.get(2)).build().perform();

        System.out.println(us16_page.BottomBox.getText());
        Assert.assertTrue(us16_page.BottomBox.isDisplayed());


    }

}
