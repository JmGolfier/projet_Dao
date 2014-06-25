package Epsi.ProjetDAO.dao;

import java.io.Serializable;
import java.util.List;


public interface Dao<T, PK extends Serializable> {

	/**
	 * List every objects of the selected type from the data source
	 *
	 * @return
	 */
	public List<T> list(Class<T> c);

	/**
	 * Find an object identified by an ID
	 *
	 * @param id
	 * @return
	 */
	public T find(Class<T> c, PK id);

	/**
	 * Save an object in the data source
	 *
	 * @param obj
	 */
	public PK save(T obj);

	/**
	 * Update an object present in the data source
	 * 
	 * @retrun
	 */
	public void update(T obj);

	/**
	 * Delete an object from the data source
	 *
	 * @param obj
	 */
	public void delete(T obj);


}
