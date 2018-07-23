/**
 *
 */
package mz.co.msaude.boot.frameworks.fixturefactory;

import java.util.List;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.processor.Processor;

/**
 * @author Stélio Moiane
 *
 */
public class EntityFactory {

	public static <T> T gimme(final Class<T> clazz, final String label) {
		return Fixture.from(clazz).gimme(label);
	}

	public static <T> T gimme(final Class<T> clazz, final String label, final Processor processor) {
		return Fixture.from(clazz).uses(processor).gimme(label);
	}

	public static <T> List<T> gimme(final Class<T> clazz, final int elements, final String label) {
		return Fixture.from(clazz).gimme(elements, label);
	}

	public static <T> List<T> gimme(final Class<T> clazz, final int elements, final String label,
	        final Processor processor) {
		return Fixture.from(clazz).uses(processor).gimme(elements, label);
	}
}
