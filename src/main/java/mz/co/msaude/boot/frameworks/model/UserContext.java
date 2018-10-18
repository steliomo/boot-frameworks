/**
 *
 */
package mz.co.msaude.boot.frameworks.model;

import java.time.LocalDate;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import mz.co.msaude.boot.frameworks.util.LocalDateAdapter;

/**
 * @author Stélio Moiane
 *
 */
public class UserContext {

	private String uuid;

	private String name;

	private String surname;

	private String fullName;

	private Gender gender;

	@XmlJavaTypeAdapter(LocalDateAdapter.class)
	private LocalDate dateOfBirth;

	private String phoneNumber;

	private String username;

	private String password;

	private String email;

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(final String uuid) {
		this.uuid = uuid;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(final String surname) {
		this.surname = surname;
	}

	public void setFullName() {
		this.fullName = this.name + " " + this.surname;
	}

	public void setFullName(final String fullName) {
		final String[] split = fullName.split(" ");

		this.name = split[0];
		this.surname = split[1];

		this.fullName = fullName;
	}

	public String getFullName() {
		return this.fullName;
	}

	public Gender getGender() {
		return this.gender;
	}

	public void setGender(final Gender gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(final LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername() {
		this.username = this.phoneNumber;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}
}
