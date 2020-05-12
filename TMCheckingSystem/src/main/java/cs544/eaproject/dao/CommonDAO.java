package cs544.eaproject.dao;

public interface CommonDAO<T> {
	public T add(T t);

	public T update(T t);

	public boolean delete(int id);

	public T get(int id);

	
}

