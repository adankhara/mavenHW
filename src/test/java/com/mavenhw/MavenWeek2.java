package com.mavenhw;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Currency;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MavenWeek2
{
    private WebDriver driver;

    private final static String expectedRegisterMessage = "Your registration completed";
    private final static String expectedEmailSentMessage = "Your message has been sent.";
    private final static String expectedEmailNotSentMessage = "Only registered customers can use email a friend feature";


    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        //driver.manage().window().fullscreen();
        driver.get("https://demo.nopcommerce.com/");
    }

//    @AfterMethod
//    public void TearDown()
//    {
//        driver.quit();
//    }


    //to click on element
    public void clickElement(By by)
    {
        driver.findElement(by).click();
    }
    // to enter text
    public void enterText(By by,String text)
    {
        driver.findElement(by).sendKeys(text);
    }
    // select from visible text
    public void selectByVisibleText(By by, String text)
    {
        new Select(driver.findElement(by)).selectByVisibleText(text);
    }
    //Select from index
    public void selectByIndex(By by, int number)
    {
        new Select(driver.findElement(by)).selectByIndex(number);
    }
    //Select from value
    public void selectByValue(By by, String text)
    {
        new Select(driver.findElement(by)).selectByValue(text);
    }
    //To get text
    public String getText(By by)
    {
        driver.findElement(by).isDisplayed();
        return driver.findElement(by).getText();
    }
    //To generate timestamp
    public String timeStamp()
    {
        DateFormat dateFormat = new SimpleDateFormat("MMddyyyyHHmmss");
        Date date = new Date();
        return dateFormat.format(date);
    }
    //wait for element to invisible
//    public void waitAndClick(By by,int time)
//    {
//        WebDriverWait wait = new WebDriverWait(driver,time);
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(by)));
//       driver.findElement(by).click();
//     }


    @Test
    public void userShouldBeAbleToRegisterSuccessfully()
    {
//   1.	Click on Register button.
        clickElement(By.linkText("Register"));
//   2.	Select gender.
        clickElement(By.id("gender-male"));
//   3.	Enter your first name in First Name field.
        enterText(By.id("FirstName"),"Rajesh");
//   4.	Enter your last name in Last Name field
        enterText(By.id("LastName"),"Parekh");
//   5.	Select your date of birth.
        selectByIndex(By.xpath("//select[@name='DateOfBirthDay']\n"),20);
        selectByVisibleText(By.xpath("//select[@name='DateOfBirthMonth']\n"),"May");
        selectByValue(By.xpath("//select[@name='DateOfBirthYear']\n"),"1980");
//   6.	Enter your email address in Email field.
        enterText(By.id("Email"),"rajeshparekh"+timeStamp()+"@yahoo.com");
//   7.	Enter your company name.
        enterText(By.id("Company"),"Parekh Ltd");
//   8.	Select/deselect Newsletter option.
        clickElement(By.id("Newsletter"));
//   9.	Enter password in Password field.
        enterText(By.id("Password"),"rajesh123");
//   10.	Enter password in Confirm Password field.
        enterText(By.id("ConfirmPassword"),"rajesh123");
//   11.	Click on Register button.
        clickElement(By.id("register-button"));
//   12.	“Your registration successful” message should be displayed.
        String actualRegisterMessage = getText(By.xpath("//div[@class='result']"));
        Assert.assertEquals("Test case registration scenario failed",expectedRegisterMessage,actualRegisterMessage);
//   13. Click on log out button.
        clickElement(By.linkText("Log out"));
    }

    @Test
    public void registeredUserShouldBeAbleToSendAnEmailToFriend()
    {
//   1.	Click on login button.
        clickElement(By.linkText("Log in"));
//   2.	Enter your registered email Id in email field.
        enterText(By.id("Email"),"rajesh.parekh123@gmail.com");
//   3.	Enter your password in password field.
        enterText(By.id("Password"),"rajesh9999");
//   4.	Click on Login button.
        clickElement(By.xpath("//input[@value='Log in']"));
//   5.	Click on first product(Build your computer).
        clickElement(By.linkText("Build your own computer"));
//   6.	Click on Email a friend.
        clickElement(By.xpath("//input[contains(@onclick,'/productemailafriend/1')]\n"));
//   7.	Enter your friend’s email in Friend’s Email field.
        enterText(By.id("FriendEmail"),"test123@yahoo.com");
//   8.	Enter personal message in personal message field.
        enterText(By.id("PersonalMessage"),"Look at this product.");
//   9.	Click on send email button.
        clickElement(By.xpath("//input[@name='send-email']"));
//   10.“Your message has been sent” message should be displayed.
        String actualEmailSentMessage = getText(By.xpath("//div[@class='result']"));
        Assert.assertEquals("Test case email a friend scenario failed",expectedEmailSentMessage,actualEmailSentMessage);
    }

    @Test
    public void unRegiseredUserShouldNotBeAbleToSendAnEmailToFriend()
    {
//   1.	Click on first product(Build your computer).
        clickElement(By.linkText("Build your own computer"));
//   2.	Click on Email a friend.
        clickElement(By.xpath("//input[contains(@onclick,'/productemailafriend/1')]\n"));
//   3.	Enter your friend’s email in Friend’s Email field.
        enterText(By.id("FriendEmail"),"test123@yahoo.com");
//   4. Enter email in Your email field.
        enterText(By.xpath("//input[@id='YourEmailAddress']\n"),"test4444@test.com");
//   5.	Enter personal message in personal message field.
        enterText(By.id("PersonalMessage"),"Look at this product.");
//   6.	Click on send email button.
        clickElement(By.xpath("//input[@name='send-email']"));
//   7.	“Only registered customers can use email a friend feature” message should be displayed.
        String actualEmailNotSentMessage = getText(By.xpath("//li[contains(.,'Only registered customers can use email a friend feature')]\n"));
        Assert.assertEquals("Test case email a friend scenario failed",expectedEmailNotSentMessage,actualEmailNotSentMessage);
    }

    @Test
    public void userShouldBeAbleToSortByPriceHighToLow()
    {
//   1. Click on computer
        clickElement(By.linkText("Computers"));
//   2. Click on Notebooks
        clickElement(By.linkText("Notebooks"));
//   3. Select Price-High to low in sort by field
        selectByVisibleText(By.id("products-orderby"),"Price: High to Low");
//   4. Products should be sorted with price in descending order
        List<WebElement> allProducts = driver.findElements(By.xpath("//span[@class='price actual-price']"));
        float first =  getPrice(allProducts.get(0));
        int lastIndex = allProducts.size()-1;
        float last = getPrice(allProducts.get(lastIndex));

        //Assert.assertEquals(true, first < last);

        Assert.assertTrue("Test case price sort by high to low is failed", first > last);
    }

    private float getPrice(WebElement element)
    {
        String text = element.getText();
        String withoutSign = text.substring(1);
        String withoutComma = withoutSign.replace(",", "");
        Float value = Float.valueOf(withoutComma);
        return value;
    }

    @Test
    public void userShouldBeAbleToPurchaseProducts()
    {

    }
}
