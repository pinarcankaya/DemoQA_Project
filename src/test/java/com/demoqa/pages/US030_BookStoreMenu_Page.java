package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;
import java.util.List;

public class US030_BookStoreMenu_Page {

    public US030_BookStoreMenu_Page (){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (xpath = "(//div[@class='card-up'])[6]") // ////h5[text()='Book Store Application']
    public WebElement BookStoreAppCard;

    @FindBy (xpath = "//div[@class='main-header']")
    public WebElement BookStoreHeader;

    @FindBy (xpath = "//div[@tabindex='-1']")
    public List<WebElement> ColumnHeaders;

    @FindBy(xpath = "//input[@id='searchBox']")
    public WebElement SearchBox;

    @FindBy (xpath = "//span[@id='basic-addon2']")
    public WebElement SearchButton;

    @FindBy (xpath = "//div[@class='rt-table']")
    public WebElement BookListTable;

    @FindBy (xpath = "//button[@class='-btn']")
    public List <WebElement> PreviousAndNext;

    @FindBy(xpath = "//input[@type='number']")
    public WebElement PageNumber;

    @FindBy (xpath = "//select[@aria-label='rows per page']")
    public WebElement RowsButton;

    @FindBy(xpath = "//div[@class='profile-wrapper']/div")
    public List <WebElement> BookCardList;

    @FindBy(xpath = "//button[@id='login']")
    public WebElement LoginButton;

    @FindBy(xpath = "//div[@class= 'main-header']")
    public WebElement LoginMainHeader;

    @FindBy(xpath="//div[@class='rt-tr-group']")
    public List <WebElement> bookRowGroup;

//    @FindBy(xpath="//div[@class='rt-td']")
//    public List <WebElement> textofRow;

    @FindBy(xpath="//div[@class='rt-tr-group']/div[not(contains(@class, '-padRow'))]")
    public List <WebElement> textofRow;

    @FindBy(xpath = "//div[@class='-pagination']")
    public WebElement previousAndNextBar;

    @FindBy (xpath = "//div[@class='rt-tbody']//a")
    public List <WebElement> bookListBody;

    @FindBy(xpath = "//button[@id='addNewRecordButton']")
    public WebElement backToStoreButton;

    @FindBy (xpath = "//a[.='Git Pocket Guide']")
    public WebElement GitPocketGuideLink;

    @FindBy (xpath = "(//label[@id='userName-value'])[8]")
    public  WebElement websiteLink;



}
