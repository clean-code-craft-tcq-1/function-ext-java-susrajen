package vitals;

import java.util.function.Function;
import reporting.BatteryStatusReporter;

public class Battery {
	
	public float temperature;
	public float stateOfCharge;
	public float chargeRate;
	
	public BatteryStatusReporter statusReporter;
	
	

	
	Battery(float temperature, float stateOfCharge, float chargeRate, BatteryStatusReporter statusReporter) {
		this.temperature = temperature;
		this.stateOfCharge = stateOfCharge;
		this.chargeRate = chargeRate;
		this.statusReporter = statusReporter;
	}
	
	public Battery checkBatteryStatus(Battery battery, Function<Battery, Void> statusCheckFunction) {
	   statusCheckFunction.apply(this);
	   return battery;
	 }
}
