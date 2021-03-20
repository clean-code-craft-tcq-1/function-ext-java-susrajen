package monitor;

import vitals.Battery;

public interface BatteryMonitorWarningOfLowLevels {
	public Boolean checkForLowLevelWarning(Battery battery);
}
