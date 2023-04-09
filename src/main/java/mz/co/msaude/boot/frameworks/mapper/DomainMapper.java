/**
 *
 */
package mz.co.msaude.boot.frameworks.mapper;

/**
 * @author Stélio Moiane
 *
 */
public interface DomainMapper<E, D> {
	D mapToDomain(E entity);
}
