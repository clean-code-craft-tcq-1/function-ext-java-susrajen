package monitor;

import vitals.Battery;

public class BatteryMonitor {

	 

	public static Boolean checkForBatteryTemperature(Battery battery) {
		BatteryTemperatureMonitoring temperatureMonitor = new BatteryTemperatureMonitoring();
		temperatureMonitor.checkForHighLevelBreach(battery);
		temperatureMonitor.checkForHighLevelWarning(battery);
		temperatureMonitor.checkForLowLevelBreach(battery);
		temperatureMonitor.checkForLowLevelWarning(battery);

		return battery.isBatteryStatus();
	}

	public static Boolean checkForBatterySOC(Battery battery) {
		BatterySOCMonitoring socMonitor = new BatterySOCMonitoring();

		socMonitor.checkForHighLevelBreach(battery);
		socMonitor.checkForHighLevelWarning(battery);
		socMonitor.checkForLowLevelBreach(battery);
		socMonitor.checkForLowLevelWarning(battery);

		return battery.isBatteryStatus();
	}

	public static Boolean checkForBatteryChargeRate(Battery battery) {
		BatteryChargeRateMonitoring chargeRateMonitor = new BatteryChargeRateMonitoring();
		chargeRateMonitor.checkForHighLevelBreach(battery);
		chargeRateMonitor.checkForHighLevelWarning(battery);
		
		return battery.isBatteryStatus();
	}

}
