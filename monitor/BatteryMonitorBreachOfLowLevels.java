package monitor;

import vitals.Battery;

public interface BatteryMonitorBreachOfLowLevels {
	public Boolean checkForLowLevelBreach(Battery battery);
}
