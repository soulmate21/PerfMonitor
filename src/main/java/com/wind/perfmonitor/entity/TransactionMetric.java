package com.wind.perfmonitor.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;

import java.time.Instant;
import java.util.Map;

@Data
@Entity
@Table(name = "transaction_metrics")
public class TransactionMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "test_result_id", nullable = false)
    private Integer testResultId;

    @Column(name = "project_id", nullable = false)
    private String projectId;

    @Column(name = "transaction_name", nullable = false)
    private String transactionName;

    @Column(name = "timestamp", nullable = false)
    private Instant timestamp;

    @Column(name = "tps")
    private Float tps;

    @Column(name = "avg_response_time")
    private Float avgResponseTime;

    @Column(name = "tp90")
    private Float tp90;

    @Column(name = "success_rate")
    private Float successRate;

    @Column(name = "request_count")
    private Integer requestCount;

    @Column(name = "error_count")
    private Integer errorCount;

    @Column(name = "status_code_dist")
    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> statusCodeDist;

}