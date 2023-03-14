package com.north.mapper;

import com.north.pojo.ReportForRedBlueSicboDice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportForRedBlueSicboDiceMapper {
    // 新增單筆資料
    void add(ReportForRedBlueSicboDice reportForRedBlueSicboDice);   // 返回所有資料
    List<ReportForRedBlueSicboDice> selectAll();
}
