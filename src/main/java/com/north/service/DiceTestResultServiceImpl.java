package com.north.service;

import com.north.mapper.DiceTestResultMapper;
import com.north.pojo.DiceTestResult;
import com.north.utils.MysqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;



@Service
public class DiceTestResultServiceImpl implements DiceTestResultService {

    @Override
    public void add(DiceTestResult diceTestResult) {
        SqlSessionFactory factory = MysqlSessionFactory.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        DiceTestResultMapper mapper = session.getMapper(DiceTestResultMapper.class);
        mapper.add(diceTestResult);
        session.commit();
        session.close();
    }
}
