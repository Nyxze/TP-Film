package fr.formation.filmotheque.dal;

import java.util.List;

import fr.formation.filmotheque.entity.Film;
import fr.formation.filmotheque.exception.BeanException;

public interface FilmDAO {
	
	void add(Film l) throws BeanException;

	List<Film> findAll() throws BeanException;

	void delete(int id) throws BeanException;
	void delete(Film f) throws BeanException;
	Film findById(int id) throws BeanException;

	void update(Film l) throws BeanException;

}
