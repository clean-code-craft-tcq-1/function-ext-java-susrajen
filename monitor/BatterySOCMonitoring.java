package monitor;

import properties.BatteryMessages;
import vitals.Battery;
import vitals.BatteryThresholds;
import vitals.BatteryThresholds.BatteryState;

public class BatterySOCMonitoring implements BatteryMonitorBreachOfHighLevels, BatteryMonitorBreachOfLowLevels,
BatteryMonitorWarningOfHighLevels, BatteryMonitorWarningOfLowLevels {

	BatteryThresholds batteryThresholds = new BatteryThresholds();
	
	@Override
	public Boolean checkForLowLevelWarning(Battery battery) {
		if (BatteryValueChecker.checkIfHigher(battery.getStateOfCharge(),
				batteryThresholds.batteryStateThresholds.get(BatteryState.SOC).get("LOW_SOC_WARNING_START_LIMIT"))
				&& BatteryValueChecker.checkIfLower(battery.getStateOfCharge(), batteryThresholds.batteryStateThresholds.get(BatteryState.SOC)
						.get("LOW_SOC_WARNING_END_LIMIT"))) {

			battery.getStatusReporter().printReport(BatteryMessages.getString("BatteryStatusChecker.LowSOCWarning")
					+ BatteryMessages.getString("Battery.AbnormalValue") + battery.getStateOfCharge());
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean checkForHighLevelWarning(Battery battery) {
		if (BatteryValueChecker.checkIfHigher(battery.getStateOfCharge(),
				batteryThresholds.batteryStateThresholds.get(BatteryState.SOC).get("HIGH_SOC_WARNING_START_LIMIT"))
				&& BatteryValueChecker.checkIfLower(battery.getStateOfCharge(), batteryThresholds.batteryStateThresholds.get(BatteryState.SOC)
						.get("HIGH_SOC_WARNING_END_LIMIT"))) {
			battery.getStatusReporter().printReport(BatteryMessages.getString("BatteryStatusChecker.HighSOCWarning")
					+ BatteryMessages.getString("Battery.AbnormalValue") + battery.getStateOfCharge());
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean checkForLowLevelBreach(Battery battery) {
		if (BatteryValueChecker.checkIfLower(battery.getStateOfCharge(),
				batteryThresholds.batteryStateThresholds.get(BatteryState.SOC).get("LOW_SOC_BREACH_LIMIT"))) {
			battery.getStatusReporter().printReport(BatteryMessages.getString("BatteryStatusChecker.LowSOCError")
					+ BatteryMessages.getString("Battery.AbnormalValue") + battery.getStateOfCharge());
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

	@Override
	public Boolean checkForHighLevelBreach(Battery battery) {
		if (BatteryValueChecker.checkIfHigher(battery.getStateOfCharge(),
				batteryThresholds.batteryStateThresholds.get(BatteryState.SOC).get("HIGH_SOC_BREACH_LIMIT"))) {
			battery.getStatusReporter().printReport(BatteryMessages.getString("BatteryStatusChecker.HighSOCError")
					+ BatteryMessages.getString("Battery.AbnormalValue") + battery.getStateOfCharge());
			battery.setBatteryStatus(false);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
