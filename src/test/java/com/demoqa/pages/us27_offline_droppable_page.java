package com.demoqa.pages;

import com.demoqa.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class us27_offline_droppable_page {

    public us27_offline_droppable_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//div[@class='card-up' ])[5]")
    public WebElement interactionsMenuCard;

    @FindBy(xpath = "(//li[@id='item-3'])[4]")
    public WebElement droppableMenuLink;

    @FindBy(xpath = "//a[contains(@id,'droppableExample')]")
    public List<WebElement> droppableTabsList;

    @FindBy(xpath = "//div[@id='draggable']")
    public WebElement dragMeBox;

    @FindBy(xpath = "//div[@id='droppable']")
    public WebElement simpleDragHearBox;

    @FindBy(xpath = "//div[@id='droppable']/p")
    public WebElement droppedText;

    @FindBy(xpath = "//div[@id='acceptable']")
    public WebElement acceptableBox;

    @FindBy(xpath = "(//div[@id='droppable'])[2]")
    public WebElement acceptDropHearBox;

    @FindBy(xpath = "//div[@id='notAcceptable']")
    public WebElement notAcceptableBox;

    @FindBy(xpath = "//div[@id='dragBox']")
    public WebElement preventDrogMeBox;

    @FindBy(xpath = "//div[@id='notGreedyDropBox']")
    public WebElement outerDroppable;

    @FindBy(xpath = "(//p[.='Outer droppable'])")
    public WebElement outerDroppableText;


    @FindBy(xpath = "//div[@id='notGreedyInnerDropBox']")
    public WebElement innerDroppable;

    @FindBy(xpath = "//div[@id='revertable']")
    public WebElement willRevertBox;

    @FindBy(xpath = "//div[@id='notRevertable']")
    public WebElement notRevertBox;

    @FindBy(xpath = "(//div[@id='droppable'])[3]")
    public WebElement revertDropHereBox;



}
