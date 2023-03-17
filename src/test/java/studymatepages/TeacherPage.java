package studymatepages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
import utilities.Flow;

import java.util.List;
import java.util.Random;

public class TeacherPage {

    public TeacherPage() {

        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "(//a/li)[3]")
    public WebElement teacherButton;

    @FindBy(xpath = "//header/button")
    public WebElement addTeacherButton;

    @FindBy(xpath = "//div[@id='modal']")
    public WebElement teacherOptionWindow;


    @FindBy(xpath = "//div[@id='content']//input")
    public List<WebElement> teacherOption;

    @FindBy(xpath =" //div/div[@role='button']")
    public WebElement coursesDropdown;


    @FindBy(xpath = "//input[@type='checkbox']")

    public List<WebElement> courseCheckBox;


    @FindBy(xpath = "//p[.='Add teacher']")
    public WebElement addTeacherHeader;

    @FindBy(xpath = "(//form//button)[1]")
    public WebElement cancelButton;

    @FindBy(xpath = "//div/button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//p[.='pagination.show']/../p[2]")
    public WebElement totalResult;

    @FindBy(xpath = "(//div/ul)[7]/li")
    public List<WebElement> option2;


    public int getTeacher(){
        String totalResultStr = totalResult.getText();
        String totalNumberStr = totalResultStr.substring(totalResultStr.indexOf(" ")+1);
        int totalNumberInt = Integer.parseInt(totalNumberStr.trim());
        return totalNumberInt;
    }


















}


