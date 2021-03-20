package monitor;

import properties.BatteryMessages;
import vitals.Battery;
import vitals.BatteryThresholds;
import vitals.BatteryThresholds.BatteryState;

public class BatteryTemperatureMonitoring implements BatteryMonitorBreachOfHighLevels, BatteryMonitorBreachOfLowLevels,
		BatteryMonitorWarningOfHighLevels, BatteryMonitorWarningOfLowLevels {

	BatteryThresholds batteryThresholds = new BatteryThresholds();
	
	@Override
	public Boolean checkForLowLevelWarning(Battery battery) {
		if (BatteryValueChecker.checkIfHigher(battery.getTemperature(),
				batteryThresholds.batteryStateThresholds.get(BatteryState.TEMPERATURE)
						.get("LOW_TEMPERATURE_WARNING_START_LIMIT"))
				&& BatteryValueChecker.checkIfLower(battery.getTemperature(), batteryThresholds.batteryStateThresholds
						.get(BatteryState.TEMPERATURE).get("LOW_TEMPERATURE_WARNING_END_LIMIT"))) {
			battery.getStatusReporter().printReport(BatteryMessages.getString("BatteryStatusChecker.LowTemperatureWarning")
					+ BatteryMessages.getString("Battery.AbnormalValue") + battery.getTemperature());
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean checkForHighLevelWarning(Battery battery) {
		if (BatteryValueChecker.checkIfHigher(battery.getTemperature(),
				batteryThresholds.batteryStateThresholds.get(BatteryState.TEMPERATURE)
						.get("HIGH_TEMPERATURE_WARNING_START_LIMIT"))
				&& BatteryValueChecker.checkIfLower(battery.getTemperature(), batteryThresholds.batteryStateThresholds
						.get(BatteryState.TEMPERATURE).get("HIGH_TEMPERATURE_WARNING_END_LIMIT"))) {

			battery.getStatusReporter().printReport(BatteryMessages.getString("BatteryStatusChecker.HighTemperatureWarning")
					+ BatteryMessages.getString("Battery.AbnormalValue") + battery.getTemperature());
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean checkForLowLevelBreach(Battery battery) {
		if (BatteryValueChecker.checkIfLower(battery.getTemperature(), batteryThresholds.batteryStateThresholds.get(BatteryState.TEMPERATURE)
				.get("LOW_TEMPERATURE_BREACH_LIMIT"))) {
			battery.getStatusReporter().printReport(BatteryMessages.getString("BatteryStatusChecker.LowTemperatureError")
					+ BatteryMessages.getString("Battery.AbnormalValue") + battery.getTemperature());
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean checkForHighLevelBreach(Battery battery) {
		if (BatteryValueChecker.checkIfHigher(battery.getTemperature(), batteryThresholds.batteryStateThresholds.get(BatteryState.TEMPERATURE)
				.get("HIGH_TEMPERATURE_BREACH_LIMIT"))) {
			battery.getStatusReporter().printReport(BatteryMessages.getString("BatteryStatusChecker.HighTemperatureError")
					+ BatteryMessages.getString("Battery.AbnormalValue") + battery.getTemperature());
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
