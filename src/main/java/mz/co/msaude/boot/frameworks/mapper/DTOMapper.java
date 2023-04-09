/**
 *
 */
package mz.co.msaude.boot.frameworks.mapper;

/**
 * @author Stélio Moiane
 *
 */
public interface DTOMapper<D, M> {

	M mapToDTO(D domain);

}
