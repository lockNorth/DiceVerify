package com.north.service;

import com.north.pojo.ReportForSicboDice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReportForSicboDiceService {
    // 新增資料
    void add(ReportForSicboDice reportForSicboDice);
    // 返回所有資料
    List<ReportForSicboDice> selectAll();
}
