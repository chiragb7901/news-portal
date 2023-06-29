package com.s2p.dao;

import com.s2p.model.News;
import org.springframework.data.jpa.repository.JpaRepository;

public interface INewsRepository extends JpaRepository<News,Long> {
}
