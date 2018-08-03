/**
 *
 */
package mz.co.msaude.boot.frameworks.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import mz.co.msaude.boot.frameworks.exception.BusinessException;

/**
 * @author Stélio Moiane
 *
 */
public class LocalTimeAdapter extends XmlAdapter<String, LocalTime> {

	private static final String PATTERN = "HH:mm";

	@Override
	public LocalTime unmarshal(final String value) throws BusinessException {

		if (value == null) {
			throw new BusinessException("String cannot be null");
		}

		return LocalTime.parse(value, DateTimeFormatter.ofPattern(PATTERN));
	}

	@Override
	public String marshal(final LocalTime value) throws BusinessException {

		if (value == null) {
			throw new BusinessException("LocalTime cannot be null");
		}

		return value.format(DateTimeFormatter.ofPattern(PATTERN));
	}
}
