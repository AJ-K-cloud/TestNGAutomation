package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class TrashPage {
    public TrashPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//li[text()='Trash']")
    public WebElement trashButton;

    @FindBy(xpath = "//ul/li[8]")
    public WebElement lastPageButton;


    @FindBy(xpath = "//tbody/tr/td/p")
    public List<WebElement> lastDeletedStudentsList;
}
