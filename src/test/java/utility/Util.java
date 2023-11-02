package utility;

import com.github.javafaker.Faker;
import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Util {


public  static  void screenshotAfterTestPass(WebDriver driver,String screenshotName)
{
var camera=(TakesScreenshot )driver;

    File recording=camera.getScreenshotAs(OutputType.FILE);
   try {
       Files.move(recording, new File("F:\\IdeaProjects\\AutomatedTestingFramework\\recording"+screenshotName+".png"));
   }catch (IOException e){
       e.printStackTrace();
   }




































}

























}
