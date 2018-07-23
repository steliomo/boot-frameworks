/**
 *
 */
package mz.co.msaude.boot.frameworks.model;

/**
 * @author Stélio Moiane
 *
 */
public class UserContext {

	private String uuid;

	private String username;

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}
}
