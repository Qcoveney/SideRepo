package SeleniumTests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;

public class TestDNDInsert {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\cdbbg\\workspace4830\\workspace-thisisfine3\\ThisIsFineProject\\lib\\win\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testDNDInsert() throws Exception {
    driver.get("http://ec2-18-117-132-161.us-east-2.compute.amazonaws.com:8080/ThisIsFineProject/search.html");
    driver.manage().window().maximize();
    Thread.sleep(1000);
    driver.findElement(By.linkText("Create Character")).click();
    Thread.sleep(400);
    driver.findElement(By.name("name")).click();
    Thread.sleep(400);
    driver.findElement(By.name("name")).clear();
    Thread.sleep(400);
    driver.findElement(By.name("name")).sendKeys("Selene");
    Thread.sleep(400);
    driver.findElement(By.name("race")).clear();
    driver.findElement(By.name("race")).sendKeys("Elf");
    Thread.sleep(400);
    driver.findElement(By.name("characterClass")).clear();
    driver.findElement(By.name("characterClass")).sendKeys("Cleric");
    Thread.sleep(400);
    driver.findElement(By.name("strength")).clear();
    driver.findElement(By.name("strength")).sendKeys("6");
    Thread.sleep(400);
    driver.findElement(By.name("dexterity")).clear();
    driver.findElement(By.name("dexterity")).sendKeys("7");
    Thread.sleep(400);
    driver.findElement(By.name("constitution")).clear();
    driver.findElement(By.name("constitution")).sendKeys("8");
    Thread.sleep(400);
    driver.findElement(By.name("intelligence")).clear();
    driver.findElement(By.name("intelligence")).sendKeys("9");
    Thread.sleep(400);
    driver.findElement(By.name("wisdom")).clear();
    driver.findElement(By.name("wisdom")).sendKeys("10");
    Thread.sleep(400);
    driver.findElement(By.name("charisma")).clear();
    driver.findElement(By.name("charisma")).sendKeys("11");
    Thread.sleep(400);
    driver.findElement(By.name("equipment")).clear();
    driver.findElement(By.name("equipment")).sendKeys("Bow");
    Thread.sleep(400);
    driver.findElement(By.name("background")).clear();
    driver.findElement(By.name("background")).sendKeys("Likes to test");
    Thread.sleep(400);
    driver.findElement(By.xpath("//button[@value='Submit']")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Character Created!'])[1]/following::section[1]")).click();
    driver.findElement(By.linkText("DnD Builder")).click();
    Thread.sleep(1000);
    driver.findElement(By.name("keyword")).click();
    driver.findElement(By.name("keyword")).clear();
    Thread.sleep(1000);
    driver.findElement(By.name("keyword")).sendKeys("Selene");
    Thread.sleep(1000);
    driver.findElement(By.name("keyword")).sendKeys(Keys.ENTER);
    Thread.sleep(1000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Search Results'])[1]/following::section[1]")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}

