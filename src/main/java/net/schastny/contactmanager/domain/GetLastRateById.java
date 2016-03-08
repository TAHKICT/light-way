package net.schastny.contactmanager.domain;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Created by админ on 18.12.2014.
 */
public class GetLastRateById {
    private static SessionFactory factory = new Configuration().configure().buildSessionFactory();;
    //get current rate from one of the banks
    public Rate getById(int bankId) {
        factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();
        Rate rates = null;
        session.beginTransaction();
        rates = (Rate) session.createQuery("FROM ExchangeBase E where E.id ="+bankId+" order by E.TTime DESC").uniqueResult();
        session.close();
        return rates;
    }

    public static void main(String[] args) {
        GetLastRateById getCurrentRate = new GetLastRateById();
        System.out.println(getCurrentRate.getById(1).getUSDbuy());
    }
}
