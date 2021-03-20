package vitals;

import monitor.BatteryMonitor;
import reporting.BatteryConsoleReporter;
import reporting.BatteryStatusReporter;

public class BatteryEvaluator {
       
    static boolean checkBatteryStatus(Battery battery) {
    	battery.checkBatteryStatus(battery, BatteryMonitor::checkForBatteryTemperature)
    	.checkBatteryStatus(battery, BatteryMonitor::checkForBatterySOC)
    	.checkBatteryStatus(battery, BatteryMonitor::checkForBatteryChargeRate);
    	
    	return battery.batteryStatus;
    }
    
    
	private static void batteryTester(BatteryStatusReporter statusReporter) {
		assert(checkBatteryStatus(new Battery(25, 70, 0.7f, statusReporter)) == true);
    	assert(checkBatteryStatus(new Battery(50, 85, 0.0f, statusReporter)) == false);
    	assert(checkBatteryStatus(new Battery(-5, 60, 0.0f, statusReporter)) == false);
    	assert(checkBatteryStatus(new Battery(-5, 85, 0.0f, statusReporter)) == false);
    	assert(checkBatteryStatus(new Battery(20, 85, 0.0f, statusReporter)) == false);
    	assert(checkBatteryStatus(new Battery(50, 35, 0.9f, statusReporter)) == false);
	}
 

    public static void main(String[] args) {
    	
    	BatteryStatusReporter statusReporter = new BatteryConsoleReporter();
    	
    	checkBatteryStatus(new Battery(25, 70, 0.7f, statusReporter));
    	checkBatteryStatus(new Battery(50, 85, 0.0f, statusReporter));
    	checkBatteryStatus(new Battery(-5, 60, 0.0f, statusReporter));
    	checkBatteryStatus(new Battery(-5, 85, 0.0f, statusReporter));
    	checkBatteryStatus(new Battery(20, 85, 0.0f, statusReporter));
    	checkBatteryStatus(new Battery(50, 35, 0.9f, statusReporter));
   
    	batteryTester(statusReporter);
    }


}
