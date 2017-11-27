package ChromeTest;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class FlipcartDemo {
	public static void main(String args[]) throws Exception 
	{
		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Info_Oskc\\Downloads\\Compressed\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String Actualtitle = driver.getTitle();
		System.out.println(Actualtitle);
		/*String Expecttitle = "";
		assert.assertEquals(Actualtitle, Expecttitle);
		if(Actualtitle.equalsIgnoreCase(Expecttitle)){
			System.out.println(Actualtitle);
		}*/
		
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.xpath("//SPAN[@class=''][text()='Electronics']"))).perform();
		Thread.sleep(2000);
		
		
		
		//click on mobiles
		driver.findElement(By.xpath("(//SPAN[text()='Mobiles'])[1]"));
		System.out.println("click mobile option");
		Thread.sleep(2000);
		
		
		//click samsung
		driver.findElement(By.xpath("(//SPAN[text()='Samsung'][text()='Samsung'])[1]")).click();
		System.out.println("click samsung phone");
		Thread.sleep(2000);
		
		//click view
		driver.findElement(By.xpath("//A[@class='_2AkmmA _1eFTEo']/self::A")).click();
		System.out.println("click on view option");
		Thread.sleep(1000);
		
		//price low to high
		driver.findElement(By.xpath("//LI[@class='_2Ylh8t'][text()='Price -- Low to High']")).click();
		System.out.println("click low to high price");
		Thread.sleep(2000);
		
		Select sel = new Select(driver.findElement(By.xpath("(//SELECT[@class='a_eCSK'])[1]")));
		sel.selectByIndex(1);
		Thread.sleep(2000);
		List<WebElement> li = sel.getOptions();
		for(WebElement str:li){
			System.out.println(str.getText());
		}
		
		System.out.println(sel);
		
		Select sel1 = new Select(driver.findElement(By.xpath("(//SELECT[@class='a_eCSK'])[2]")));
		sel1.selectByIndex(5);
		Thread.sleep(2000);
		System.out.println(sel1);
		
		//add a phone in cart
		driver.findElement(By.xpath("//DIV[@class='_3wU53n'][text()='Samsung B351']")).click();
		System.out.println("choose one phone");
		Thread.sleep(2000);
		
		/*driver.findElement(By.xpath("//BUTTON[@class='_2AkmmA _2Npkh4 _2MWPVK']")).click();
		System.out.println("added to cart");
		Thread.sleep(2000);*/
		
		//login flipcart AC
        driver.findElement(By.xpath("//A[@class='_2k0gmP'][text()='Log In']")).click();
        driver.findElement(By.xpath("(//INPUT[@type='text'])[3]")).sendKeys("9439935814");
        driver.findElement(By.xpath("//INPUT[@type='password']")).sendKeys("suchi@123");
        driver.findElement(By.xpath("//BUTTON[@class='_2AkmmA _1LctnI _7UHT_c']")).click();
        Thread.sleep(2000);
        System.out.println("login sussfully");
        
        // check logo is enable or not (or present or not)
        
        boolean isenable = driver.findElement(By.xpath("//IMG[@width='149']")).isEnabled();
        if(isenable){
        	System.out.println("logo of flipcart is enabled");
        }else{
        	System.out.println("not enabled");
        }
        
        //check displayed or not or(if present it visible or not check)
        boolean isdisplay= driver.findElement(By.xpath("//IMG[@width='149']")).isDisplayed();
        if(isdisplay){
        	System.out.println("logo of flipcart is display");
        }else{
        	System.out.println("not visible");
        }
        // exist or not
        try{
        	driver.findElement(By.xpath("//IMG[@width='149']"));
        }
        catch(Exception e){
        	System.out.println("element not exist");
        }
        
        
       /*Retrive excel file
        try{
        FileInputStream fis = new FileInputStream("D:\\ChromeExcelData_Flipcart.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sh = wb.getSheetAt(0);
        System.out.println(sh.getRow(0).getCell(0).getStringCellValue());
        System.out.println(sh.getRow(0).getCell(1).getStringCellValue());
        System.out.println(sh.getRow(1).getCell(0).getStringCellValue());
        System.out.println(sh.getRow(1).getCell(1).getStringCellValue());
        }
        catch(Exception e){
        	System.out.println("check data in excel");
        }*/
        
		
        
		
		
		
		
		
		driver.close();	
	}
	

}
