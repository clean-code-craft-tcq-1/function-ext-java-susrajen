package monitor;

import properties.BatteryMessages;
import vitals.Battery;
import vitals.BatteryThresholds;
import vitals.BatteryThresholds.BatteryState;

public class BatteryChargeRateMonitoring
		implements BatteryMonitorBreachOfHighLevels, BatteryMonitorWarningOfHighLevels {
	
	BatteryThresholds batteryThresholds = new BatteryThresholds();

	@Override
	public Boolean checkForHighLevelWarning(Battery battery) {
		if (BatteryValueChecker.checkIfHigher(battery.getChargeRate(), batteryThresholds.batteryStateThresholds.get(BatteryState.CHARGERATE)
				.get("HIGH_CHARGERATE_BREACH_LIMIT"))) {
			battery.getStatusReporter().printReport(BatteryMessages.getString("BatteryStatusChecker.HighChargeRateError")
					+ BatteryMessages.getString("Battery.AbnormalValue") + battery.getChargeRate());
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean checkForHighLevelBreach(Battery battery) {
		if (BatteryValueChecker.checkIfHigher(battery.getChargeRate(),
				batteryThresholds.batteryStateThresholds.get(BatteryState.CHARGERATE)
						.get("HIGH_CHARGERATE_WARNING_START_LIMIT"))
				&& BatteryValueChecker.checkIfLower(battery.getStateOfCharge(), batteryThresholds.batteryStateThresholds
						.get(BatteryState.CHARGERATE).get("HIGH_CHARGERATE_WARNING_END_LIMIT"))) {
			battery.getStatusReporter().printReport(BatteryMessages.getString("BatteryStatusChecker.HighChargeRateWarning")
					+ BatteryMessages.getString("Battery.AbnormalValue") + battery.getChargeRate());
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
