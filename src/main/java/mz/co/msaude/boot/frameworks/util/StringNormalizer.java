/**
 *
 */
package mz.co.msaude.boot.frameworks.util;

import java.text.Normalizer;
import java.util.regex.Pattern;

import mz.co.msaude.boot.frameworks.exception.BusinessException;

/**
 * @author Stélio Moiane
 *
 */
public class StringNormalizer {

	public static String normalize(final String text) throws BusinessException {

		if (text == null) {
			throw new BusinessException("The String must not be null");
		}

		return Pattern.compile("\\p{InCombiningDiacriticalMarks}+")
		        .matcher(Normalizer.normalize(text, Normalizer.Form.NFD)).replaceAll("");
	}

	public static String normalizeAndUppCase(final String name) throws BusinessException {
		return StringNormalizer.normalize(name).toUpperCase();
	}
}
