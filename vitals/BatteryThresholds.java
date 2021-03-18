package vitals;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

public class BatteryThresholds {
	public enum BatteryState {
		TEMPERATURE, SOC, CHARGERATE;
	}
	
	public EnumMap<BatteryState, Map<String, Float>> batteryStateThresholds;	
	
	public BatteryThresholds() {
		
		batteryStateThresholds = new EnumMap<BatteryState, Map<String, Float>>(BatteryState.class);
		
		HashMap<String, Float> temperatureMap = new HashMap<String, Float>(); 
		temperatureMap.put("LOW_TEMPERATURE_BREACH_LIMIT",  0f);
		temperatureMap.put("LOW_TEMPERATURE_WARNING_END_LIMIT",  3f);
		temperatureMap.put("LOW_TEMPERATURE_WARNING_START_LIMIT",  -1f);
		temperatureMap.put("NORMAL_TEMPERATURE_END_LIMIT",  42f);
		temperatureMap.put("NORMAL_TEMPERATURE_START_LIMIT",  3f);
		temperatureMap.put("HIGH_TEMPERATURE_BREACH_LIMIT",  46f);
		temperatureMap.put("HIGH_TEMPERATURE_WARNING_END_LIMIT",  46f);
		temperatureMap.put("HIGH_TEMPERATURE_WARNING_START_LIMIT",  42f);
		
		batteryStateThresholds.put(BatteryState.TEMPERATURE, temperatureMap);
		
		
		HashMap<String, Float> socMap = new HashMap<String, Float>(); 
		socMap.put("LOW_SOC_BREACH_LIMIT",  0f);
		socMap.put("LOW_SOC_WARNING_END_LIMIT",  24f);
		socMap.put("LOW_SOC_WARNING_START_LIMIT",  21f);
		socMap.put("NORMAL_SOC_END_LIMIT",  75f);
		socMap.put("NORMAL_SOC_START_LIMIT",  24f);
		socMap.put("HIGH_SOC_BREACH_LIMIT",  80f);
		socMap.put("HIGH_SOC_WARNING_END_LIMIT",  81f);
		socMap.put("HIGH_SOC_WARNING_START_LIMIT",  75f);
		
		batteryStateThresholds.put(BatteryState.SOC, socMap);
		
		HashMap<String, Float> chargeRateMap = new HashMap<String, Float>(); 
		
		chargeRateMap.put("NORMAL_CHARGERATE_END_LIMIT",  0f);
		chargeRateMap.put("NORMAL_CHARGERATE_START_LIMIT",  0.75f);
		chargeRateMap.put("HIGH_CHARGERATE_BREACH_LIMIT",  0.8f);
		chargeRateMap.put("HIGH_CHARGERATE_WARNING_END_LIMIT",  0.81f);
		chargeRateMap.put("HIGH_CHARGERATE_WARNING_START_LIMIT",  0.75f);
		
		batteryStateThresholds.put(BatteryState.CHARGERATE, chargeRateMap);
		
		
	}
}
