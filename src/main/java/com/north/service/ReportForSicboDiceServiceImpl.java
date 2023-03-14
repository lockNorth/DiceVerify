package com.north.service;

import com.north.mapper.ReportForSicboDiceMapper;
import com.north.pojo.ReportForSicboDice;
import com.north.utils.MysqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportForSicboDiceServiceImpl implements ReportForSicboDiceService{

    @Override
    public void add(ReportForSicboDice reportForSicboDice) {
        SqlSessionFactory factory = MysqlSessionFactory.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        ReportForSicboDiceMapper mapper = session.getMapper(ReportForSicboDiceMapper.class);
        mapper.add(reportForSicboDice);
        session.commit();
        session.close();
    }

    @Override
    public List<ReportForSicboDice> selectAll() {
        SqlSessionFactory factory = MysqlSessionFactory.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        ReportForSicboDiceMapper mapper = session.getMapper(ReportForSicboDiceMapper.class);
        List<ReportForSicboDice> reportForSicboDiceList = mapper.selectAll();
        session.close();

        return reportForSicboDiceList;
    }
}
