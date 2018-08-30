package com.mexpedition.dao;


import com.mexpedition.model.Expedition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface ExpeditionDao extends JpaRepository<Expedition, Integer>{

    Optional<Expedition> findByIdCommandeLike(int idCommande);
}
