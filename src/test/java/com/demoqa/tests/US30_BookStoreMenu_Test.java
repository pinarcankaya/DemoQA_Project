package com.demoqa.tests;
import com.demoqa.pages.US023_SelectMenu_Page;
import com.demoqa.pages.US030_BookStoreMenu_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.*;
import org.openqa.selenium.html5.Location;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.*;
import java.util.concurrent.TimeUnit;
public class US30_BookStoreMenu_Test { JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
    Actions action=new Actions(Driver.getDriver());
    US030_BookStoreMenu_Page us030BookStoreMenuPage=new US030_BookStoreMenu_Page();
    WebDriverWait wait= new WebDriverWait(Driver.getDriver(),15);


    @Test (priority = 1)
    public void setUp() throws InterruptedException {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //Driver.getDriver().navigate().refresh();
        //action.sendKeys(Keys.PAGE_DOWN).perform();
       // Thread.sleep(2000);
        //jse.executeScript("window.scrollBy(0,750)");
        ReusableMethods.clickStaleElement(us030BookStoreMenuPage.BookStoreAppCard);
        //ReusableMethods.clickWithJS(us030BookStoreMenuPage.BookStoreAppCard);
        //us030BookStoreMenuPage.BookStoreAppCard.click();
    }
    @Test (priority = 2, dependsOnMethods = "setUp")
    //Book Store ifadesi Baslik olarak gorunmeli
    public void US030176(){
        String s="Book Store";
        WebElement BookStoreHeader=us030BookStoreMenuPage.BookStoreHeader;
        Assert.assertTrue(BookStoreHeader.isDisplayed()&&BookStoreHeader.getText().contentEquals(s));
        Assert.assertTrue(us030BookStoreMenuPage.SearchBox.isDisplayed()&&us030BookStoreMenuPage.SearchBox.isEnabled());
        Assert.assertTrue(us030BookStoreMenuPage.LoginButton.isDisplayed()&&us030BookStoreMenuPage.LoginButton.isEnabled());

    }

    @Test  (priority = 3, dependsOnMethods = "setUp")
    //Arama alaninin altinda sirasiyla " Image, Title,Author ve Publisher " sekmeleri gorunmeli ve aktif olmali
    public void US030177(){
        // Point location=us030BookStoreMenuPage.ColumnHeaders.get(1).getLocation();
        List<WebElement> columnHeaders=us030BookStoreMenuPage.ColumnHeaders;
        String []  columnHeadersName=new String[]{"Image","Title","Author","Publisher"};

        for (int i = 0; i < columnHeaders.size(); i++) {
            Assert.assertEquals(columnHeaders.get(i).getText(),columnHeadersName[i]);
            Assert.assertTrue(columnHeaders.get(i).isEnabled());
        }

    }

    @Test  (priority = 4, dependsOnMethods = "setUp")
    /*Liste de kitap ismi ,yazar ismi  ve yayinci ismi  search girince  ilgili sonuclar dogru olarak gorunmeli
     ya teker teker yada hepsini bir anda girerek test edebilirsiniz*/
    public void US030178(){

        String [] searchWord=new String[] {"Git", "Java", "Marijn", "Reilly"};


        for (String w : searchWord) {
            action.sendKeys(us030BookStoreMenuPage.SearchBox, w).perform();


            int newSize=us030BookStoreMenuPage.textofRow.size();
            ReusableMethods.waitFor(1);

            for (int i = 0; i < newSize; i++) {
                Assert.assertTrue(us030BookStoreMenuPage.textofRow.get(i).getText().contains(w));

            }

            us030BookStoreMenuPage.SearchBox.clear();
        }

    }

    @Test  (priority = 5, dependsOnMethods = "setUp")
    /* Kitab liste tablosunun altinda  "Previous ve Next "yon ifaderli olmai ve Page gosterge alani gorunur ve aktif
    olmali ve satir sayisini gosteren  aktif rows ifadesi olmali ve en 5 en fazla 100 Row secilebilir olmali .*/

    public void TC030179(){

        int bookListLocationY=us030BookStoreMenuPage.BookListTable.getLocation().getY();//299
        int previousAndNextBarY=us030BookStoreMenuPage.previousAndNextBar.getLocation().getY();//1167

        Assert.assertTrue(bookListLocationY<previousAndNextBarY);


        Assert.assertTrue(us030BookStoreMenuPage.PageNumber.isDisplayed()&&us030BookStoreMenuPage.PageNumber.isEnabled());
        Assert.assertTrue(us030BookStoreMenuPage.RowsButton.isEnabled());

        Select select=new Select(us030BookStoreMenuPage.RowsButton);

        String firstRowOption=select.getOptions().get(0).getText();
        String lastRowOption=select.getOptions().get(select.getOptions().size()-1).getText();
        Assert.assertTrue(firstRowOption.equals("5 rows")&&lastRowOption.equals("100 rows"));

        for (int i = 0; i <select.getOptions().size() ; i++) {
            String toBeSelected=select.getOptions().get(i).getText();

            select.selectByIndex(i);
            String selected=select.getFirstSelectedOption().getText();

            Assert.assertEquals(selected, toBeSelected);
        }


    }

