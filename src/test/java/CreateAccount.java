import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.Random;

public class CreateAccount {

    private static final String CHAR_LIST = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int RANDOM_STRING_LENGTH = 6;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());


    public static void main(String[] args) throws InterruptedException {

       // Logger.getRootLogger().setLevel(Level.OFF);
        BasicConfigurator.configure();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hedgestonegroup.com");
        Log.info("hedgestonegroup site opened");
        WebElement openAccountButton = driver.findElement(By.xpath("//div[@class=\"btnContainer\"]//span[text()=\"Open an account\"]"));
        openAccountButton.click();
        Log.info("create account page opened");
        driver.findElement(By.name("FirstName")).clear();
        driver.findElement(By.name("FirstName")).sendKeys("test"+generateRandomString());
        Log.info("firstName is inserted");
        driver.findElement(By.name("LastName")).clear();
        driver.findElement(By.name("LastName")).sendKeys("testautoo");
        Log.info("secondName is inserted");
        driver.findElement(By.name("email")).clear();
        driver.findElement(By.name("email")).sendKeys(generateRandomString()+"@yopmail.com");
        Thread.sleep(10000);
        Log.info("email is inserted");
        driver.findElement(By.name("phone")).clear();
        driver.findElement(By.name("phone")).sendKeys("8004566322");
        Log.info("phone is inserted");
        new Select(driver.findElement(By.name("Year"))).selectByVisibleText("1981");
        Log.info("year is selected");
        new Select(driver.findElement(By.name("Month"))).selectByVisibleText("12 - December");
        Log.info("month is selected");
        Thread.sleep(2000);
        WebElement dayElement = driver.findElement(By.name("Day"));
        new Select(dayElement).selectByIndex(1);
        Log.info("day is selected");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("123456");
        Log.info("password is inserted");
        driver.findElement(By.name("ConfirmPassword")).clear();
        driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");
        Log.info("password is confirmed");
        driver.findElement(By.name("terms")).click();
        Log.info("terms is checked");
        driver.findElement(By.cssSelector("button.btn.submitBtn")).click();
        Log.info("button is ok, account is created");
        System.out.println("yep");
        Thread.sleep(20000);
       // Assert.assertEquals(actual, expected);

        driver.close();
        driver.quit();
        Log.info("browser closed");

    }

    /**
     * This method generates random string
     * @return
     */
    public static String generateRandomString(){

        StringBuffer randStr = new StringBuffer();
        for(int i=0; i<RANDOM_STRING_LENGTH; i++){
            int number = getRandomNumber();
            char ch = CHAR_LIST.charAt(number);
            randStr.append(ch);
        }
        return randStr.toString();
    }

    /**
     * This method generates random numbers
     * @return int
     */
    private static int getRandomNumber() {
        int randomInt = 0;
        Random randomGenerator = new Random();
        randomInt = randomGenerator.nextInt(CHAR_LIST.length());
        if (randomInt - 1 == -1) {
            return randomInt;
        } else {
            return randomInt - 1;
        }
    }
}


