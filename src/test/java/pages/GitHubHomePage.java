package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class GitHubHomePage {
    public GitHubHomePage() {

        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(name = "q")
    public WebElement search;

    @FindBy(xpath = "//div[@class='f4 text-normal']/a")
    public List<WebElement> resultList;

    @FindBy(xpath = "(//ul)[22]/li")
    public List<WebElement>socialMediaLinks;



}
