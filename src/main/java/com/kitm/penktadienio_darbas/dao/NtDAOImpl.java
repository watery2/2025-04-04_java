package com.kitm.penktadienio_darbas.dao;

import com.kitm.penktadienio_darbas.entity.NTObject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NtDAOImpl implements NtDAO{
    private EntityManager entityManager;

    @Autowired
    public NtDAOImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(NTObject ntObject) {
        entityManager.persist(ntObject);
    }

    @Override
    public NTObject findById(Integer id) {
        return entityManager.find(NTObject.class, id);
    }

    @Override
    public List<NTObject> findAll() {
        return entityManager.createQuery("SELECT n FROM NTObject n", NTObject.class).getResultList();
    }

    @Override
    public List<NTObject> findByType(String typee) {
        TypedQuery<NTObject> query = entityManager.createQuery("FROM NTObject WHERE type=:data", NTObject.class);

        query.setParameter("data", typee);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(NTObject ntObject) {
        entityManager.merge(ntObject);
    }

    @Override
    @Transactional
    public void updateBest() {
        entityManager.createQuery("UPDATE NTObject SET vip = true WHERE rating>=8").executeUpdate();

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        NTObject ntObject = entityManager.find(NTObject.class, id);

        entityManager.remove(ntObject);
    }
}
