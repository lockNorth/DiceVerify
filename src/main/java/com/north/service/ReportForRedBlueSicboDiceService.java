package com.north.service;

import com.north.mapper.ReportForRedBlueSicboDiceMapper;
import com.north.pojo.ReportForRedBlueSicboDice;
import com.north.pojo.ReportForSicboDice;

import java.util.List;

public interface ReportForRedBlueSicboDiceService {
    // 新增資料
    void add(ReportForRedBlueSicboDice reportForRedBlueSicboDice);   // 返回所有資料
    List<ReportForRedBlueSicboDice> selectAll();
}
