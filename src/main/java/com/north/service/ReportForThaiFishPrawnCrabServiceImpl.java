package com.north.service;

import com.north.mapper.ReportForThaiFishPrawnCrabMapper;
import com.north.pojo.ReportForThaiFishPrawnCrab;
import com.north.utils.MysqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportForThaiFishPrawnCrabServiceImpl implements ReportForThaiFishPrawnCrabService {
    @Override
    public void add(ReportForThaiFishPrawnCrab reportForThaiFishPrawnCrab) {
        SqlSessionFactory factory = MysqlSessionFactory.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        ReportForThaiFishPrawnCrabMapper mapper = session.getMapper(ReportForThaiFishPrawnCrabMapper.class);
        mapper.add(reportForThaiFishPrawnCrab);
        session.commit();
        session.close();
    }

    @Override
    public List<ReportForThaiFishPrawnCrab> selectAll() {
        SqlSessionFactory factory = MysqlSessionFactory.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        ReportForThaiFishPrawnCrabMapper mapper = session.getMapper(ReportForThaiFishPrawnCrabMapper.class);
        List<ReportForThaiFishPrawnCrab> reportForThaiFishPrawnCrabList = mapper.selectAll();
        session.close();
        return reportForThaiFishPrawnCrabList;
    }
}
