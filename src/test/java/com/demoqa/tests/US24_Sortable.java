package com.demoqa.tests;

import com.demoqa.pages.US24_Sortable_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class US24_Sortable {



    //-Sortable menu linki tiklanabilir olmalidir.
    //-Sortable menusu altinda List ve Grid pencerelir bulunuyor olmali
    //-List menusu icerisinde "One","Two","Three","Four","Five","Six" kutucuklari bulunuyor olmali
    //-Liste menusu icerisinde bulunana tum kutucuklarin yerleri suruklenerek degistirilebiliyor olmali
    //
    //-Grid menusu icerisinde  "One","Two","Three","Four","Five","Six" kutucuklari bulunuyor olmali
    //-Grid menusu icerisinde bulunana tum kutucuklarin yerleri suruklenerek degistirilebiliyor olmali


    US24_Sortable_Page Us24_Page= new US24_Sortable_Page();
    WebDriverWait wait= new WebDriverWait(Driver.getDriver(),10);
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    Actions action = new Actions(Driver.getDriver());

    @BeforeMethod
    public void Setup(){

    Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    Driver.getDriver().manage().window().maximize();
    Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    jse.executeScript("arguments[0].click();",Us24_Page.Interactions);
    action.sendKeys(Keys.PAGE_DOWN).build().perform();



    }


    @Test
    public void Tc135(){
        //-Sortable menu linki tiklanabilir olmalidir.

        Assert.assertTrue(Us24_Page.Sortable.isEnabled());



    }
    @Test
    public void Tc136(){
        jse.executeScript("arguments[0].click();",Us24_Page.Sortable);
        //-Sortable menusu altinda List ve Grid pencerelir bulunuyor olmali
        List<WebElement> ListGridWindow= Us24_Page.Windows;

        for (WebElement ListAndGrid : ListGridWindow) {
            Assert.assertTrue(ListAndGrid.isDisplayed());
            System.out.println(ListAndGrid.getText());
        }
    }
    @Test
    public void Tc137(){
        //-List menusu icerisinde "One","Two","Three","Four","Five","Six" kutucuklari bulunuyor olmali
       //List menusu altinda  "One","Two","Three","Four","Five","Six" kutucuklarinin verilen siralamaya uygun oldugunu test ediniz

        jse.executeScript("arguments[0].click();",Us24_Page.Sortable);
        List<WebElement> actualList= Us24_Page.Listlist;


        String[] str={"One","Two","Three","Four","Five","Six"};//Expected result tc de verildi.

        for(int i=0;i<actualList.size();i++){
          Assert.assertTrue(actualList.get(i).isDisplayed());
          Assert.assertEquals(actualList.get(i).getText(),str[i]);
      }

    }

    @Test
    public void Tc138() {
        //-Liste menusu icerisinde bulunana tum kutucuklarin yerleri suruklenerek degistirilebiliyor olmali
        //"One" isimli kutucugu sirayla her sayinin altina suruklenebildigini kontrol ediniz
        jse.executeScript("arguments[0].click();", Us24_Page.Sortable);
        List<WebElement> beforeChange = Us24_Page.Listlist;
        ReusableMethods.waitFor(2);

        for (int i = 0; i < Us24_Page.Listlist.size() - 1; i++) {
            action.dragAndDrop(Us24_Page.Listlist.get(i), Us24_Page.Listlist.get(i + 1)).build().perform();
            ReusableMethods.waitFor(1);
            System.out.println(Us24_Page.Listlist.get(i + 1).getText());
            Assert.assertEquals(Us24_Page.Listlist.get(i + 1).getText(), "One");
        }
    }


    @Test
    public void Tc139() {
        //"One","Two","Three","Four","Five","Six" surukleyerek "Six","Five","Four","Three","Two","One" olabildigini Assert ediniz
        //"One","Two","Three","Four","Five","Six" surukleyerek "Six","Five","Four","Three","Two","One" olabildigini Assert ediniz

        jse.executeScript("arguments[0].click();", Us24_Page.Sortable);
        ReusableMethods.waitFor(1);

        String [] expected={"Six","Five","Four","Three","Two","One"};


        for(int i=0; i<Us24_Page.Listlist.size();i++){

            action.dragAndDrop(Us24_Page.Listlist.get(5),Us24_Page.Listlist.get(i)).build().perform();
            ReusableMethods.waitFor(2);
          Assert.assertEquals(Us24_Page.Listlist.get(i).getText(),expected[i]);

        }

    }

    @Test
    public void Tc140(){
        //-Grid menusu icerisinde  "One","Two","Three","Four","Five","Six" kutucuklari bulunuyor olmali
        //Grid menusu altindaki butun kutucuklari sirayla en sag ve alt satira suruklendigini assert ediniz

        jse.executeScript("arguments[0].click();",Us24_Page.Sortable);
        Us24_Page.GridButton.click();
        ReusableMethods.waitFor(2);


        int x= Us24_Page.GridList.size();  //once menude ki butun kutulari Assert  ettik.
        for(int i=0;i<x;i++){
            Assert.assertTrue(Us24_Page.GridList.get(i).isDisplayed());
        }
        String[] expectedList={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        for (int i=0; i<x; i++){
            action.dragAndDrop(Us24_Page.GridList.get(0),Us24_Page.GridList.get(2)).build().perform();
            Assert.assertEquals(Us24_Page.GridList.get(2).getText(),expectedList[i]);
            ReusableMethods.waitFor(1);
            action.dragAndDrop(Us24_Page.GridList.get(2),Us24_Page.GridList.get(8)).build().perform();
            Assert.assertEquals(Us24_Page.GridList.get(8).getText(),expectedList[i]);
            ReusableMethods.waitFor(1);
        }

    }
    @Test
    public void Tc141(){
        //-Grid menusu icerisinde bulunana tum kutucuklarin yerleri suruklenerek degistirilebiliyor olmali
        //Grid menusu altindaki butun kutucuklarin sol en ust kisima suruklenebildigini assert ediniz

       // jse.executeScript("arguments[0].click();",Us24_Page.Sortable);
        Us24_Page.Sortable.click();
        Us24_Page.GridButton.click();
        ReusableMethods.waitFor(2);
        String[] expectedList={"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};

        for(int i=0; i<Us24_Page.GridList.size();i++){

            action.dragAndDrop(Us24_Page.GridList.get(i),Us24_Page.GridList.get(0)).build().perform();
            Assert.assertEquals(Us24_Page.GridList.get(0).getText(),expectedList[i]);
            ReusableMethods.waitFor(1);


        }



    }

}
