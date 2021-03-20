package monitor;

import vitals.Battery;

public class BatteryMonitor {

	 

	public static Boolean checkForBatteryTemperature(Battery battery) {
		BatteryTemperatureMonitoring temperatureMonitor = new BatteryTemperatureMonitoring();
		Boolean highLevelBreach = temperatureMonitor.checkForHighLevelBreach(battery);
		Boolean highLevelWarning = temperatureMonitor.checkForHighLevelWarning(battery);
		Boolean lowLevelBreach = temperatureMonitor.checkForLowLevelBreach(battery);
		Boolean lowLevelWarning = temperatureMonitor.checkForLowLevelWarning(battery);

		if (highLevelBreach || highLevelWarning || lowLevelBreach || lowLevelWarning) {
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public static Boolean checkForBatterySOC(Battery battery) {
		BatterySOCMonitoring socMonitor = new BatterySOCMonitoring();

		Boolean highLevelBreach = socMonitor.checkForHighLevelBreach(battery);
		Boolean highLevelWarning = socMonitor.checkForHighLevelWarning(battery);
		Boolean lowLevelBreach = socMonitor.checkForLowLevelBreach(battery);
		Boolean lowLevelWarning = socMonitor.checkForLowLevelWarning(battery);

		if (highLevelBreach || highLevelWarning || lowLevelBreach || lowLevelWarning) {
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

	public static Boolean checkForBatteryChargeRate(Battery battery) {
		BatteryChargeRateMonitoring chargeRateMonitor = new BatteryChargeRateMonitoring();
		Boolean highLevelBreach = chargeRateMonitor.checkForHighLevelBreach(battery);
		Boolean highLevelWarning = chargeRateMonitor.checkForHighLevelWarning(battery);
		if (highLevelBreach || highLevelWarning) {
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}

		return Boolean.TRUE;
	}

}
