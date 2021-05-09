package ru.kgogolev.task6.util;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HibernateUtil {
    public static <T> T doInTransaction(SessionFactory factory, HibernateAction<T> action) {

        try (Session session = factory.getCurrentSession()) {
            try {
                session.beginTransaction();
                T result = action.perform(session);
                session.getTransaction().commit();
                return result;
            } catch (Exception e) {
                session.getTransaction().rollback();
                throw new RuntimeException("SWW", e);

            }
        }
    }
}
