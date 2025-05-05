package com.wind.perfmonitor.service;

import com.wind.perfmonitor.dto.PagedResultDTO;
import com.wind.perfmonitor.dto.TestResultDTO;
import java.util.List;

public interface ResultService {
    PagedResultDTO<TestResultDTO> getAllResults(int page, int size);
    List<TestResultDTO> getAllResults();
    TestResultDTO getResultById(Integer id); // 注意与Repository的Integer ID类型保持一致
}
