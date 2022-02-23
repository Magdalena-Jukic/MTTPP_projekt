package com.example.Tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class Filter {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "C://drivers/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testFilter() throws Exception {
    driver.get("http://demowebshop.tricentis.com/");
    driver.findElement(By.linkText("Log in")).click();
    Thread.sleep(500);
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("marko123@gmail.com");
    Thread.sleep(500);
    driver.findElement(By.id("Password")).click();
    driver.findElement(By.id("Password")).clear();
    driver.findElement(By.id("Password")).sendKeys("markomarko");
    Thread.sleep(500);
    driver.findElement(By.xpath("//input[@value='Log in']")).click();
    Thread.sleep(500);
    driver.findElement(By.linkText("Computers")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("//img[@alt='Picture for category Notebooks']")).click();
    Thread.sleep(500);
    driver.findElement(By.id("products-orderby")).click();
    Thread.sleep(500);
    new Select(driver.findElement(By.id("products-orderby"))).selectByVisibleText("Name: A to Z");
    driver.findElement(By.id("products-pagesize")).click();
    Thread.sleep(500);
    new Select(driver.findElement(By.id("products-pagesize"))).selectByVisibleText("12");
    Thread.sleep(500);
    driver.findElement(By.linkText("Apparel & Shoes")).click();
    Thread.sleep(500);
    driver.findElement(By.id("products-pagesize")).click();
    Thread.sleep(500);
    new Select(driver.findElement(By.id("products-pagesize"))).selectByVisibleText("12");
    driver.findElement(By.id("products-pagesize")).click();
    Thread.sleep(500);
    new Select(driver.findElement(By.id("products-pagesize"))).selectByVisibleText("4");
    driver.findElement(By.id("products-viewmode")).click();
    Thread.sleep(500);
    new Select(driver.findElement(By.id("products-viewmode"))).selectByVisibleText("List");
    driver.findElement(By.xpath("//div[2]/div/div[2]/div[3]/div[2]/input")).click();
    Thread.sleep(500);
    driver.findElement(By.xpath("//ul[@id='color-squares-11']/li[2]/label/span/span")).click();
    Thread.sleep(500);
    driver.findElement(By.id("product_attribute_28_7_10")).click();
    Thread.sleep(500);
    new Select(driver.findElement(By.id("product_attribute_28_7_10"))).selectByVisibleText("10");
    driver.findElement(By.id("addtocart_28_EnteredQuantity")).click();
    Thread.sleep(500);
    driver.findElement(By.id("addtocart_28_EnteredQuantity")).clear();
    driver.findElement(By.id("addtocart_28_EnteredQuantity")).sendKeys("2");
    driver.findElement(By.id("add-to-cart-button-28")).click();
    Thread.sleep(5000);
  }

  @AfterClass(alwaysRun = true)
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
