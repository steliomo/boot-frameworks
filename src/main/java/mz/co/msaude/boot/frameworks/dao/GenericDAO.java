/**
 *
 */
package mz.co.msaude.boot.frameworks.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.TypedQuery;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.GenericEntity;
import mz.co.msaude.boot.frameworks.model.UserContext;

/**
 * @author Stélio Moiane
 *
 */
public interface GenericDAO<T extends GenericEntity, V extends Serializable> {

	public T findById(final Long id) throws BusinessException;

	public T findByUuid(final String uuid) throws BusinessException;

	public T create(final UserContext context, final T entity) throws BusinessException;

	public T update(final UserContext context, final T entity) throws BusinessException;

	public void delete(final UserContext context, final T entity) throws BusinessException;

	public List<T> findByNamedQuery(final String queryName, final Map<String, ? extends Object> params)
	        throws BusinessException;

	public T findSingleByNamedQuery(final String name, final Map<String, ? extends Object> params)
	        throws BusinessException;

	public TypedQuery<T> findByQuery(final String name, final Map<String, ? extends Object> params)
	        throws BusinessException;

	public <Y> List<Y> findByNamedQuery(final String queryName, final Map<String, ? extends Object> params,
	        final Class<Y> clazz) throws BusinessException;

	public <Y> Y findSingleByNamedQuery(final String queryName, final Map<String, ? extends Object> params,
	        final Class<Y> clazz) throws BusinessException;

}
