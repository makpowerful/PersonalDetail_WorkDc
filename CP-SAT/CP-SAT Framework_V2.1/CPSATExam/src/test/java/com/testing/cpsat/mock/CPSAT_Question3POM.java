package com.testing.cpsat.mock;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.junit.Assert;
import org.openqa.selenium.support.Color;

import com.testing.base.CPSAT_Question5;


public class CPSAT_Question3POM extends CPSAT_Question5 {

	private String speaker_xpath="//ul[@id='menu-main-1']/li/a[contains(text(),'Speaker')]";
	private String Aspeaker_xpath= "//ul[@class='sub-menu']/li/a[contains(text(),'About Speakers')]";
	
	By SpeakerNames=By.xpath("//table[@data-id='66af78a']//tr/td[2]");
	By SpeakerTopic=By.xpath("//table[@data-id='66af78a']//tr/td[3]");
	By SpeakerStory=By.xpath("//table[@data-id='66af78a']//tr/td[4]/a");
	By SpeakerInterview=By.xpath("//table[@data-id='66af78a']//tr/td[5]/a");
	
	public CPSAT_Question3POM(WebDriver d) {

		this.d = d;
	}

	public String GetPageTitle() {
		WebElement sp=d.findElement(By.xpath(speaker_xpath));
		WebElement asp=d.findElement(By.xpath(Aspeaker_xpath));
		Actions action=new Actions(d);
		action.moveToElement(sp);
		jsClick(asp);
		wait(2);
		return d.getTitle();
	}
	
	public void getSpeakerDetails(String speakerName) {
		 int counter=1;
		 String speakTopic="";
		 String speakStory="";
		 String interview="";
		 List<WebElement> spkNames=d.findElements(SpeakerNames);
		int videosize=0;
		String videoInterview="";
		for(WebElement name:spkNames) {
			if(name.getText().equalsIgnoreCase(speakerName)) {
				
				speakTopic=d.findElements(SpeakerTopic).get(counter-1).getText();
				speakStory=d.findElements(SpeakerStory).get(counter-1).getAttribute("href");
				videosize=d.findElements(By.xpath("//table[@data-id='66af78a']//tr['"+counter+"']/td[5]/a")).size();
			}
			if(videosize!=0) {
				videoInterview=d.findElement(By.xpath("//table[@data-id='66af78a']//tr['"+counter+"']/td[5]/a")).getAttribute("href");
				counter++;
				
			}
			if(speakTopic=="") {
				System.out.println("Speaker is not present");

			}
			else {
				System.out.println("Speaker Topic:"+speakTopic+"|Speak Story:"+speakStory+"|Interview:"+videoInterview);
			}
		}
		
	}
		
	}
