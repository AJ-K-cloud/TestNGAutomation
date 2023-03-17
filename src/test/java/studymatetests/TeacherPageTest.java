package studymatetests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
        teacherPage.teacherOption.get(2).sendKeys("12345678");
        teacherPage.teacherOption.get(3).sendKeys(faker.internet().emailAddress());
        teacherPage.teacherOption.get(4).sendKeys(faker.job().field());
        teacherPage.coursesDropdown.click();
        Random random = new Random();
        int index = random.nextInt(teacherPage.courseCheckBox.size());
        Flow.wait(3000);
        teacherPage.courseCheckBox.get(index).click();
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
    public void verifyCancelButtonFunction(){
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Flow.wait(3000);
        //teacherPage.cancelButton.click();
        Assert.assertTrue(teacherPage.cancelButton.isEnabled());
        Flow.wait(2000);

    }


    @Test
    public void verifyCoursesDropdown(){
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Flow.wait(1000);
        teacherPage.coursesDropdown.click();
        String str = null;
        //System.out.println(teacherPage.option2.size());
        for (WebElement option1: teacherPage.option2) {
            str = option1.getText();
           // System.out.println(str.length());
            //System.out.println(str);
        }

        List<String> option3 = new ArrayList<>();
        option3.add("Éomer");
        option3.add("Photography for Beginners");
        option3.add("PSY II");
        option3.add("Expelliarmus");
        option3.add("Philosophy");
        option3.add("Ravenclaw");
        option3.add("!@#$%^&*()(*&^%$#@");
        option3.add("lkjhgj");
        option3.add("Just because you have the emotional range of a teaspoon doesn’t mean we all have.");
        option3.add("ferfrfrf");
        option3.add("fwf");
        option3.add("fwrwrff");
        option3.add("fwfrwfrw");
        option3.add("wfwfewf");
        option3.add("Lucy Fer");
        option3.add("Gryffindor");
        option3.add("Reparo");
        option3.add("To the well-organized mind, death is but the next great adventure.");
        option3.add("Crucio");
        option3.add("d");

        Assert.assertEquals(20, teacherPage.option2.size(), "List of courses don't match by size");
        Assert.assertTrue(option3.contains(str));
    }






}