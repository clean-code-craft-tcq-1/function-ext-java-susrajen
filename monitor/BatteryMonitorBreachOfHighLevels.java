package monitor;

import vitals.Battery;

public interface BatteryMonitorBreachOfHighLevels {
	public Boolean checkForHighLevelBreach(Battery battery);
}
