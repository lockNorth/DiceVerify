package com.north.service;

import com.north.mapper.ReportForRedBlueSicboDiceMapper;
import com.north.pojo.ReportForRedBlueSicboDice;
import com.north.utils.MysqlSessionFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportForRedBlueSicboDiceServiceImpl implements ReportForRedBlueSicboDiceService {
    @Override
    public void add(ReportForRedBlueSicboDice reportForRedBlueSicboDice) {
        SqlSessionFactory factory = MysqlSessionFactory.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        ReportForRedBlueSicboDiceMapper mapper = session.getMapper(ReportForRedBlueSicboDiceMapper.class);
        mapper.add(reportForRedBlueSicboDice);
        session.commit();
        session.close();
    }

    @Override
    public List<ReportForRedBlueSicboDice> selectAll() {
        SqlSessionFactory factory = MysqlSessionFactory.getSqlSessionFactory();
        SqlSession session = factory.openSession();
        ReportForRedBlueSicboDiceMapper mapper = session.getMapper(ReportForRedBlueSicboDiceMapper.class);
        List<ReportForRedBlueSicboDice> reportForRedBlueSicboDiceList = mapper.selectAll();
        session.close();

        return reportForRedBlueSicboDiceList;    }
}
