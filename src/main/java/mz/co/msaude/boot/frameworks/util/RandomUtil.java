/**
 *
 */
package mz.co.msaude.boot.frameworks.util;

import java.util.Random;

/**
 * @author Stélio Moiane
 *
 */
public class RandomUtil {

	private static final int BOUND = 10;

	public static String password(final int length) {
		final StringBuilder builder = new StringBuilder();
		final Random random = new Random();

		for (int i = 0; i < length; i++) {
			builder.append(random.nextInt(RandomUtil.BOUND));
		}

		return builder.toString();
	}
}
