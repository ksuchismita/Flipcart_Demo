package ChromeTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipcartLogin {

	public void TC_Login() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Info_Oskc\\Downloads\\Compressed\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.findElement(
				By.xpath("//A[@class='_2k0gmP'][text()='Log In']/self::A"))
				.click();
		driver.findElement(By.xpath("(//INPUT[@type='text'])[2]")).sendKeys("");
		driver.findElement(By.xpath("//INPUT[@type='password']")).sendKeys("");
		driver.findElement(
				By.xpath("//BUTTON[@class='_2AkmmA _1LctnI _7UHT_c']")).click();

	}

	public void ReadExcel(int colno) throws Exception {
		FileInputStream fis = new FileInputStream(
				"D:\\ChromeExcelData_Flipcart.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("ChromeExcelData_Flipcart");
		Iterator<Row> it = sh.iterator();
		it.hasNext();
		List<String> li = new ArrayList<>();
		while (it.hasNext()) {
			li.add(it.next().getCell(colno).getStringCellValue());
		}
		System.out.println("li:::" + li);
	}

	public static void main(String args[]) throws Exception {
		FlipcartLogin flogin = new FlipcartLogin();
		flogin.ReadExcel(0);
	}

}
