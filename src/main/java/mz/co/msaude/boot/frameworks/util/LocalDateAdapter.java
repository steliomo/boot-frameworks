/**
 */
package mz.co.msaude.boot.frameworks.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

/**
 * @author Stélio Moiane
 *
 *         To support serialization
 */
public class LocalDateAdapter extends XmlAdapter<String, LocalDate> {

	@Override
	public LocalDate unmarshal(final String value) {
		return LocalDate.parse(value, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}

	@Override
	public String marshal(final LocalDate value) {
		final LocalDate date = value;

		return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
}
