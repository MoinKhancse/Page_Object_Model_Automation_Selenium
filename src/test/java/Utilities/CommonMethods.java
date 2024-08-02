package Utilities;

import Drivers.BaseDriver;

public class CommonMethods extends BaseDriver {
	
	public void timeOut() throws InterruptedException {
		Thread.sleep(2000);
	}
	public void timeOut(int time) throws InterruptedException {
		Thread.sleep(time);
	}

}
