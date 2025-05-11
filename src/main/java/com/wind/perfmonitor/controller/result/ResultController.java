package com.wind.perfmonitor.controller.result;


import com.wind.perfmonitor.dto.PagedResultDTO;
import com.wind.perfmonitor.dto.TestResultDTO;
import com.wind.perfmonitor.dto.TransactionSummaryDTO;
import com.wind.perfmonitor.service.ResultService;
import com.wind.perfmonitor.service.TransactionMetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/results")
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/")
    public PagedResultDTO<TestResultDTO> getAllResults(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return resultService.getAllResults(page, size);
    }

    @Autowired
    private TransactionMetricService transactionMetricService;

    @GetMapping("/summary/{testResultId}")
    public List<TransactionSummaryDTO> getSummary(@PathVariable int testResultId) {
        return transactionMetricService.getTransactionSummaryByTestResult(testResultId);
    }

}
