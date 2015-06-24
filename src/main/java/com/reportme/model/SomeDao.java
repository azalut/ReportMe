package com.reportme.model;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class SomeDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void saveSomeEntity() {
        SomeEntity someEntity = new SomeEntity("Some name");
        entityManager.persist(someEntity);
    }
}
