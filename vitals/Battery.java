package vitals;

import java.util.function.Function;
import reporting.BatteryStatusReporter;

public class Battery {
	
	float temperature;
	float stateOfCharge;
	float chargeRate;
	
	BatteryStatusReporter statusReporter;
	
	boolean batteryStatus;

	
	Battery(float temperature, float stateOfCharge, float chargeRate, BatteryStatusReporter statusReporter) {
		this.temperature = temperature;
		this.stateOfCharge = stateOfCharge;
		this.chargeRate = chargeRate;
		this.statusReporter = statusReporter;
		this.batteryStatus = true;
	}
	
	public Battery checkBatteryStatus(Battery battery, Function<Battery, Boolean> statusCheckFunction) {
	   statusCheckFunction.apply(this);
	   return battery;
	 }
	

	public float getTemperature() {
		return temperature;
	}

	public void setTemperature(float temperature) {
		this.temperature = temperature;
	}

	public float getStateOfCharge() {
		return stateOfCharge;
	}

	public void setStateOfCharge(float stateOfCharge) {
		this.stateOfCharge = stateOfCharge;
	}

	public float getChargeRate() {
		return chargeRate;
	}

	public void setChargeRate(float chargeRate) {
		this.chargeRate = chargeRate;
	}

	public BatteryStatusReporter getStatusReporter() {
		return statusReporter;
	}

	public void setStatusReporter(BatteryStatusReporter statusReporter) {
		this.statusReporter = statusReporter;
	}

	public boolean isBatteryStatus() {
		return batteryStatus;
	}

	public void setBatteryStatus(boolean batteryStatus) {
		this.batteryStatus = batteryStatus;
	}
}
