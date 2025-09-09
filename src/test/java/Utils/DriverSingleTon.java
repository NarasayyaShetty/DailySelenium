package Utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleTon {

   private static WebDriver driver=null;

   private DriverSingleTon(){}

    public static WebDriver createDriver(String browserName){
       if(driver==null){
           switch(browserName){
               case "chrome":
                   driver=new ChromeDriver();
                   break;
               case "firefox":
                   driver=new FirefoxDriver();
                   break;
               default:
                   throw  new RuntimeException("Browser name is not matched");
           }
       }
        driver.manage().window().maximize();
        return driver;
    }




}
