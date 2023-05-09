/**
 *
 */
package mz.co.msaude.boot.frameworks.mapper;

/**
 * @author Stélio Moiane
 *
 */
public interface DTOMapper<DTO, D> {

	DTO toDTO(D domain);

	D toDomain(DTO dto);

}
