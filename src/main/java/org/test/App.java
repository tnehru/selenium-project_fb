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
        driver.get("https://facebook.com");
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500));
        Thread.sleep(2000);
        //locate email id and password fields and click login
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("prem@pavan.com");
        driver.findElement(By.xpath("//*[@id=\"pass\"]")).sendKeys("Pavan@123");
        driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[2]/button")).click();
        Thread.sleep(5000);

        //capture screenshot
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
        File destFile = new File("test-report.jpg");
        FileUtils.copyFile(srcFile,destFile);

        driver.quit();


    }
}

