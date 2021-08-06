package com.demoqa.pages;

import com.demoqa.utilities.ConfigurationReader;
import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

import javax.swing.*;
import java.util.concurrent.TimeUnit;

public class US17_Date_Picker_Page {

    public US17_Date_Picker_Page() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='avatar mx-auto white'])[4]")
    public WebElement widgedsMenü;

    @FindBy(xpath = "(//span[@class='text'])[18]")
    public WebElement datePicker;


    @FindBy(xpath = "//div[@class='react-datepicker__day react-datepicker__day--003 react-datepicker__day--selected']")
    public WebElement date03;

    @FindBy(xpath = "//button[@aria-label='Previous Month']")
    public WebElement öncekiAy;


    @FindBy(xpath = "(//div[text()='30'])[2]")
    public WebElement newDate;

    @FindBy(className = "react-datepicker__month-select")
    public WebElement Month;

    @FindBy(id = "datePickerMonthYearInput")
    public WebElement selectDateBox;

    @FindBy(xpath = "//button[@aria-label='Next Month']")
    public WebElement sonrakiAy;

    @FindBy(xpath = "(//div[text()='29'])")
    public WebElement sonrakiAyDate;


}
