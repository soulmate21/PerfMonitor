package com.wind.perfmonitor.dto;

import lombok.Data;

import java.util.List;

@Data
public class PagedResultDTO<T> {
    private List<T> content;
    private int currentPage;
    private int totalPages;
    private long totalItems;

    public PagedResultDTO(List<T> content, int currentPage, int totalPages, long totalItems) {
        this.content = content;
        this.currentPage = currentPage;
        this.totalPages = totalPages;
        this.totalItems = totalItems;
    }
}
