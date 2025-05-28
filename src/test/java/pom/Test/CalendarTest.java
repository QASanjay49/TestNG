package pom.Test;

import TestNG.TestNG.Base;
import pom.pages.CalendarPage;


public class CalendarTest extends Base{
	
	CalendarPage calendarpage;
	
	
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
		calendarpage.clickUnblockATime();
	}
	
	
	}

