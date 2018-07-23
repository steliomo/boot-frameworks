/**
 *
 */
package mz.co.msaude.boot.frameworks.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.model.GenericEntity;

/**
 * @author Stélio Moiane
 *
 */
public class TestUtil {

	public static <T extends GenericEntity> void assertCreation(final T entity) {
		assertNotNull(entity.getId());
		assertNotNull(entity.getCreatedBy());
		assertNotNull(entity.getCreatedAt());
		assertNull(entity.getUpdatedBy());
		assertNull(entity.getUpdatedAt());
		assertEquals(EntityStatus.ACTIVE, entity.getEntityStatus());
	}

	public static <T extends GenericEntity> void assertUpdate(final T entity) {
		assertNotNull(entity.getId());
		assertNotNull(entity.getCreatedBy());
		assertNotNull(entity.getCreatedAt());
		assertNotNull(entity.getUpdatedBy());
		assertNotNull(entity.getUpdatedAt());
		assertEquals(EntityStatus.ACTIVE, entity.getEntityStatus());
	}
}
