package hibernate;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateApp {

	public static void main(String[] args) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();
		Persona persona = new Persona();

		persona.setDni(111111112);
		persona.setApellido("Crispis");
		persona.setNombre("Julius");
		persona.setSexo('M');

		Transaction tx = session.beginTransaction();
		try {
			session.saveOrUpdate(persona);
			System.out.println("Se genero el registro con exito.....!!");

			tx.commit();

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<Persona> cq = cb.createQuery(Persona.class);
			Root<Persona> rp = cq.from(Persona.class);
			cq.select(rp).where(cb.like(rp.get("nombre"), "%s%"));
			List<Persona> lista = session.createQuery(cq).getResultList();
			for (Persona p : lista) {
				System.out.println(p);
			}
		} catch (HibernateException e) {
			if (tx != null)
				tx.rollback();
			e.printStackTrace();
		} finally {
			session.close();
			factory.close();
		}

	}
}
