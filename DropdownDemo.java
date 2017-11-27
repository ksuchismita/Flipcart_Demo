package ChromeTest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownDemo {
	public static void main(String args[]){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Info_Oskc\\Downloads\\Compressed\\chromedriver.exe");
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		WebElement ele = driver.findElement(By.xpath("//SELECT[@id='month']"));
		Select sel = new Select(ele);
		List<WebElement> lidrop = sel.getOptions();
		System.out.println(lidrop.size());
		for(int i=0;i<lidrop.size();i++){
			System.out.println("list of selected dropdown:"+lidrop.get(i).getText());
			//sel.selectByIndex(10);
			
			ArrayList< String> arl = new ArrayList<>();
			Collections.sort(arl);
			for(String str : arl){
				System.out.println(str);
			}
			
	}
		
		
	}

}
