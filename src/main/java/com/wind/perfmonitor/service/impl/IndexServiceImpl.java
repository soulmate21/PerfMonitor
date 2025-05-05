package com.wind.perfmonitor.service.impl;

import com.wind.perfmonitor.service.IndexService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

@Service
public class IndexServiceImpl implements IndexService {


    @Override
    public Map<String, Object> getIndexData() {


        Map<String, Object> data = new HashMap<>();
        //业务逻辑
        Map<String,String> general =new HashMap<>();
        general.put("用例数","25");
        general.put("通过率","94%");
        general.put("执行时间","120s");
        general.put("接入项目","10");

        LinkedList<String[]> list = new LinkedList<>();
        //处理时间格式
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        list.add(new String[]{"用户登录测试", "认证服务", "通过","120s", currentDateTime.format(formatter)});
        list.add(new String[]{"支付流程测试", "支付网关", "失败","15s",currentDateTime.format(formatter)});
        list.add(new String[]{"数据同步测试", "数据中心", "通过","1800s",currentDateTime.format(formatter)});
        list.add(new String[]{"API响应测试", "API网关", "进行中","",currentDateTime.format(formatter)});
        data.put("general",general);
        data.put("list",list);

        return data;
    }
}
