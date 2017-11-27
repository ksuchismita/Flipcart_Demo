package ChromeTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import sun.reflect.ReflectionFactory.GetReflectionFactoryAction;

import com.sun.net.httpserver.HttpsConfigurator;
import com.thoughtworks.selenium.webdriven.commands.GetAlert;

public class BrokenImages {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Info_Oskc\\Downloads\\Compressed\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
        driver.get("https://www.flipkart.com/");
        List<WebElement> brokenimg = driver.findElements(By.tagName("img"));
        System.out.println("total images:"+ brokenimg.size());
        
        
        	for(int i=0;i<brokenimg.size();i++){
        		WebElement ele = brokenimg.get(i);
        		String url = ele.getAttribute("src");
        		verifyLinkActive(url);
        		
        		
        		
        	}
        	
	}
public static void verifyLinkActive(String linkurl){
	try{
		URL url = new URL(linkurl);
		HttpURLConnection httpurlconnect = (HttpURLConnection)url.openConnection();
		
		//set time out coonection
		httpurlconnect.setConnectTimeout(2000);
		//open communication link
		httpurlconnect.connect();
		
		//to verify the response code
		if(httpurlconnect.getResponseCode()==200){
			System.out.println(linkurl +"-"+ httpurlconnect.getResponseMessage());
		}
		if(httpurlconnect.getResponseCode()==HttpURLConnection.HTTP_NOT_FOUND){
			System.out.println(linkurl+"-"+httpurlconnect.getResponseMessage()+"-"+HttpURLConnection.HTTP_NOT_FOUND);
			
		}
	}
		catch(Exception e){
			
	}
	
}
/*static int invalidlink;
public static void invalidlinkcount(){
invalidlinkcount();
	System.out.println("count invalid link:"+invalidlink);
	
}*/
}
