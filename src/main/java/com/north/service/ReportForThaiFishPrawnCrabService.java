package com.north.service;

import com.north.pojo.ReportForThaiFishPrawnCrab;

import java.util.List;

public interface ReportForThaiFishPrawnCrabService {
    // 新增資料
    void add(ReportForThaiFishPrawnCrab reportForThaiFishPrawnCrab);
    // 返回所有資料
    List<ReportForThaiFishPrawnCrab> selectAll();

}
