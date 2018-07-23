/**
 * 
 */
package mz.co.msaude.boot.frameworks.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Stelio Moiane
 * 
 */
public class ParamBuilder{

	private Map<String, Object> params;

	public ParamBuilder() {
		this.params = new HashMap<String, Object>();
	}

	public ParamBuilder add(String key, Object value) {
		this.params.put(key, value);
		return this;
	}

	public Map<String, Object> process() {
		return this.params;
	}
}
