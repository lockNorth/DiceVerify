package com.north.mapper;

import com.north.pojo.ReportForSicboDice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportForSicboDiceMapper {
    // 新增單筆資料
    void add(ReportForSicboDice reportForSicboDice);
    // 返回所有資料
    List<ReportForSicboDice> selectAll();
}
