package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
}
