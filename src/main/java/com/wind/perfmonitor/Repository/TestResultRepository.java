package com.wind.perfmonitor.Repository;

import com.wind.perfmonitor.entity.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestResultRepository extends JpaRepository<TestResult,Integer> {
}
