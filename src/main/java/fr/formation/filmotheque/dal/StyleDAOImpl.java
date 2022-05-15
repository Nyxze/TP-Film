package fr.formation.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;

import fr.formation.filmotheque.entity.Style;
import fr.formation.filmotheque.exception.BeanException;

public class StyleDAOImpl implements StyleDAO {

	private EntityManager em;

	public StyleDAOImpl() {
		em = DaoUtil.getEntityManager();
	}

	@Override
	public void add(Style s) throws BeanException {



			em.getTransaction().begin();

			try {
				em.persist(s);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("TestLOLOL");
				em.getTransaction().rollback();
			}
	}

	@Override
	public List<Style> findAll() throws BeanException {

		return em.createQuery("Select s From Style s", Style.class).getResultList();
	}

	@Override
	public void delete(String str) throws BeanException {

		em.getTransaction().begin();

		Style s = em.find(Style.class, str);
		try {
			em.remove(s);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	@Override
	public void delete(Style s) throws BeanException {

		em.getTransaction().begin();

		try {
			em.remove(s);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	@Override
	public void update(Style s) throws BeanException {

		em.getTransaction().begin();

		try {
			em.merge(s);
			em.getTransaction().commit();
		} catch (Exception e) {
			em.getTransaction().rollback();
		}

	}

	@Override
	public Style findOne(Style s) throws BeanException {

		return em.find(Style.class, s.getLabel());
	}

}
