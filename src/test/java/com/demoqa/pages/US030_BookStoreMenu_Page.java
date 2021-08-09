package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US030_BookStoreMenu_Page {

    public US030_BookStoreMenu_Page (){PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy (xpath = "//h5[text()='Book Store Application']")
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
    public WebElement Rows;

    @FindBy(xpath = "//div[@class='profile-wrapper']/div")
    public List <WebElement> BookCardList;

    @FindBy(xpath = "//button[@id='login']")
    public WebElement LoginButton;

    @FindBy(xpath = "//div[@class= 'main-header']")
    public WebElement LoginMainHeader;





}
