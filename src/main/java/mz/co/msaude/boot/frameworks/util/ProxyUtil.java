/**
 *
 */
package mz.co.msaude.boot.frameworks.util;

import java.util.Collection;

import org.hibernate.collection.internal.PersistentSet;
import org.hibernate.proxy.HibernateProxy;

/**
 * @author Stélio Moiane
 *
 */
public class ProxyUtil {

	public static <T> boolean isProxy(final T proxy) {
		return proxy instanceof HibernateProxy;
	}

	public static <T> boolean isProxy(final Collection<T> collection) {
		return collection instanceof PersistentSet && !((PersistentSet) collection).wasInitialized();
	}

	public static <T> Long getIdentifier(final T proxy) {
		return (Long) ((HibernateProxy) proxy).getHibernateLazyInitializer().getIdentifier();
	}
}
