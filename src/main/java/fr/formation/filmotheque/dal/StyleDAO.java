package fr.formation.filmotheque.dal;

import java.util.List;


import fr.formation.filmotheque.entity.Style;
import fr.formation.filmotheque.exception.BeanException;

public interface StyleDAO {
	
	void add(Style s) throws BeanException;

	List<Style> findAll() throws BeanException;

	void delete(String str) throws BeanException;
	void delete(Style s) throws BeanException;

	Style findOne(Style s) throws BeanException;
	void update(Style s) throws BeanException;

}
