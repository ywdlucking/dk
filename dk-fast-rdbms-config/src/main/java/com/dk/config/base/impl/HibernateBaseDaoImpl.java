package com.dk.config.base.impl;

import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.persistence.EntityManager;
import javax.persistence.LockModeType;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dk.config.base.HibernateBaseDao;
import com.dk.config.helper.Page;
import com.dk.config.helper.Page.SortDirection;

/**
 * 提供增、删、改、查、分页查询等一些常用功能。
 * @author ywd
 *
 * @param <T>
 * @param <ID>
 */
public class HibernateBaseDaoImpl<T, ID extends Serializable>  implements HibernateBaseDao<T, ID> {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	protected final Class<T> entityClass;
	
	private static Log log = LogFactory.getLog(HibernateBaseDaoImpl.class);
	
	public HibernateBaseDaoImpl(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
	
	@Override
	public Long getCount() {
		CriteriaQuery<Long> c = entityManager.getCriteriaBuilder().createQuery(Long.class);
		c.select(entityManager.getCriteriaBuilder().count(c.from(entityClass)));
		return entityManager.createQuery(c).getSingleResult();
	}
	
	@Override
	public Long getCount(Map<String, Object> filter) {
		CriteriaQuery<Long> c = entityManager.getCriteriaBuilder().createQuery(Long.class);
		Root<T> r = c.from(entityClass);
		if(filter != null){
			Predicate[] predicates = buildPredicates(r, filter);
			c.select(entityManager.getCriteriaBuilder().count(r)).where(predicates);			
		}else{
			c.select(entityManager.getCriteriaBuilder().count(r));
		}
		return entityManager.createQuery(c).getSingleResult();
	}

	@Override
	public T findById(ID id) {
		return findById(id, LockModeType.NONE);
	}

	@Override
	public T findById(ID id, LockModeType lockModeType) {
		return entityManager.find(entityClass, id, lockModeType);
	}
	
	@Override
	public List<T> findByProperty(String property, Object value) {
		CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
		Root<T> r = c.from(entityClass);
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		c.select(r).where(cb.equal(r.get(property),value));
		return entityManager.createQuery(c).getResultList();
	}

	@Override
	public T findUniqueByProperty(String property, Object value) {
		CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
		Root<T> r = c.from(entityClass);
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		c.select(r).where(cb.equal(r.get(property),value));
		return entityManager.createQuery(c).getSingleResult();
	}

	@Override
	public T save(T po) {
		entityManager.persist(po);
		return po;
	}
	
	@Override
	public T update(T po) {
		return entityManager.merge(po);
	}

	@Override
	public void delete(T obj) {
		entityManager.remove(obj);
	}

	@Override
	public void deleteById(ID id) {
		delete(findById(id));
	}

	@Override
	public List<T> findAll() {
		CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
		c.select(c.from(entityClass));
		return entityManager.createQuery(c).getResultList();
	}

	@Override
	public List<T> findBy(Map<String, Object> paramMap) {
		if(paramMap == null) {
			return findAll();
		}else {
			CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
			Root<T> r = c.from(entityClass);
			Predicate[] ps = new Predicate[paramMap.size()];
			int i = 0;
			for (Map.Entry<String, Object> p : paramMap.entrySet()) {
				CriteriaBuilder cb = entityManager.getCriteriaBuilder();
				ps[i] = cb.equal(r.get(p.getKey()), p.getValue());
				i++;
			}
			c.select(r).where(ps);
			return entityManager.createQuery(c).getResultList();
		}
	}
	
	@Override
	public List<T> findBylike(Map<String, Object> paramMap) {
		if(paramMap == null) {
			return findAll();
		}else {
			CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
			Root<T> r = c.from(entityClass);
			Predicate[] ps = buildPredicates(r, paramMap);
			c.select(r).where(ps);
			return entityManager.createQuery(c).getResultList();
		}
	}
	

	@Override
	public List<T> findByEquals(Map<String, Object> paramMap) {
		if(paramMap == null) {
			return findAll();
		}else {
			CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
			Root<T> r = c.from(entityClass);
			Predicate[] ps = buildEqualsPredicates(r, paramMap);
			c.select(r).where(ps);
			return entityManager.createQuery(c).getResultList();
		}
	}

	@Override
	public List<T> findByLike(Map<String, Object> paramMap) {
		if(paramMap == null) {
			return findAll();
		}else {
			CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
			Root<T> r = c.from(entityClass);
			Predicate[] ps = buildPredicates(r, paramMap);
			c.select(r).where(ps);
			return entityManager.createQuery(c).getResultList();
		}
	}

	@Override
	public Page<T> findByLikeWithPage(Page<T> page, Map<String, Object> filter) {
		CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
		Root<T> r = c.from(entityClass);
		c.select(r);
		if(filter != null){
			Predicate[] ps = buildPredicates(r, filter);
			c.where(ps);
		}
		if(page.isSort()){
			Order[] orders = buildOrders(r,page.getSortMap());
			c.orderBy(orders);
		}
		TypedQuery<T> query = entityManager.createQuery(c);
		query.setFirstResult(page.getStart());
		query.setMaxResults(page.getPageSize());
		page.setResult(query.getResultList());
		page.setTotalSize(getCount(filter));
		return page;
	}
	
	@Override
	public Page<T> findByLikeWithPage(Page<T> page, Map<String, Object> filter, Predicate p) {
		CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
		Root<T> r = c.from(entityClass);
		c.select(r);
		if(filter == null || p == null){
			log.error("filter or p is null");
		}
		Predicate[] ps = addPredicate(buildPredicates(r, filter),p);
		c.where(ps);
		if(page.isSort()){
			Order[] orders = buildOrders(r,page.getSortMap());
			c.orderBy(orders);
		}
		TypedQuery<T> query = entityManager.createQuery(c);
		query.setFirstResult(page.getStart());
		query.setMaxResults(page.getPageSize());
		page.setResult(query.getResultList());
		page.setTotalSize(getCount(filter));
		return page;
	}

	@Override
	public Page<T> findByEqualsWithPage(Page<T> page, Map<String, Object> filter) {
		CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
		Root<T> r = c.from(entityClass);
		c.select(r);
		if(filter != null){
			Predicate[] ps = buildEqualsPredicates(r, filter);
			c.where(ps);
		}
		if(page.isSort()){
			Order[] orders = buildOrders(r,page.getSortMap());
			c.orderBy(orders);
		}
		TypedQuery<T> query = entityManager.createQuery(c);
		query.setFirstResult(page.getStart());
		query.setMaxResults(page.getPageSize());
		page.setResult(query.getResultList());
		page.setTotalSize(getEqualsCount(filter));
		return page;
	}

	private long getEqualsCount(Map<String, Object> filter) {
		CriteriaQuery<Long> c = entityManager.getCriteriaBuilder().createQuery(Long.class);
		Root<T> r = c.from(entityClass);
		if(filter != null){
			Predicate[] predicates = buildEqualsPredicates(r, filter);
			c.select(entityManager.getCriteriaBuilder().count(r)).where(predicates);			
		}else{
			c.select(entityManager.getCriteriaBuilder().count(r));
		}
		return entityManager.createQuery(c).getSingleResult();
	}

	private Predicate[] buildEqualsPredicates(Root<T> r, Map<String, Object> filter) {
		Predicate[] ps = new Predicate[filter.size()];
		int i = 0;
		for (Entry<String, Object> p : filter.entrySet()) {
			CriteriaBuilder fcb = entityManager.getCriteriaBuilder();
			ps[i] = fcb.equal(r.get(p.getKey()), p.getValue());
			i++;
		}
		return ps;
	}

	@Override
	public Page<T> findByEqualsWithPage(Page<T> page, Map<String, Object> filter, Predicate p) {
		CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
		Root<T> r = c.from(entityClass);
		c.select(r);
		if(filter == null || p == null){
			log.error("filter or p is null");
		}
		Predicate[] ps = addPredicate(buildEqualsPredicates(r, filter),p);
		c.where(ps);
		if(page.isSort()){
			Order[] orders = buildOrders(r,page.getSortMap());
			c.orderBy(orders);
		}
		TypedQuery<T> query = entityManager.createQuery(c);
		query.setFirstResult(page.getStart());
		query.setMaxResults(page.getPageSize());
		page.setResult(query.getResultList());
		page.setTotalSize(getEqualsCount(filter));
		return page;
	}

	@Override
	public Page<T> findByPage(Page<T> page) {
		CriteriaQuery<T> c = entityManager.getCriteriaBuilder().createQuery(entityClass);
		Root<T> r = c.from(entityClass);
		c.select(r);
		if(page.isSort()){
			Order[] orders = buildOrders(r,page.getSortMap());
			c.orderBy(orders);			
		}
		TypedQuery<T> query = entityManager.createQuery(c);
		query.setFirstResult(page.getStart());
		query.setMaxResults(page.getPageSize());
		page.setResult(query.getResultList());
		page.setTotalSize(getCount());
		return page;
	}
	
	private Order[] buildOrders(Root<T> r, Map<String, SortDirection> sortMap) {
		Order[] orders = new Order[sortMap.size()];
		int i = 0;
		for (Map.Entry<String, SortDirection> sp : sortMap.entrySet()) {
			CriteriaBuilder ocb = entityManager.getCriteriaBuilder();
			if(SortDirection.ASC.equals(sp.getValue())) {
				orders[i] = ocb.asc(r.get(sp.getKey()));
			}else {
				orders[i] = ocb.desc(r.get(sp.getKey()));			
			}
			i++;
		}
		return orders;
	}

	private Predicate[] buildPredicates(Root<T> r, Map<String, Object> map) {
		Predicate[] ps = new Predicate[map.size()];
		int i = 0;
		for (Map.Entry<String, Object> p : map.entrySet()) {
			CriteriaBuilder fcb = entityManager.getCriteriaBuilder();
			ps[i] = fcb.like(r.get(p.getKey()), "%"+p.getValue()+"%");
			i++;
		}
		return ps;
	}
	
	private Predicate[] addPredicate(Predicate[] ps, Predicate p) {
		Predicate[] rs = new Predicate[ps.length+1];
		for (int i = 0; i < rs.length; i++) {
			if(i == rs.length-1){
				rs[i] = p;
			}else{
				rs[i] = ps[i];				
			}
		}
		return rs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getResultByCustomSql(String sql) {
		Query query = entityManager.createNativeQuery(sql);
		return query.getResultList();
	}
}
