package com.wind.perfmonitor.service;

import com.wind.perfmonitor.dto.TransactionSummaryDTO;

import java.util.List;

public interface TransactionMetricService {

    public List<TransactionSummaryDTO> getTransactionSummaryByTestResult(int testResultId);
}
