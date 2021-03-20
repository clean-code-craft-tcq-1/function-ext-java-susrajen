package monitor;

public class BatteryValueChecker {
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

}
