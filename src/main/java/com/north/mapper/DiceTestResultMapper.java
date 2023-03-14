package com.north.mapper;

import com.north.pojo.DiceTestResult;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper  //告訴springboot這是一個mybatis的mapper類
@Repository  // 將mapper交由spring容器管理
public interface DiceTestResultMapper {
    // 新增單筆資料
    void add(DiceTestResult diceTestResult);
}
