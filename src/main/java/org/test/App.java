package org.test;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException, IOException {
        System.out.println( "Hello World!" );

        // WebDriver driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        WebDriver driver = new ChromeDriver(options);
        //open URL
        driver.get("http://3.88.143.127:8081");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        Thread.sleep(2000);
        //locate email id and password fields and click login
        driver.findElement(By.xpath("/html/body/div/header/div/nav/div/ul/li[4]/a")).click();
        driver.findElement(By.id("inputName")).sendKeys("Nehru");
        driver.findElement(By.id("inputNumber")).sendKeys("9898989898");
        driver.findElement(By.id("inputMail")).sendKeys("nehru@abc.com");
        driver.findElement(By.id("inputMessage")).sendKeys("Welcome to Insurance Demo Project");
        driver.findElement(By.id("my-button")).click();
        Thread.sleep(5000);

        //capture screenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("test-report.jpg");
        FileUtils.copyFile(srcFile,destFile);

        driver.quit();


    }
}

