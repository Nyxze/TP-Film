package fr.formation.filmotheque.dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import fr.formation.filmotheque.entity.Film;
import fr.formation.filmotheque.entity.Style;
import fr.formation.filmotheque.exception.BeanException;

public class FilmDAOImpl implements FilmDAO {

	private EntityManager em;

	public FilmDAOImpl() {
		em = DaoUtil.getEntityManager();
	}

	@Override
	public void add(Film f) {
		System.out.println("Test");
		EntityTransaction tr = em.getTransaction();
		try {
			if (!tr.isActive())
				tr.begin();
			Style style = em.find(Style.class, f.getStyle().getLabel());
			if( style != null)
				f.setStyle(style);
			em.persist(f);
			tr.commit();
		} catch (Exception e) {
			tr.rollback();
			DaoUtil.close();
			DaoUtil.open();
			System.out.println("Erreur lors de l'ajout d'un film " + e.getMessage());
		}

	}

	@Override
	public List<Film> findAll() {
		if(!DaoUtil.getEntityManager().isOpen()){
			DaoUtil.open();
		}
		return em.createQuery("Select f From Film f", Film.class).getResultList();
	}

	@Override
	public Film findById(int id) {
		return em.find(Film.class, id);
	}

	@Override
	public void update(Film g) {
		em.getTransaction().begin();

		try {
			em.merge(g);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public void delete(Film f) {
		em.getTransaction().begin();

		try {
			em.remove(f);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

	@Override
	public void delete(int id) throws BeanException {
		em.getTransaction().begin();

		Film f = em.find(Film.class, id);
		try {
			em.remove(f);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}

	}

}