    @Test  (priority = 6, dependsOnMethods = "setUp")
    /*
    Kitap table listesinden bir Kitap ismine tiklanip , o kitabla ilgili "ISBN :
Title :
Sub Title :
Author :
Publisher :
Total Pages :
Description :
Website :  "   olmali ve  ilgili bilgiler gorunur ve ulasilir olmali .

ilgili kitabin linkinin calisip calismadigini linki acarak test ediniz
     */

    public void TC030180 (){

        List <String> bookInfoList= new ArrayList<>();
        bookInfoList.add("ISBN :\n" + "9781449325862");
        bookInfoList.add("Title :\n" + "Git Pocket Guide");
        bookInfoList.add("Sub Title :\n" + "A Working Introduction");
        bookInfoList.add("Author :\n" + "Richard E. Silverman");
        bookInfoList.add("Publisher :\n" + "O'Reilly Media");
        bookInfoList.add("Total Pages :\n" + "234");
        bookInfoList.add("Description :\n" + "This pocket guide is the perfect on-the-job companion to Git, " +
                "the distributed version control system. It provides a compact, readable introduction to Git for" +
                " new users, as well as a reference to common commands and procedures for those of you with Git exp");
        bookInfoList.add("Website :\n" + "http://chimera.labs.oreilly.com/books/1230000000561/index.html");
         ReusableMethods.waitForClickablility(us030BookStoreMenuPage.GitPocketGuideLink,10);

        //ReusableMethods.waitFor(1);
        us030BookStoreMenuPage.GitPocketGuideLink.click();

        for (int i = 0; i < us030BookStoreMenuPage.BookCardList.size()-1; i++) {
            Assert.assertEquals(us030BookStoreMenuPage.BookCardList.get(i).getText(),bookInfoList.get(i));
            Assert.assertTrue(us030BookStoreMenuPage.BookCardList.get(i).isDisplayed());

        }
        String currentWindowHandle=Driver.getDriver().getWindowHandle();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        //ReusableMethods.waitFor(1);
        ReusableMethods.waitForClickablility(us030BookStoreMenuPage.websiteLink,10);
        us030BookStoreMenuPage.websiteLink.click();
        Set<String> windowHandles=Driver.getDriver().getWindowHandles();
        for (String handle: windowHandles
        ) {

            if(!currentWindowHandle.equals(handle)){
                Driver.getDriver().switchTo().window(handle);
                Assert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.oreilly.com/");
            }

        }
        Driver.getDriver().switchTo().window(currentWindowHandle);

    }

    @Test  (priority = 7, dependsOnMethods = "setUp")
    /*
    "Back to BookStore  butunun  assert ediniz  tiklanir olup olmadigini ve istenilen yere gelip gelmedigini
     */
    public void TC030181 (){
        //ReusableMethods.waitFor(2);
        wait.until(ExpectedConditions.elementToBeClickable(us030BookStoreMenuPage.bookListBody.get(0)));
        us030BookStoreMenuPage.GitPocketGuideLink.click();
        //ReusableMethods.waitFor(1);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        wait.until(ExpectedConditions.elementToBeClickable(us030BookStoreMenuPage.backToStoreButton));
        Assert.assertTrue(us030BookStoreMenuPage.backToStoreButton.isEnabled());
        us030BookStoreMenuPage.backToStoreButton.click();
        Assert.assertTrue(us030BookStoreMenuPage.BookStoreHeader.isDisplayed());
    }

    @Test  (priority = 7, dependsOnMethods = "setUp")
    /*
    Login buttonuda yine gorunur ve aktif olmali ve tiklandiginda  Login alanina gitmeli sayfa .
     */

    public void TC030182(){

        Assert.assertTrue(us030BookStoreMenuPage.LoginButton.isEnabled());
        us030BookStoreMenuPage.LoginButton.click();
        Assert.assertEquals(us030BookStoreMenuPage.LoginMainHeader.getText(), "Login");


    }

    @AfterClass
    public  void close(){
        Driver.getDriver().quit();
    }
}
