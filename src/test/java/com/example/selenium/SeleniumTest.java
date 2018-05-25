package com.example.selenium;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

import java.io.File;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.springframework.core.io.ClassPathResource;

public class SeleniumTest {



	private static WebDriver driver;

	@BeforeClass
	public static void setUp(){
		System.setProperty("java.net.preferIPv4Stack", "true");
		
		System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
		DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		driver = new InternetExplorerDriver(capabilities);

	}

	@Test
	public void testFireFoxSelenium() {

		String expected = "{\"data\":{\"sqlcode\":[\"USE templates; INSERT INTO template (description,templatename,udTemplate,lastupdateAttuid,lastupdatedate,createdate,cbus,type_of_cbus,tas) VALUES ('status template for inbound calls and nct','status template','','','1523013747','','0','','')\",\"INSERT INTO question (question,questionType,required,hidden,onchange,aotsfield,from_ticket,lastupdatedateAttuid,tid,qorder,lastupdatedate,createdate,include_question) VALUES ('note:fold down to next tour','comment','n','y','','','','as759d','1','2','1523','152396','1')\",\"INSERT INTO choice (qid,choice,defaultvalue,choicevalue,corder,lastupdatedateATTuid,lastupdatedate,createdate) VALUES ('1','1st level','n','1st level','1','','','')\",\"INSERT INTO question (question,questionType,required,hidden,onchange,aotsfield,from_ticket,lastupdatedateAttuid,tid,qorder,lastupdatedate,createdate,include_question) VALUES ('please update something','comment','n','y','','','','gc8750','1','2','152','17558','1')\"]}}";
		driver.get("http://localhost:8082");
		System.out.println("Google Home Page Opened");
		driver.findElement(By.id("fetch")).click();
		System.out.println("///"+driver.findElement(By.id("demo")).getText());
		assertThat(driver.findElement(By.id("demo")).getText()).contains(expected);

	}

	@AfterClass
	public static void cleanUp(){
		if (driver != null) {
			driver.close();
			driver.quit();
		}
	}
}




