package com.demoqa.tests;

import com.demoqa.pages.US04_WebTable_Page;
import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import com.demoqa.utilities.ReusableMethods;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class US04_WebTable_Test {

    US04_WebTable_Page webTablePage;
    WebDriverWait wait;


    {
        webTablePage = new US04_WebTable_Page();
        wait = new WebDriverWait(Driver.getDriver(),10);
    }

    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get(ConfigurationReader.getProperty("element_url"));
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webTablePage.webtableMenuLink.click();

    }

    @Test(priority = 1)
    public void TC01() {
        //Elements accordion menusu altinda bulunan Web Tables linkine tiklandiginda Add butonu goruntulenebilir olmalidir.

        assertTrue(webTablePage.addButton.isDisplayed());

    }

    @Test(priority = 2)
    public void TC02() {
        // Add butonuna tiklandiginda Registration Form yazisi firstname, lastname,email, age, salary ve department
        // textboxlari goruntulenebilir olmalidir.
        webTablePage.addButton.click();
        wait.until(ExpectedConditions.visibilityOf(webTablePage.firstNameTextBox));
        assertTrue(webTablePage.firstNameTextBox.isDisplayed());
        assertTrue(webTablePage.lastNameTextBox.isDisplayed());
        assertTrue(webTablePage.userEmailTextBox.isDisplayed());
        assertTrue(webTablePage.ageTextBox.isDisplayed());
        assertTrue(webTablePage.salaryTextBox.isDisplayed());
        assertTrue(webTablePage.departmentTextBox.isDisplayed());

    }

    @Test(priority = 3)
    public void TC03() {
        // Registration formu gecerli verilerle eksiksiz doldurulup Submit butonuna tiklandiginda
        // web tablede bir kayit olusturulabilmelidir.
        webTablePage.addButton.click();
        webTablePage.firstNameTextBox.sendKeys(ConfigurationReader.getProperty("firstname"));
        webTablePage.lastNameTextBox.sendKeys(ConfigurationReader.getProperty("lastname"));
        webTablePage.userEmailTextBox.sendKeys(ConfigurationReader.getProperty("email"));
        webTablePage.ageTextBox.sendKeys(ConfigurationReader.getProperty("age"));
        webTablePage.salaryTextBox.sendKeys(ConfigurationReader.getProperty("salary"));
        webTablePage.departmentTextBox.sendKeys(ConfigurationReader.getProperty("department"));
        webTablePage.submitButton.click();

        wait.until(ExpectedConditions.visibilityOf(webTablePage.addedName));
        assertTrue(webTablePage.addedName.getText().contains(ConfigurationReader.getProperty("firstname")));




    }

    @Test(priority = 4)
    public void TC04() {


//Registration formundaki ogelerden en az bir tanesi bos birakildiginda veya gecersiz veri
// ile doldurulup submit buttonuna tiklandiginda gecersiz veri girilen textboxta hata uyarisi goruntulenmelidir.

        webTablePage.addButton.click();
        webTablePage.firstNameTextBox.sendKeys("gg");
        webTablePage.submitButton.click();
        ReusableMethods.waitFor(1);

        String firstNameColor = webTablePage.firstNameTextBox.getCssValue("border-color");
        System.out.println(firstNameColor);
        ReusableMethods.waitFor(1);
        String lastNameColor = webTablePage.lastNameTextBox.getCssValue("border-color");
        System.out.println(lastNameColor);

//        assertEquals(lastNameColor,ConfigurationReader.getProperty("expectedColorLast"));
//        assertEquals(firstNameColor,ConfigurationReader.getProperty("expectedColorFirst"));




    }


    @Test(priority = 5)
    public void TC05() throws InterruptedException {
      //  Web table action bolumunde bulunan Edit ve Delete fonksiyonlari dogru calismalidir.

          webTablePage.deleteButton.click();
          Thread.sleep(1000);
          webTablePage.searchTextBox.sendKeys(ConfigurationReader.getProperty("searchName"));
          assertTrue(webTablePage.noRowsText.isDisplayed());

      //////////////////////////////////////////////////////////////////////////////////
          Driver.getDriver().navigate().refresh();
     //////////////////////////////////////////////////////////////////////////////////

         webTablePage.editButton.click();
         Thread.sleep(1000);
         webTablePage.firstNameTextBox.clear();
         webTablePage.firstNameTextBox.sendKeys(ConfigurationReader.getProperty("editName"));
         webTablePage.submitButton.click();
         assertTrue(webTablePage.firstSatir.getText().contains(ConfigurationReader.getProperty("editName")));




    }

    @AfterClass
    public void afterMethod(){
     //   Driver.getDriver().navigate().to(ConfigurationReader.getProperty("url"));
    }



    }









