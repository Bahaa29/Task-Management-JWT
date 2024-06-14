package com.example.bankMasrTask.repository;

import com.example.bankMasrTask.model.History;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HistoryRepository extends JpaRepository<History, Long> {
}