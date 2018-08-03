/**
 *
 */
package mz.co.msaude.boot.frameworks.adapter;

import static org.junit.Assert.assertEquals;

import java.time.LocalTime;

import org.junit.Before;
import org.junit.Test;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.util.LocalTimeAdapter;

/**
 * @author Stélio Moiane
 *
 */
public class LocalTimeAdapterTest {

	private LocalTimeAdapter localTimeAdapter;

	@Before
	public void setUp() {
		this.localTimeAdapter = new LocalTimeAdapter();
	}

	@Test
	public void shouldMarshalLocalTimeWhenLocalTimeIsPassed() throws BusinessException {

		final LocalTime localTime = LocalTime.of(22, 30);

		final String localTimeString = this.localTimeAdapter.marshal(localTime);

		assertEquals("22:30", localTimeString);
	}

	@Test(expected = BusinessException.class)
	public void shouldNotMarshalLocalTimeWhenLocalTimeIsNull() throws BusinessException {
		this.localTimeAdapter.marshal(null);
	}

	@Test
	public void shouldUnmarshalLocalTimeWhenStringTimeIsPassed() throws BusinessException {

		final LocalTime localTime = LocalTime.of(22, 30);

		final LocalTime unmarshal = this.localTimeAdapter.unmarshal("22:30");

		assertEquals(localTime, unmarshal);
	}

	@Test(expected = BusinessException.class)
	public void shouldNotUnmarshalLocalTimeWhenStringTimePassedIsNull() throws BusinessException {
		this.localTimeAdapter.unmarshal(null);
	}
}
