package com.wind.perfmonitor.dto;


import lombok.Data;

@Data
public class TransactionSummaryDTO {
    private String transactionName;
    private double avgTps;
    private double avgResponseTime;
    private double avgTp90;
    private double avgSuccessRate;

    public TransactionSummaryDTO(String transactionName, double avgTps, double avgResponseTime, double avgTp90, double avgSuccessRate) {
        this.transactionName = transactionName;
        this.avgTps = avgTps;
        this.avgResponseTime = avgResponseTime;
        this.avgTp90 = avgTp90;
        this.avgSuccessRate = avgSuccessRate;
    }


}

