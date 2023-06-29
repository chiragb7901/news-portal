package com.s2p.dao;

import com.s2p.model.Tutorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITutorialDAO extends JpaRepository<Tutorial,Long> {
}
