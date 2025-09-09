package Utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

public class SeleniumUtils {


    public static void elementClick(WebDriver driver, WebElement element){
        try{
            WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element)).click();

        }catch(Exception e){
            System.out.println("Exception is occured during the click");
            e.printStackTrace();
        }
    }

    public static void enterValue(WebElement element, String value){
        try{
            element.clear();
            element.sendKeys(value);

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception occured while passing the value");
        }
    }

    public static void takeScreenshot(WebDriver driver){
        try{
            Calendar c=Calendar.getInstance();
            SimpleDateFormat sdf=new SimpleDateFormat("ddMMYYYY");
            Date d=c.getTime();
            String currentDate=sdf.format(d);
            String path=System.getProperty("user.dir")+ File.separator+"Results"+File.separator+"Screenshots"+File.separator+currentDate;
            File file=new File(path);
            if(!file.exists()){
                file.mkdirs();
            }

            TakesScreenshot ts=(TakesScreenshot)driver;
            File src=ts.getScreenshotAs(OutputType.FILE);
            System.out.println("Screenshot is captured");

            String fileName=String.format("name_%s.png",UUID.randomUUID().toString());
            File desFile=new File(path+File.separator+fileName);
            FileUtils.copyFile(src,desFile);

        }catch(Exception e){
            e.printStackTrace();
            System.out.println("Exception is occured during taking the screenshot");
        }
    }
}
