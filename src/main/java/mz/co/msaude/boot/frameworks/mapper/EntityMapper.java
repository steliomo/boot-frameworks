/**
 *
 */
package mz.co.msaude.boot.frameworks.mapper;

/**
 * @author Stélio Moiane
 *
 */
public interface EntityMapper<E, D> {

	E toEntity(D domain);

	D toDomain(E entity);
}
