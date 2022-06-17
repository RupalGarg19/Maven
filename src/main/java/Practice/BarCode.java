package Practice;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;

public class BarCode {
	
	public static void main(String[] args) throws IOException, NotFoundException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\rupal.garg\\Desktop\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		String barCodeURL = driver.findElement(By.xpath("//*[@id=\"HTML12\"]/div[1]/img")).getAttribute("src");
		System.out.println(barCodeURL);
		
		URL url = new URL(barCodeURL);
		BufferedImage bufferedimage = ImageIO.read(url);
		LuminanceSource luminanceSource = new BufferedImageLuminanceSource(bufferedimage);
		BinaryBitmap binaryBitmap = new BinaryBitmap(new HybridBinarizer(luminanceSource));
		Result result = new MultiFormatReader().decode(binaryBitmap);
		System.out.println("---------------------");
		System.out.println(result.getText());
		  
		driver.close();
	}

}
