package com.wind.perfmonitor.Repository;

import com.wind.perfmonitor.dto.TransactionSummaryDTO;
import com.wind.perfmonitor.entity.TransactionMetric;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TransactionMetricRepository extends JpaRepository<TransactionMetric,Integer> {

    @Query("SELECT new com.wind.perfmonitor.dto.TransactionSummaryDTO(" +
            "tm.transactionName, " +
            "AVG(tm.tps), " +
            "AVG(tm.avgResponseTime), " +
            "AVG(tm.tp90), " +
            "AVG(tm.successRate)) " +
            "FROM TransactionMetric tm " +
            "WHERE tm.testResultId = :testResultId " +
            "GROUP BY tm.transactionName")
    List<TransactionSummaryDTO> getTransactionSummaryByTestResult(@Param("testResultId") int testResultId);
}
