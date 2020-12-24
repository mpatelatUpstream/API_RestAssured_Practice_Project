package nishant_Utils;

import java.util.HashMap;
import java.util.Map;

public class HeaderConfigs {

	public Map<String, String> defaultHeader() {
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		return defaultHeaders;
	}
	
	public Map<String, String> headersWithToken() {
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		defaultHeaders.put("Acess_Token", "sddskfsdhfkjshfks");		
		defaultHeaders.put("jwt_Token", "test");
		defaultHeaders.put("Tenet_user", "test");
		return defaultHeaders;
	}
	
	public Map<String, String> headersWithoutToken() {
		Map<String, String> defaultHeaders = new HashMap<String, String>();
		defaultHeaders.put("Content-Type", "application/json");
		defaultHeaders.put("Acess_Token", "sddskfsdhfkjshfks");		
		defaultHeaders.put("jwt_Token", "test");
		defaultHeaders.put("Tenet_user", "test");
		return defaultHeaders;
	}

}
