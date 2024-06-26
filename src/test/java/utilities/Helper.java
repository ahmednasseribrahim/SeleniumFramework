package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	//Taking ScreenShot On Failure
	
	public static void CaptureScreenShot(WebDriver driver , String screenShotName) {
		Path dest = Paths.get("./screenshots/",screenShotName+".png");
		try {
			Files.createDirectories(dest.getParent());
			FileOutputStream out = new FileOutputStream(dest.toString());
			out.write(((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES));
			out.close();
			
		} catch (IOException e) {
			System.out.println("Exception While Capturing ScreenShot"+ e.getMessage());
		}
		
	}
}
