/**
 *
 */
package mz.co.msaude.boot.frameworks.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import mz.co.msaude.boot.frameworks.exception.BusinessException;
import mz.co.msaude.boot.frameworks.model.EntityStatus;
import mz.co.msaude.boot.frameworks.model.GenericEntity;
import mz.co.msaude.boot.frameworks.model.UserContext;
import mz.co.msaude.boot.frameworks.util.UuidFactory;

/**
 * @author Stélio Moiane
 *
 */
public class GenericDAOImpl<T extends GenericEntity, V extends Serializable> implements GenericDAO<T, V> {

	@PersistenceContext
	private EntityManager entityManager;

	private final Class<T> clazz;

	public GenericDAOImpl() {
		this.clazz = this.getClazz();
	}

	@SuppressWarnings("unchecked")
	private Class<T> getClazz() {
		final ParameterizedType genericSuperclass = (ParameterizedType) this.getClass().getGenericSuperclass();
		return (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	@Override
	public T findById(final Long id) throws BusinessException {
		return this.entityManager.find(this.clazz, id);
	}

	@Override
	public T findByUuid(final String uuid) throws BusinessException {

		final TypedQuery<T> query = this.entityManager
		        .createQuery("SELECT e FROM " + this.clazz.getName() + " e WHERE e.uuid = :uuid", this.clazz)
		        .setParameter("uuid", uuid);

		T entiy = null;

		try {
			entiy = query.getSingleResult();
		}
		catch (final NoResultException e) {
			throw new BusinessException(e.getMessage());
		}

		return entiy;
	}

	@Override
	public T create(final UserContext context, final T entity) throws BusinessException {
		entity.setCreatedBy(context.getUuid());
		entity.setCreatedAt(LocalDateTime.now());
		entity.setEntityStatus(EntityStatus.ACTIVE);

		if (entity.getUuid() == null) {
			entity.setUuid(UuidFactory.generate());
		}

		this.entityManager.persist(entity);

		return entity;
	}

	@Override
	public T update(final UserContext context, final T entity) throws BusinessException {
		entity.setUpdatedBy(context.getUuid());
		entity.setUpdatedAt(LocalDateTime.now());

		this.entityManager.merge(entity);

		return entity;
	}

	@Override
	public void delete(final UserContext context, final T entity) throws BusinessException {
		final T foudEntity = this.findById(entity.getId());
		this.entityManager.remove(foudEntity);
	}

	@Override
	public List<T> findByNamedQuery(final String queryName, final Map<String, ? extends Object> params)
	        throws BusinessException {

		final TypedQuery<T> query = this.entityManager.createNamedQuery(queryName, this.clazz);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	@Override
	public T findSingleByNamedQuery(final String name, final Map<String, ? extends Object> params)
	        throws BusinessException {

		final TypedQuery<T> query = this.entityManager.createNamedQuery(name, this.clazz);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getSingleResult();
	}

	@Override
	public TypedQuery<T> findByQuery(final String name, final Map<String, ? extends Object> params)
	        throws BusinessException {

		final TypedQuery<T> query = this.entityManager.createNamedQuery(name, this.clazz);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query;
	}

	@Override
	public <Y> List<Y> findByNamedQuery(final String queryName, final Map<String, ? extends Object> params,
	        final Class<Y> clazz) throws BusinessException {

		final TypedQuery<Y> query = this.entityManager.createNamedQuery(queryName, clazz);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getResultList();
	}

	@Override
	public <Y> Y findSingleByNamedQuery(final String queryName, final Map<String, ? extends Object> params,
	        final Class<Y> clazz) throws BusinessException {

		final TypedQuery<Y> query = this.entityManager.createNamedQuery(queryName, clazz);

		for (final Map.Entry<String, ? extends Object> param : params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}

		return query.getSingleResult();
	}
}
