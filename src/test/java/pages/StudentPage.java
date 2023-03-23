package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class StudentPage {

    public StudentPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//div[@id='root']/div/div/nav/a[4]/li")
    public WebElement StudentsButton;
    @FindBy(xpath = "//*[@id='root']/div/div[2]/div/div/div[2]/div[1]/div/table/tbody/tr[1]/td[2]/p")
    public WebElement student;
    @FindBy(xpath = "//tbody/tr[1]/td[7]/div/button[1]")
    public WebElement threeDotsButton;

    @FindBy(xpath = "/html/body/div[2]/div[3]/ul/li[3]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[.='Delete']")
    public WebElement deleteConfirmation;


    @FindBy(name="email")
    public WebElement emailBtn;


    @FindBy(name = "password")
    public WebElement passwordBtn;

    @FindBy(xpath="//button[@type='submit']")
    public WebElement LoginBtn;


    @FindBy(xpath = "//a[@href='/admin/students']")
    public WebElement studentsBtn;

    @FindBy(xpath = "(//button)[6]")
    public WebElement threeDotBtn;

    @FindBy(xpath = "(//ul[@role='menu'])[2]/li[2]")
    public WebElement blockDropDown;

    @FindBy(xpath ="//button[.='Block']")
    public WebElement blockPopup;

    @FindBy(xpath = "//p[.='Student successfully blocked']")
    public WebElement blockedPopupMessage;

    @FindBy(xpath = "//p[.='Administrator']")
    public  WebElement administratorBtn;



    @FindBy(xpath = "//li[text()='Log out']")
    // @FindBy(xpath = "(//ul[@role='menu'])[7]/li")
    public WebElement logOutBtn;


    @FindBy(xpath = "//button[.='Log out']")
    public WebElement logOutExitBtn;

        //   @FindBy(xpath = "p[.='Account is blocked']")
//    public WebElement accountBlockedMessage;


}

