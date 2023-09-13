// Generated by Selenium IDE

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.junit.Assert.assertThat;

public class HomepageTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
    System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
    driver = new ChromeDriver();
    // System.setProperty("webdriver.chrome.driver","Drivers/msedgedriver.exe");
    //WebDriver driver = new ChromeDriver();
    // WebDriver driver = new EdgeDriver();
    
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }


  @After
  public void tearDown() {
    driver.quit();
  }
  public String waitForWindow(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    Set<String> whNow = driver.getWindowHandles();
    Set<String> whThen = (Set<String>) vars.get("window_handles");
    if (whNow.size() > whThen.size()) {
      whNow.removeAll(whThen);
    }
    return whNow.iterator().next();
  }

  @Test
  //בדיקה שנמצאים בעמוד הבית
  //Check those on the home page
  public void validationfoundonthehomepage() {
    driver.get("https://www.agora.co.il/");
    driver.manage().window().setSize(new Dimension(1600, 860));
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dialog_overlayTd > div > div.dialog_closeButton")));
      driver.findElement(By.cssSelector("#dialog_overlayTd > div > div.dialog_closeButton")).click();
    }
    // assert on a button that is only on the home page
    assertThat(driver.findElement(By.cssSelector("li:nth-child(2) > span:nth-child(1)")).getText(), is("▼ אודות פרויקט אגורה"));
    driver.close();
  }
  @Test
  // בדיקה שכפתור "פרוקיט אגורה" מחזיר לעמוד הבית
  //Testing that the "Agora project" button returns the home page
  public void pennybuttonreturnstohomepage() {
    driver.get("https://www.agora.co.il/categoryContent.asp?category=5");
    driver.manage().window().setSize(new Dimension(1600, 860));
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dialog_overlayTd > div > div.dialog_closeButton")));
      driver.findElement(By.cssSelector("#dialog_overlayTd > div > div.dialog_closeButton")).click();
    }
    driver.findElement(By.id("logoImage")).click();
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("li:nth-child(2) > span:nth-child(1)")));
    }
    {
      List<WebElement> elements = driver.findElements(By.id("logoImage"));
      assert(elements.size() > 0);
    }
    // Comparison between the url of the home page and the url of the current page
    {
      String initialUrl = "https://www.agora.co.il/"; // this is the url of the home page
      driver.get(initialUrl);
      driver.getCurrentUrl();
      if (initialUrl.equals(driver.getCurrentUrl()))
      {
        System.out.println("The Url: " + driver.getCurrentUrl() + " and the Url: " + initialUrl + " are the same");
      }
      else
        System.out.println("The Url: "+driver.getCurrentUrl() + "and the Url: " + initialUrl+"are not equal");
    }
    driver.close();
  }
  @Test
  //בדיקה שכפתור "עזרה" עובד
  //Checking that the "Help" button works
  public void helpbuttonworks() {
    driver.get("https://www.agora.co.il/toGet.asp?dealType=1&iseek=%D7%9E%D7%A7%D7%A8%D7%A8");
    driver.manage().window().setSize(new Dimension(1600, 860));
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dialog_overlayTd > div > div.dialog_closeButton")));
      driver.findElement(By.cssSelector("#dialog_overlayTd > div > div.dialog_closeButton")).click();
    }
    vars.put("window_handles", driver.getWindowHandles());
    driver.findElement(By.linkText("עזרה")).click();
    vars.put("win1429", waitForWindow(2000));
    driver.switchTo().window(vars.get("win1429").toString());
    assertThat(driver.findElement(By.cssSelector("h1")).getText(), is("מדריך לשימוש באתר"));
    driver.close();
  }
  @Test
  // בדיקה שכפתור "צור קשר" עובד
  //Checking that the "Contact" button works
  //During this test, an advertisement pops up that needs to be closed manually for the code to continue running
  public void contactbuttonworks() {
    driver.get("https://www.agora.co.il/");
    driver.manage().window().setSize(new Dimension(1600, 860));
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dialog_overlayTd > div > div.dialog_closeButton")));
      driver.findElement(By.cssSelector("#dialog_overlayTd > div > div.dialog_closeButton")).click();
    }
    /*
    ChromeOptions options = new ChromeOptions();
    options.addExtensions(new File("drivers/extension_3_19_0_0.crx"));
    driver = new ChromeDriver(options);

     */
    int delayBetweenActions = 5000; // Delay in milliseconds
    try {
      Thread.sleep(delayBetweenActions);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("צור קשר")));
    }

    driver.findElement(By.linkText("צור קשר")).click();
    try {
      Thread.sleep(delayBetweenActions);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.id("pinkPageTitle")));
    }

    //driver.switchTo().frame(1);
    assertThat(driver.findElement(By.id("pinkPageTitle")).getText(), is("צור קשר"));
    driver.close();
  }
  @Test
  // בדיקה שכאשר נמצאים באתר ללא רישום, כתוב בצד ימין למעלה "שלום אורח/ת" ולא שם מסוים
  //Checking that when you are on the site without registration, it says "Hello Guest" on the top right and not a specific name
  public void validationHelloguest() {
    driver.get("https://www.agora.co.il/");
    driver.manage().window().setSize(new Dimension(1600, 860));
    {
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
      wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#dialog_overlayTd > div > div.dialog_closeButton")));
      driver.findElement(By.cssSelector("#dialog_overlayTd > div > div.dialog_closeButton")).click();
    }
    assertThat(driver.findElement(By.cssSelector("#userBox > span")).getText(), is("שלום אורח/ת"));
    driver.close();
  }
}
