package ru.kgogolev.task6.util;

import org.hibernate.Session;

@FunctionalInterface
public interface HibernateAction<T> {

    T perform(Session session);
}
