package com.north.mapper;

import com.north.pojo.ReportForThaiFishPrawnCrab;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ReportForThaiFishPrawnCrabMapper {
    // 新增單筆資料
    void add(ReportForThaiFishPrawnCrab reportForThaiFishPrawnCrab);
    // 返回所有資料
    List<ReportForThaiFishPrawnCrab> selectAll();
}
