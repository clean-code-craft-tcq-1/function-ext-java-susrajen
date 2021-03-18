package monitor;

import properties.Messages;
import vitals.Battery;
import vitals.BatteryThresholds;
import vitals.BatteryThresholds.BatteryState;

public class BatteryMonitor {

	static BatteryThresholds batteryThresholds = new BatteryThresholds();

	static Boolean checkIfHigher(float valueToCheck, float threshold) {
		if (valueToCheck > threshold) {
			return true;
		}
		return false;
	}

	static Boolean checkIfLower(float valueToCheck, float threshold) {
		if (valueToCheck < threshold) {
			return true;
		}
		return false;
	}

	static Void checkForLowTemperatureBreach(Battery battery) {
		if (checkIfLower(battery.temperature, batteryThresholds.batteryStateThresholds.get(BatteryState.TEMPERATURE)
				.get("LOW_TEMPERATURE_BREACH_LIMIT"))) {
			battery.statusReporter.printReport(Messages.getString("BatteryStatusChecker.LowTemperatureError")
					+ Messages.getString("Battery.AbnormalValue") + battery.temperature);
		}
		return null;
	}

	static Void checkForLowTemperatureWarning(Battery battery) {
		if (checkIfHigher(battery.temperature,
				batteryThresholds.batteryStateThresholds.get(BatteryState.TEMPERATURE)
						.get("LOW_TEMPERATURE_WARNING_START_LIMIT"))
				&& checkIfLower(battery.temperature, batteryThresholds.batteryStateThresholds
						.get(BatteryState.TEMPERATURE).get("LOW_TEMPERATURE_WARNING_END_LIMIT"))) {
			battery.statusReporter.printReport(Messages.getString("BatteryStatusChecker.LowTemperatureWarning")
					+ Messages.getString("Battery.AbnormalValue") + battery.temperature);
		}
		return null;
	}

	static Void checkForHighTemperatureBreach(Battery battery) {
		if (checkIfHigher(battery.temperature, batteryThresholds.batteryStateThresholds.get(BatteryState.TEMPERATURE)
				.get("HIGH_TEMPERATURE_BREACH_LIMIT"))) {
			battery.statusReporter.printReport(Messages.getString("BatteryStatusChecker.HighTemperatureError")
					+ Messages.getString("Battery.AbnormalValue") + battery.temperature);
	   }
		return null;
	}

	static Void checkForHighTemperatureWarning(Battery battery) {
		if (checkIfHigher(battery.temperature,
				batteryThresholds.batteryStateThresholds.get(BatteryState.TEMPERATURE)
						.get("HIGH_TEMPERATURE_WARNING_START_LIMIT"))
				&& checkIfLower(battery.temperature, batteryThresholds.batteryStateThresholds
						.get(BatteryState.TEMPERATURE).get("HIGH_TEMPERATURE_WARNING_END_LIMIT"))) {

			battery.statusReporter.printReport(Messages.getString("BatteryStatusChecker.HighTemperatureWarning")
					+ Messages.getString("Battery.AbnormalValue") + battery.temperature);
		}
		return null;
	}

	static Void checkForLowSOCBreach(Battery battery) {
		if (checkIfLower(battery.stateOfCharge,
				batteryThresholds.batteryStateThresholds.get(BatteryState.SOC).get("LOW_SOC_BREACH_LIMIT"))) {
			battery.statusReporter.printReport(Messages.getString("BatteryStatusChecker.LowSOCError")
					+ Messages.getString("Battery.AbnormalValue") + battery.stateOfCharge);
		}
		return null;
	}

	static Void checkForLowSOCWarning(Battery battery) {
		if (checkIfHigher(battery.stateOfCharge,
				batteryThresholds.batteryStateThresholds.get(BatteryState.SOC).get("LOW_SOC_WARNING_START_LIMIT"))
				&& checkIfLower(battery.stateOfCharge, batteryThresholds.batteryStateThresholds.get(BatteryState.SOC)
						.get("LOW_SOC_WARNING_END_LIMIT"))) {
		
			battery.statusReporter.printReport(Messages.getString("BatteryStatusChecker.LowSOCWarning")
					+ Messages.getString("Battery.AbnormalValue") + battery.stateOfCharge);
		}
		return null;
	}

