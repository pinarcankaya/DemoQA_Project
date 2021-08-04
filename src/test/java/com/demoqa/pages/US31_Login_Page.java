package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class US31_Login_Page {
    public US31_Login_Page(){ PageFactory.initElements(Driver.getDriver(),this);}

    @FindBy(xpath = "//h5[.='Book Store Application']")
    public WebElement BookStore;

    @FindBy(xpath = "//span[.='Login']")
    public WebElement LoginButton;

    @FindBy(id = "newUser")
    public WebElement Register;

    @FindBy(xpath = "//div[@class='main-header']")
    public WebElement HeaderRegister;

    @FindBy(xpath = "//input[@class='mr-sm-2 form-control']")
    public List<WebElement> RegisterPageList;

    @FindBy(id = "firstname")
    public WebElement firstname;

    @FindBy(id = "lastname")
    public WebElement lastname;

    @FindBy(id = "userName")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement reCap;

    @FindBy(id = "register")
    public WebElement newRegister;

    @FindBy(xpath = "//input[@class='mr-sm-2 is-invalid form-control']")
    public WebElement inValidRegister;

    @FindBy(id = "gotologin")
    public WebElement BackToLogin;

}
