package studymatetests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import studymatepages.LoginPage;
import studymatepages.TeacherPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TeacherPageTest {
    LoginPage loginPage = new LoginPage();
    TeacherPage teacherPage = new TeacherPage();

    @Test(groups = {"regression"})

    public void verifyAddTeacherButton() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Assert.assertTrue(teacherPage.teacherOptionWindow.isDisplayed());
    }

    @Test(groups = {"regression"})
    public void addTeacherDropDownOptions() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        teacherPage.teacherOption.get(0).sendKeys("Kamala");
        teacherPage.teacherOption.get(1).sendKeys("Harris");
        teacherPage.teacherOption.get(2).sendKeys("12345678");
        teacherPage.teacherOption.get(3).sendKeys("kamala@gmail.com");
        teacherPage.teacherOption.get(4).sendKeys("QA");

    }

    @Test(groups = {"regression"})
    public void verifyTeacherAdded() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        //System.out.println(teacherPage.getTeacher());
        int beforeResult = teacherPage.getTeacher();
        Faker faker = new Faker();
        teacherPage.addTeacherButton.click();
        teacherPage.teacherOption.get(0).sendKeys(faker.name().firstName());
        teacherPage.teacherOption.get(1).sendKeys(faker.name().lastName());
        teacherPage.teacherOption.get(2).sendKeys("1234567891");
        teacherPage.teacherOption.get(3).sendKeys(faker.internet().emailAddress());
        teacherPage.teacherOption.get(4).sendKeys(faker.job().field());
        teacherPage.coursesDropdown.click();
        Random random = new Random();
        int index = random.nextInt(teacherPage.listOfCourses.size());
        Flow.wait(3000);
        teacherPage.listOfCourses.get(index).click();
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(teacherPage.addTeacherHeader).click().perform();
        Flow.wait(3000);
        teacherPage.submitButton.click();
        Flow.wait(2000);
        //System.out.println(teacherPage.getTeacher());
        int afterResult = teacherPage.getTeacher();
        Assert.assertEquals( beforeResult + 1, afterResult, "Teacher add functionality FAILED");
        

    }

    @Test(groups = {"regression"})
    public void verifyCancelAddButtons(){
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Flow.wait(3000);
        //teacherPage.cancelButton.click();
        Assert.assertTrue(teacherPage.cancelButton.isDisplayed());
        Flow.wait(2000);
        //verify cansl button's text
        //add button

    }


    @Test(groups = {"regression"})
    public void verifyCoursesDropdown(){
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        System.out.println(teacherPage.listOfTeacherCourses());
        teacherPage.addTeacherButton.click();
        int beforeResult = teacherPage.listOfTeacherCourses();
        Flow.wait(1000);
        teacherPage.coursesDropdown.click();
        int afterResult = teacherPage.listOfTeacherCourses();
       Assert.assertEquals( beforeResult, afterResult, "Teacher add functionality FAILED");




    }
//    @AfterMethod
//    public void cleanUp(){
//        Driver.quitBrowser();
//    }








}