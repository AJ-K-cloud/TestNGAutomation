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

    @FindBy(xpath = " //div/div[@role='button']")
    public WebElement coursesDropdown;

    @FindBy(xpath = "//p[.='Add teacher']")
    public WebElement teacherWindow;

    @FindBy(xpath = "(//form//button)[1]")
    public WebElement cancelButton;

    @FindBy(xpath = "//div/button[@type='submit']")
    public WebElement submitButton;
    @FindBy(xpath = "(//form//button)[2]")
    public WebElement addButton;


    @FindBy(xpath = "//p[.='pagination.show']/../p[2]")
    public WebElement totalResult;

    @FindBy(xpath = "//div/*[.='First name']")
    public WebElement firstName;

    @FindBy(xpath = "//div/*[.='Last name']")
    public WebElement lastName;

    @FindBy(xpath = "//div/*[.='Phone number']")
    public WebElement phone;

    @FindBy(xpath = "//div/*[.='Email']")
    public WebElement email;

    @FindBy(xpath = "//div/*[.='Specialization']")
    public WebElement specialization;


    @FindBy(xpath = "//ul[@role='listbox']/li")
    public List<WebElement> listOfCourses;


    public int getTeacher() {
        String totalResultStr = totalResult.getText();
        String totalNumberStr = totalResultStr.substring(totalResultStr.indexOf(" ") + 1);
        int totalNumberInt = Integer.parseInt(totalNumberStr.trim());
        return totalNumberInt;
    }




















}


