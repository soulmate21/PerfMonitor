package com.wind.perfmonitor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;


@Setter
@Getter
public class ApiResponse {
    private int code;
    private String status;
    private long timestamp;
    private Map<String, Object> data;

}
