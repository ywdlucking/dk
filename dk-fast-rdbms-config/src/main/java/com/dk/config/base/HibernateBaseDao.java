package com.dk.config.base;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.LockModeType;
import javax.persistence.criteria.Predicate;

import com.dk.config.helper.Page;

/**
 * 提供增、删、改、查、分页查询等一些常用功能。
 * 
 * @author ywd
 *
 * @param <T>
 * @param <ID>
 */
public interface HibernateBaseDao<T, ID extends Serializable> {
	
	/**
	 * 获取总纪录数
	 * 
	 * @return
	 */
	public Long getCount();
	
	/**
	 * 获取查询记录数
	 * 
	 * @return
	 */
	public Long getCount(Map<String, Object> filter);

	/**
	 * 保存对象
	 * 
	 * @param obj
	 * @return
	 */
	public T save(T po);

	/**
	 * 更新对象
	 * 
	 * @param obj
	 * @return
	 */
	public T update(T po);

	/**
	 * 获取对象
	 * 
	 * @param id
	 * @return 持久化对象
	 */
	public T findById(ID id);

	/**
	 * 获取对象
	 * 
	 * @param id
	 *            对象ID
	 * @param lockModeType
	 *            是否锁定
	 * @return 持久化对象
	 */
	public T findById(ID id, LockModeType lockModeType);

	/**
	 * 删除对象
	 * 
	 * @param paramT
	 */
	public abstract void delete(T paramT);

	/**
	 * 通过主键删除对象
	 * 
	 * @param paramSerializable
	 */
	public abstract void deleteById(ID id);

	/**
	 * 查询所有对象
	 * 
	 * @return
	 */
	public abstract List<T> findAll();


	/**
	 * 根据查询条件过滤查询对象列表
	 * 
	 * @param paramMap
	 * @return
	 */
	public abstract List<T> findBy(Map<String, Object> paramMap);
	
	/**
	 * 根据查询条件过滤模糊查询对象列表
	 * 
	 * @param paramMap
	 * @return
	 */
	public abstract List<T> findBylike(Map<String, Object> paramMap);

	/**
	 * 根据查询条件like对象列表
	 * 
	 * @param paramMap
	 * @return
	 */
	public abstract List<T> findByLike(Map<String, Object> paramMap);
	
	/**
	 * 根据查询条件like对象列表
	 * 
	 * @param paramMap
	 * @return
	 */
	public abstract List<T> findByEquals(Map<String, Object> paramMap);

	/**
	 * 按属性查找对象列表
	 */
	public List<T> findByProperty(String property, Object value);

	/**
	 * 按属性查找唯一对象
	 */
	public T findUniqueByProperty(String property, Object value);

	/**
	 * 分页查找
	 * @param page
	 * @return
	 */
	public Page<T> findByPage(Page<T> page);

	/**
	 * 分页查找(模糊)
	 * @param page
	 * @param filter  查询参数
	 * @return
	 */
	public Page<T> findByLikeWithPage(Page<T> page, Map<String, Object> filter);
	
	/**
	 * 分页查找(精确)
	 * @param page
	 * @param filter  查询参数
	 * @return
	 */
	public Page<T> findByEqualsWithPage(Page<T> page, Map<String, Object> filter);
	
	/**
	 * 分页查找(精确)
	 * @param page
	 * @param filter
	 * @param between  构建查询条件
	 * @return
	 */
	public Page<T> findByEqualsWithPage(Page<T> page, Map<String, Object> filter, Predicate predicate);
	
	/**
	 * 分页查找(模糊)
	 * @param page
	 * @param filter
	 * @param between  构建查询条件
	 * @return
	 */
	public Page<T> findByLikeWithPage(Page<T> page, Map<String, Object> filter, Predicate predicate);
	
	/**
	 * 自定义SQL查询
	 * @param sql
	 * @return
	 */
	public List<Object[]> getResultByCustomSql(String sql);

}
