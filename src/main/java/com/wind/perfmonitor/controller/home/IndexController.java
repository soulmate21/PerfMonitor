package com.wind.perfmonitor.controller.home;

import com.wind.perfmonitor.dto.ApiResponse;
import com.wind.perfmonitor.service.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class IndexController {

    @Autowired
    private  IndexService indexService;

    @GetMapping("/")
    public HashMap<String, String> welcome() {
        HashMap<String,String> data = new HashMap<>();
        data.put("name","Welcome to PerfMonitor");
        return data;
    }

    @GetMapping("/index")
    public ResponseEntity<ApiResponse> home() {
        ApiResponse response = new ApiResponse();
        response.setCode(200);
        response.setStatus("success");
        response.setTimestamp(System.currentTimeMillis());
        response.setData(indexService.getIndexData());
        return ResponseEntity.ok(response);
    }
}
