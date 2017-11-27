package ChromeTest;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinkExample {
	public static WebDriver driver= null;
	
	public static void main(String args[]){
		String homepage="https://www.google.co.in/";
		String url="";
		HttpURLConnection huc=null;
		int respondcode = 200;
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Info_Oskc\\Downloads\\Compressed\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get(homepage);
		List<WebElement> link = driver.findElements(By.tagName("a"));
		System.out.println("total links:"+link.size());
		Iterator<WebElement> it = link.iterator();
		while(it.hasNext()){
			url= it.next().getAttribute("href");
			System.out.println(url);
			if(url==null || url.isEmpty()){
			System.out.println("URL is either not configured for anchor tag or it is empty");
			continue;
		}
            if(!url.startsWith(homepage)){
            	System.out.println("url belongs to another domain - skip it");
            	continue;
            }
	
            try{
            	huc = (HttpURLConnection)(new URL(url).openConnection());
            	huc.setRequestMethod("HEAD");
            	huc.connect();
            	
            	respondcode = huc.getResponseCode();
            	if(respondcode>400){
            		System.out.println("link is broken:"+url);
            	}
            	else{
            		System.out.println("valid link:"+url);
            	}
		}catch(MalformedURLException ex){
			
			ex.printStackTrace();
		}
            catch(IOException iex){
            	iex.printStackTrace();
            }
		}  
driver.quit();
}
	}

