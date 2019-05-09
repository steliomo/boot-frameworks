/**
 *
 */
package mz.co.msaude.boot.frameworks.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.model.GenericEntity;
import mz.co.msaude.boot.frameworks.model.UserContext;

/**
 * @author Stélio Moiane
 *
 */
public interface GenericDAO<T extends GenericEntity, V extends Serializable> {

	T findById(final Long id) throws BusinessException;

	T findByUuid(final String uuid) throws BusinessException;

	T create(final UserContext context, final T entity) throws BusinessException;

	T update(final UserContext context, final T entity) throws BusinessException;

	void delete(final UserContext context, final T entity) throws BusinessException;

	List<T> findByNamedQuery(final String queryName, final Map<String, ? extends Object> params)
	        throws BusinessException;

	T findSingleByNamedQuery(final String name, final Map<String, ? extends Object> params) throws BusinessException;

	TypedQuery<T> findByQuery(final String name, final Map<String, ? extends Object> params) throws BusinessException;

	<Y> TypedQuery<Y> findByQuery(final String name, final Map<String, ? extends Object> params, Class<Y> clazz)
	        throws BusinessException;

	<Y> List<Y> findByNamedQuery(final String queryName, final Map<String, ? extends Object> params,
	        final Class<Y> clazz) throws BusinessException;

	<Y> Y findSingleByNamedQuery(final String queryName, final Map<String, ? extends Object> params,
	        final Class<Y> clazz) throws BusinessException;

	Long count(EntityStatus entityStatus) throws BusinessException;

	Long count() throws BusinessException;

}
