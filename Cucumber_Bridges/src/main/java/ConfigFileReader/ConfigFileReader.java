package ConfigFileReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConfigFileReader 
{
Properties p = new Properties();

public String getReportConfigPath()
{
 String reportConfigPath = p.getProperty("reportConfigPath");
 if(reportConfigPath!= null) return reportConfigPath;
 else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath"); 
}

public ConfigFileReader() throws IOException
{
//Read object repository file
FileInputStream ip = new FileInputStream(new File("C:\\Users\\neil.bridges\\eclipse-workspace\\CucumberFramework_AnotherApproach\\Configs\\Configuration.properties"));
//load all objects
p.load(ip);
//return p;
}
public String getDriverPath()
{
String BrowserName = p.getProperty("browser");

if(BrowserName.equalsIgnoreCase("Chrome"))
{
String driverPath = p.getProperty("driverPath_Chrome");
return driverPath;
}
if(BrowserName.equalsIgnoreCase("Firefox"))
{
String driverPath = p.getProperty("driverPath_Firefox");
return driverPath;
}
else return BrowserName; 
}

public WebDriver getDriver()
{
String BrowserName = p.getProperty("browser");

if(BrowserName.equalsIgnoreCase("Chrome"))
{
ChromeDriver drivertype = new ChromeDriver();
return drivertype;
}
if(BrowserName.equalsIgnoreCase("Firefox"))
{
FirefoxDriver drivertype = new FirefoxDriver();
return drivertype;
}
if(BrowserName!= null)throw new RuntimeException("BrowserName not specified in the Configuration.properties file.");
return null; 
}

public String getDriverName()
{
String BrowserName = p.getProperty("browser");

if(BrowserName.equalsIgnoreCase("Chrome"))
{
String drivername ="webdriver.chrome.driver" ;
return drivername;
}
if(BrowserName.equalsIgnoreCase("Firefox"))
{
String drivername ="webdriver.gecko.driver" ;
return drivername;
}
if(BrowserName!= null)throw new RuntimeException("BrowserName not specified in the Configuration.properties file.");
return null; 
}

public long getimplicitWait()
{
String implicitWAIT = p.getProperty("implicitwait");
if(implicitWAIT!= null) return Long.parseLong(implicitWAIT);
else throw new RuntimeException("implicitWAIT not specified in the Configuration.properties file."); 
}

public String getpageUrl()
{
String pageURL = p.getProperty("url");
if(pageURL!= null) return pageURL;
else throw new RuntimeException("pageURL not specified in the Configuration.properties file."); 
}

/*public DriverType getBrowser() {
String browserName = p.getProperty("browser");
if(browserName == null || browserName.equals("chrome")) return DriverType.CHROME;
else if(browserName.equalsIgnoreCase("firefox")) return DriverType.FIREFOX;
else if(browserName.equals("iexplorer")) return DriverType.INTERNETEXPLORER;
else throw new RuntimeException("Browser Name Key value in Configuration.properties is not matched : " + browserName);
}*/


}
