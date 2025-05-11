package com.wind.perfmonitor.service.impl;

import com.wind.perfmonitor.Repository.TestResultRepository;
import com.wind.perfmonitor.dto.PagedResultDTO;
import com.wind.perfmonitor.dto.TestResultDTO;
import com.wind.perfmonitor.entity.TestResult;
import com.wind.perfmonitor.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private TestResultRepository repository;

    @Override
    public PagedResultDTO<TestResultDTO> getAllResults(int page, int size) {
        Pageable pageable = PageRequest.of(page - 1, size); // 页码从0开始
        Page<TestResult> resultPage = repository.findAll(pageable);

        List<TestResultDTO> dtos = resultPage.getContent().stream()
                .map(this::convertToDTO)
                .toList();

        return new PagedResultDTO<>(
                dtos,
                resultPage.getNumber() + 1, // 返回前端页码从1开始
                resultPage.getTotalPages(),
                resultPage.getTotalElements()
        );
    }

    // to do 暂时弃用了，后续不需要可以删掉
    @Override
    public List<TestResultDTO> getAllResults() {
        return repository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    // to do 暂时弃用了，后续不需要可以删掉
    @Override
    public TestResultDTO getResultById(Integer id) {
        return repository.findById(id)
                .map(this::convertToDTO)
                .orElseThrow(() -> new RuntimeException("找不到ID为 " + id + "的测试结果"));
    }

    private TestResultDTO convertToDTO(TestResult entity) {
        return new TestResultDTO(
                entity.getId(),
                entity.getName(),
                entity.getStartTime(),
                entity.getEndTime(),
                entity.getProjectId(),
                entity.getDescription()
        );
    }
}
