package com.testing.cpsat.mock;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;


import com.testing.base.TestBase;

public class PracticeSet3question3POM extends TestBase{

	private String lnk_speaker_xpath="//ul[@id='menu-main-1']/li/a[contains(text(),'Speakers')]";
	private String lnk_aspeaker_xpath ="//ul[@class='sub-menu']/li/a[contains(text(),'About Speakers')]";
	
	public PracticeSet3question3POM(WebDriver driver) {
		
		this.d=driver;
	}
	
	public void moveToAboutSpeaker() {
		d.findElement(By.xpath("//i[@class='eicon-close']")).click();
		WebElement aspeaker = d.findElement(By.xpath(lnk_aspeaker_xpath));
		WebElement speaker = d.findElement(By.xpath(lnk_speaker_xpath));
		mouseHover(speaker);
		wait(1);
		jsClick(aspeaker); 
		
	}
	
	public void GetPageTitle() {
		System.out.println("The title is: "+d.getTitle());
	}
	
	public void GetSpeakerDetails(String nameOfSpeaker) {
		String name= d.findElement(By.xpath("//tr/td[contains(text(),'"+nameOfSpeaker+"')]")).getText();
		System.out.println("The name of the speaker is: " +name);
		System.out.print("TOPIC:"+ d.findElement(By.xpath("//tr/td[contains(text(),'"+nameOfSpeaker+"')]/following::td[1]")).getText());
		System.out.print("|ATAMyStory:"+d.findElement(By.xpath("//tr/td[contains(text(),'"+nameOfSpeaker+"')]/following::td[2]/a")).getAttribute("href"));
		System.out.print("|Video Interview:"+d.findElement(By.xpath("//tr/td[contains(text(),'"+nameOfSpeaker+"')]/following::td[3]/a")).getAttribute("href"));
		System.out.println("");
	}
}