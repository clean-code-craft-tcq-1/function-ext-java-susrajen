package reporting;

public class BatteryConsoleReporter implements BatteryStatusReporter {

	@Override
	public void printReport(String batteryStatus) {
	  System.out.println(batteryStatus);
	}
}
