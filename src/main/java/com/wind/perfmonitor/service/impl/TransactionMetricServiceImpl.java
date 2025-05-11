package com.wind.perfmonitor.service.impl;

import com.wind.perfmonitor.Repository.TransactionMetricRepository;
import com.wind.perfmonitor.dto.TransactionSummaryDTO;
import com.wind.perfmonitor.entity.TransactionMetric;
import com.wind.perfmonitor.service.TransactionMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionMetricServiceImpl implements TransactionMetricService {

    @Autowired
    private TransactionMetricRepository transactionMetricRepository;

    @Override
    public List<TransactionSummaryDTO> getTransactionSummaryByTestResult(int testResultId) {
        return transactionMetricRepository.getTransactionSummaryByTestResult(testResultId);
    }
}