	static Void checkForHighSOCBreach(Battery battery) {
		if (checkIfHigher(battery.stateOfCharge,
				batteryThresholds.batteryStateThresholds.get(BatteryState.SOC).get("HIGH_SOC_BREACH_LIMIT"))) {
			battery.statusReporter.printReport(Messages.getString("BatteryStatusChecker.HighSOCError")
					+ Messages.getString("Battery.AbnormalValue") + battery.stateOfCharge);		
		}
		return null;
	}

	static Void checkForHighSOCWarning(Battery battery) {
		if (checkIfHigher(battery.stateOfCharge,
				batteryThresholds.batteryStateThresholds.get(BatteryState.SOC).get("HIGH_SOC_WARNING_START_LIMIT"))
				&& checkIfLower(battery.stateOfCharge, batteryThresholds.batteryStateThresholds.get(BatteryState.SOC)
						.get("HIGH_SOC_WARNING_END_LIMIT"))) {
			battery.statusReporter.printReport(Messages.getString("BatteryStatusChecker.HighSOCWarning")
					+ Messages.getString("Battery.AbnormalValue") + battery.stateOfCharge);		
		}
		return null;
	}

	static Void checkForHighChargeRateBreach(Battery battery) {
		if (checkIfHigher(battery.chargeRate, batteryThresholds.batteryStateThresholds.get(BatteryState.CHARGERATE)
				.get("HIGH_CHARGERATE_BREACH_LIMIT"))) {	
			battery.statusReporter.printReport(Messages.getString("BatteryStatusChecker.HighChargeRateError")
					+ Messages.getString("Battery.AbnormalValue") + battery.chargeRate);		
		}
		return null;
	}

	static Void checkForHighChargeRateWarning(Battery battery) {
		if (checkIfHigher(battery.chargeRate,
				batteryThresholds.batteryStateThresholds.get(BatteryState.CHARGERATE)
						.get("HIGH_CHARGERATE_WARNING_START_LIMIT"))
				&& checkIfLower(battery.stateOfCharge, batteryThresholds.batteryStateThresholds
						.get(BatteryState.CHARGERATE).get("HIGH_CHARGERATE_WARNING_END_LIMIT"))) {
		battery.statusReporter.printReport(Messages.getString("BatteryStatusChecker.HighChargeRateWarning")
					+ Messages.getString("Battery.AbnormalValue") + battery.chargeRate);
		}
		return null;
	}

	public static Void checkForBatteryTemperature(Battery battery) {
		battery.checkBatteryStatus(battery, BatteryMonitor::checkForLowTemperatureBreach)
				.checkBatteryStatus(battery, BatteryMonitor::checkForLowTemperatureWarning)
				.checkBatteryStatus(battery, BatteryMonitor::checkForHighTemperatureBreach)
				.checkBatteryStatus(battery, BatteryMonitor::checkForHighTemperatureWarning);
		return null;
	}

	public static Void checkForBatterySOC(Battery battery) {
		battery.checkBatteryStatus(battery, BatteryMonitor::checkForLowSOCBreach)
				.checkBatteryStatus(battery, BatteryMonitor::checkForLowSOCWarning)
				.checkBatteryStatus(battery, BatteryMonitor::checkForHighSOCBreach)
				.checkBatteryStatus(battery, BatteryMonitor::checkForHighSOCWarning);
		return null;
	}

	public static Void checkForBatteryChargeRate(Battery battery) {
		battery.checkBatteryStatus(battery, BatteryMonitor::checkForHighChargeRateBreach).checkBatteryStatus(battery,
				BatteryMonitor::checkForHighChargeRateWarning);
		return null;
	}

}