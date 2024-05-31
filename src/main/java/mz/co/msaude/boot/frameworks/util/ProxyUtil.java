/**
 *
 */
package mz.co.msaude.boot.frameworks.util;

import org.hibernate.proxy.HibernateProxy;

/**
 * @author Stélio Moiane
 *
 */
public class ProxyUtil {

	public static <T> boolean isProxy(final T proxy) {
		return proxy instanceof HibernateProxy;
	}

	public static <T> Long getIdentifier(final T proxy) {
		return (Long) ((HibernateProxy) proxy).getHibernateLazyInitializer().getIdentifier();
	}
}
