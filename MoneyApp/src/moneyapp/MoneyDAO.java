/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moneyapp;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author rodel
 */
public class MoneyDAO implements BasicDAO {

    private static MoneyDAO instance;

    public static MoneyDAO getInstance() {
        if (instance == null) {
            instance = new MoneyDAO();
        }
        return instance;
    }

    public Money findByDesc(String description) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Money m = null;
        try {
            String query = "from Money m where m.description = :desc";
            Query q = session.createQuery(query).setParameter("desc", description);
            m = (Money) q.uniqueResult();
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
        }
        session.close();
        return m;
    }

    public List<Money> findAllWithDuplicate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Money> money;
        String query = "from Money m";
        Query q = session.createQuery(query);
        money = q.list();
        session.getTransaction().commit();
        session.close();
        return money;
    }

    public Set<Money> findAllWithOutDuplicate() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Set<Money> money = new HashSet<>();
        String query = "from Money m";
        Query q = session.createQuery(query);
        for (Object moneyObject : q.list()) {
            money.add((Money) moneyObject);
        }
        session.getTransaction().commit();
        session.close();
        return money;
    }
    
    public List<Money> findAmountGreaterThan(BigDecimal value) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Money> money;
        String query = "from Money m where m.amount > :value";
        Query q = session.createQuery(query).setParameter("value", value);
        money = q.list();
        session.getTransaction().commit();
        session.close();
        return money;
    }

    @Override
    public boolean add(Object o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean result;
        try {
            session.save(o);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = false;
        }
        session.close();
        return result;
    }

    @Override
    public boolean update(Object o) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean result;
        try {
            session.update(o);
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = false;
        }
        session.close();
        return result;
    }

    @Override
    public boolean delete(String id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        boolean result;
        try {
            String query = "from Money m where m.description = :desc";
            Query q = session.createQuery(query).setParameter("desc", id);
            session.delete((Money) q.uniqueResult());
            session.getTransaction().commit();
            result = true;
        } catch (Exception e) {
            session.getTransaction().rollback();
            result = false;
        }
        session.close();
        return result;
    }
}
