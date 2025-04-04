package com.kitm.penktadienio_darbas.dao;

import com.kitm.penktadienio_darbas.entity.NTObject;

import java.util.List;

public interface NtDAO {

    void save(NTObject ntObject);

    NTObject findById(Integer id);

    List<NTObject> findAll();

    List<NTObject> findByType(String typee);

    void update(NTObject ntObject);

    void delete(Integer id);

    void updateBest();
}
