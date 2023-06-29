package com.s2p.dao;

import com.s2p.model.Section;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISectionRepository extends JpaRepository<Section,Long> {
}
