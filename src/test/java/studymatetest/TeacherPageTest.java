package studymatetest;

import com.github.javafaker.Faker;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import tests.studymatepages.LoginPage;
import tests.studymatepages.TeacherPage;
import utilities.Config;
import utilities.Driver;
import utilities.Flow;

import java.util.Random;

public class TeacherPageTest {
    LoginPage loginPage = new LoginPage();
    TeacherPage teacherPage = new TeacherPage();

    @Test(priority = 1,groups = {"regression"})

    public void verifyAddTeacherButton() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Assert.assertTrue(teacherPage.addTeacherButton.isDisplayed(), "Add teacher button is not displayed");
        //System.out.println(teacherPage.addTeacherButton.getText());
        String actualMessage=teacherPage.addTeacherButton.getText();
        Assert.assertTrue(actualMessage.contains("Add teacher"));

    }

    @Test(priority = 2,groups = {"regression"})
    public void verifyTeacherWindow() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();
        Faker faker = new Faker();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        //System.out.println(teacherPage.teacherWindow.getText());
        Assert.assertTrue(teacherPage.teacherWindow.isDisplayed());
    }

    @Test(priority = 3,groups = {"regression"})
    public void verifyTeacherAdded() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();

        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        System.out.println(teacherPage.getTeacher());
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
        Flow.wait(2000);
        teacherPage.listOfCourses.get(index).click();
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(teacherPage.teacherWindow).click().perform();
        Flow.wait(2000);
        teacherPage.submitButton.click();
        Flow.wait(1000);
        System.out.println(teacherPage.getTeacher());
        int afterResult = teacherPage.getTeacher();
        Assert.assertEquals(beforeResult + 1, afterResult, "Teacher add functionality FAILED");

    }

    @Test(priority = 4,groups = {"regression"})
    public void verifyCancelButtons() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Flow.wait(2000);
        Assert.assertTrue(teacherPage.cancelButton.isDisplayed());
        boolean isElementEnabled = teacherPage.cancelButton.isEnabled();
        Assert.assertTrue(isElementEnabled);
        teacherPage.cancelButton.click();
        Flow.wait(1000);
    }


    @Test(priority = 5,groups = {"regression"})
    public void verifySubmitButton() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Flow.wait(2000);
        Assert.assertTrue(teacherPage.submitButton.isDisplayed());
        boolean isElementEnabled = teacherPage.submitButton.isEnabled();
        Assert.assertFalse(isElementEnabled, "The element is not be enabled");
    }

    @Test(priority = 6,groups = {"regression"})
    public void verifyEmptyFirstNameField() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Flow.wait(2000);
        Faker faker = new Faker();
        teacherPage.teacherOption.get(0).click();
        teacherPage.teacherOption.get(0);
        teacherPage.teacherOption.get(1).sendKeys(faker.name().lastName());
        teacherPage.teacherOption.get(2).sendKeys("1234567890");
        teacherPage.teacherOption.get(3).sendKeys(faker.internet().emailAddress());
        teacherPage.teacherOption.get(4).sendKeys(faker.job().field());
        teacherPage.coursesDropdown.click();
        Random random = new Random();
        int index = random.nextInt(teacherPage.listOfCourses.size());
        Flow.wait(2000);
        teacherPage.listOfCourses.get(index).click();
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(teacherPage.teacherWindow).click().perform();
        Flow.wait(1000);
        String expectedMessage = "First name";
        String errorMessage = teacherPage.firstName.getText();
        // System.out.println(teacherPage.firstName.getText());
        Assert.assertEquals(expectedMessage, errorMessage);
        Assert.assertFalse(teacherPage.submitButton.isEnabled());
    }


    @Test(priority = 7,groups = {"regression"})
    public void verifyEmptyLastnameField() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Flow.wait(2000);
        Faker faker = new Faker();
        teacherPage.teacherOption.get(0).click();
        teacherPage.teacherOption.get(0).sendKeys(faker.name().firstName());
        teacherPage.teacherOption.get(1).click();
        teacherPage.teacherOption.get(2).sendKeys("1234567890");
        teacherPage.teacherOption.get(3).sendKeys(faker.internet().emailAddress());
        teacherPage.teacherOption.get(4).sendKeys(faker.job().field());
        teacherPage.coursesDropdown.click();
        Random random = new Random();
        int index = random.nextInt(teacherPage.listOfCourses.size());
        Flow.wait(2000);
        teacherPage.listOfCourses.get(index).click();
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(teacherPage.teacherWindow).click().perform();
        Flow.wait(1000);
        String expectedMessage = "Last name";
        String actualMessage = teacherPage.lastName.getText();
        // System.out.println(teacherPage.lastName.getText());
        Assert.assertEquals(expectedMessage, actualMessage);
        Assert.assertFalse(teacherPage.submitButton.isEnabled());

    }

    @Test(priority = 8,groups = {"regression"})
    public void verifyEmptyPhoneField() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Flow.wait(2000);
        Faker faker = new Faker();
        teacherPage.teacherOption.get(0).click();
        teacherPage.teacherOption.get(0).sendKeys(faker.name().firstName());
        teacherPage.teacherOption.get(1).sendKeys(faker.name().lastName());
        teacherPage.teacherOption.get(2).click();
        teacherPage.teacherOption.get(3).sendKeys(faker.internet().emailAddress());
        teacherPage.teacherOption.get(4).sendKeys(faker.job().field());
        teacherPage.coursesDropdown.click();
        Random random = new Random();
        int index = random.nextInt(teacherPage.listOfCourses.size());
        Flow.wait(2000);
        teacherPage.listOfCourses.get(index).click();
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(teacherPage.teacherWindow).click().perform();
        Flow.wait(1000);
        String expectedMessage = "Phone number";
        String actualMessage = teacherPage.phone.getText();
        Assert.assertEquals(expectedMessage, actualMessage);
        Assert.assertFalse(teacherPage.submitButton.isEnabled());
    }

    @Test(priority = 9,groups = {"regression"})
    public void verifyEmptyEmailField() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Flow.wait(2000);
        Faker faker = new Faker();
        teacherPage.teacherOption.get(0).click();
        teacherPage.teacherOption.get(0).sendKeys(faker.name().firstName());
        teacherPage.teacherOption.get(1).sendKeys(faker.name().lastName());
        teacherPage.teacherOption.get(2).sendKeys("1234567890");
        teacherPage.teacherOption.get(3).click();
        teacherPage.teacherOption.get(4).sendKeys(faker.job().field());
        teacherPage.coursesDropdown.click();
        Random random = new Random();
        int index = random.nextInt(teacherPage.listOfCourses.size());
        Flow.wait(2000);
        teacherPage.listOfCourses.get(index).click();
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(teacherPage.teacherWindow).click().perform();
        Flow.wait(1000);
        String expectedMessage = "Email";
        String actual = teacherPage.email.getText();
        // System.out.println(teacherPage.email.getText());
        Assert.assertEquals(expectedMessage, actual);
        Assert.assertFalse(teacherPage.submitButton.isEnabled());
    }


    @Test(priority = 10,groups = {"regression"})
    public void verifyEmptySpecializationField() {
        LoginPage loginPage = new LoginPage();
        TeacherPage teacherPage = new TeacherPage();
        Driver.getDriver().get(Config.getValue("studyMateURL"));
        loginPage.login(Config.getValue("studyMateLoginEmail"), Config.getValue("studyMateLoginPassword"));
        teacherPage.teacherButton.click();
        teacherPage.addTeacherButton.click();
        Flow.wait(2000);
        Faker faker = new Faker();
        teacherPage.teacherOption.get(0).click();
        teacherPage.teacherOption.get(0).sendKeys(faker.name().firstName());
        teacherPage.teacherOption.get(1).sendKeys(faker.name().lastName());
        teacherPage.teacherOption.get(2).sendKeys("1234567890");
        teacherPage.teacherOption.get(3).sendKeys(faker.internet().emailAddress());
        teacherPage.teacherOption.get(4).click();
        teacherPage.coursesDropdown.click();
        Random random = new Random();
        int index = random.nextInt(teacherPage.listOfCourses.size());
        Flow.wait(2000);
        teacherPage.listOfCourses.get(index).click();
        Actions action = new Actions(Driver.getDriver());
        action.moveToElement(teacherPage.teacherWindow).click().perform();
        Flow.wait(1000);
        String expectedMessage = "Specialization";
        String actualMessage = teacherPage.specialization.getText();
        //System.out.println(teacherPage.specialization.getText());
        Assert.assertEquals(expectedMessage, actualMessage);
        Assert.assertFalse(teacherPage.submitButton.isEnabled());
    }

    @AfterMethod
    public void cleanUp () {
        Driver.quitBrowser();
    }

}
