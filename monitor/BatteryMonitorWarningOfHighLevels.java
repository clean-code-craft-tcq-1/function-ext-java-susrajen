package monitor;

import vitals.Battery;

public interface BatteryMonitorWarningOfHighLevels {
	public Boolean checkForHighLevelWarning(Battery battery);
}
