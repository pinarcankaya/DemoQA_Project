package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US29_BookStoreApp_Page {
    public US29_BookStoreApp_Page(){
        PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "(//div[@class='card mt-4 top-card'])[6]")
    public WebElement bookStoreCard;

    @FindBy(xpath = "//div[.='Book Store Application']")
    public WebElement bookStoreApplication;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement headerBookStore;

    @FindBy(xpath = "//span[contains(text(), 'Login')]")
    public List<WebElement> login;

    @FindBy(xpath = "//span[contains(text(), 'Login')]")
    public WebElement logIn;

    @FindBy(xpath = "//span[contains(text(), 'Book Store')]")
    public List<WebElement> bookStore;

    @FindBy(xpath = "//span[contains(text(), 'Profile')]")
    public List<WebElement> profile;

    @FindBy(xpath = "//span[contains(text(), 'Book Store API')]")
    public List<WebElement> bookStoreAPI;

    @FindBy(xpath = "//div[@style='margin-bottom: 50px;']")
    public WebElement headerWelcome;

    @FindBy(id = "newUser")
    public WebElement newUserButton;

    @FindBy(xpath = "(//input[@class='mr-sm-2 form-control'])")
    public List<WebElement> registerButtons;

    @FindBy(xpath = "//button[@id='register']")
    public WebElement register;

    @FindBy(xpath = "//button[@id='gotologin']")
    public WebElement backToLogin;





}
