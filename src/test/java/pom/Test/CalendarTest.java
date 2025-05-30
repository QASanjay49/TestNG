package pom.Test;

import org.testng.annotations.Test;

import TestNG.TestNG.Base;
import pom.pages.CalendarPage;


public class CalendarTest extends Base{
	
	CalendarPage calendarpage;
	
	@Test(priority=3)
	public void newAppointment() {	
		calendarpage.clickNewAppointment();	
	}
	
	public void genaretLink() {
		calendarpage.clickGenerateLink();
	}
	public void blockATime() {
		calendarpage.clickBlockATime();
	}
	public void unblockATime() {
		calendarpage.clickUnblockATime();ssssssssssssssss
	}
	
	
	}

