package utility;

import com.github.javafaker.Faker;
import com.google.common.io.Files;
import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

public class Util {

    public  static Faker faker=new Faker();

    public  static String generateFakeUserName()
    {

        return faker.name().username();
    }


    public  static String generateFakePassword()
    {

        return faker.internet().password();
    }

    public  static String generateFakeEmail()
    {

        return faker.internet().emailAddress();
    }

    public static String generateFakeFirstName() {
        return faker.name().firstName();
    }

    public static String generateFakeLastName() {
        return faker.name().lastName();
    }

    public static String generateFakeFullName() {
        return faker.name().fullName();
    }
    public static String generateFakePhoneNumber() {
        return faker.phoneNumber().phoneNumber();
    }
    public static String generateFakeAddress() {
        return faker.address().fullAddress();
    }


    public static void screenshotAfterTest_Pass(WebDriver driver, String screenshotName) throws IOException {

        var camera = (TakesScreenshot) driver;

        File recording = camera.getScreenshotAs(OutputType.FILE);
        try {
            Files.move(recording, new File("F:\\IdeaProjects\\AutomatedTestingFramework\\recording\\" + screenshotName + ".png"));
            Allure.addAttachment("Screenshot", new ByteArrayInputStream(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES)));

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}





























