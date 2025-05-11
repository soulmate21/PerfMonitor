package com.wind.perfmonitor.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TestResultDTO {
    private Integer id;
    private String name;       // 与实体类保持一致
    private LocalDateTime startTime;
    private LocalDateTime endTime;  // 新增字段
    private Integer projectId;
    private String description;


    public TestResultDTO(Integer id,
                         String name,
                         LocalDateTime startTime,
                         LocalDateTime endTime,
                         Integer projectId,
                         String description) {
        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.projectId = projectId;
        this.description = description;
    }
}
