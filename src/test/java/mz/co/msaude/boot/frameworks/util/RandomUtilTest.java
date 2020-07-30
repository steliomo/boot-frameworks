/**
 *
 */
package mz.co.msaude.boot.frameworks.util;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Stélio Moiane
 *
 */
public class RandomUtilTest {

	@Test
	public void shouldGenerateRandomPassword() {

		final int length = 4;

		final String randomPassword = RandomUtil.password(length);

		Assert.assertEquals(length, randomPassword.length());
	}

}
