package properties;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class BatteryMessages {
	private static final String BUNDLE_NAME = "properties/BatteryMessages";

	private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME, Locale.ENGLISH);

	private BatteryMessages() {
	}

	public static String getString(String key) {
		try {
			return RESOURCE_BUNDLE.getString(key);
		} catch (MissingResourceException e) {
			return '!' + key + '!';
		}
	}
}
