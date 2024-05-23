package com.aiModel.ai_service.repository;

import com.aiModel.ai_service.model.Statistics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatisticsRepository extends JpaRepository<Statistics, Long> {
    Statistics findTopByOrderByIdDesc();
}
