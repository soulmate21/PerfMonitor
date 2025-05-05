package com.wind.perfmonitor.controller.result;


import com.wind.perfmonitor.dto.PagedResultDTO;
import com.wind.perfmonitor.dto.TestResultDTO;
import com.wind.perfmonitor.service.ResultService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ResultController {

    private final ResultService resultService;

    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    @GetMapping("/results")
    public PagedResultDTO<TestResultDTO> getAllResults(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size) {
        return resultService.getAllResults(page, size);
    }
}
