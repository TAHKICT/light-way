package net.schastny.contactmanager.dao;

import java.util.Date;
import java.util.List;

import net.schastny.contactmanager.domain.Rate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class RateDAOImpl implements RateDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void addRate(Rate rate) {
		sessionFactory.getCurrentSession().save(rate);
	}

	@SuppressWarnings("unchecked")
	public List<Rate> listContact() {

		return sessionFactory.getCurrentSession().createQuery("from Rate")
			.list();
	}

	public List<Rate> listRatesByIdAndDate(Integer bankId,Date from,Date to){
		return sessionFactory.getCurrentSession().createQuery("from Rate E where E.bankId = "+bankId+" and E.TTime > "+from+" and E.TTime < "+to+"").list();
		//return sessionFactory.getCurrentSession().createQuery("from Rate E where E.bankId = "+bankId+"").list();
	}

	public List<Rate> listRatesById(Integer bankId) {
		return sessionFactory.getCurrentSession().createQuery("from Rate E where E.bankId = "+bankId+"").list();
	}

	public Rate lastRateById(Integer bankId){
		List<Rate> list = sessionFactory.getCurrentSession().createQuery("from Rate E where E.bankId ="+bankId+" order by E.TTime desc ").list();
		return (Rate) list.get(0);
	}

	public void removeContact(Integer id) {
		Rate rate = (Rate) sessionFactory.getCurrentSession().load(
				Rate.class, id);
		if (null != rate) {
			sessionFactory.getCurrentSession().delete(rate);
		}

	}
}
