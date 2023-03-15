package com.north.controller;

import com.alibaba.excel.EasyExcel;
import com.alibaba.fastjson2.JSONObject;
import com.north.bot.northBot001;
import com.north.mapper.DiceTestResultMapper;
import com.north.mapper.ReportForRedBlueSicboDiceMapper;
import com.north.mapper.ReportForSicboDiceMapper;
import com.north.mapper.ReportForThaiFishPrawnCrabMapper;
import com.north.pojo.*;
import com.north.utils.Utilities;
import jakarta.annotation.Resource;

import org.springframework.web.bind.annotation.*;
import org.telegram.telegrambots.meta.api.objects.InputFile;

import java.io.File;
import java.util.List;

@RestController
public class JsonController {
    @Resource
    DiceTestResultMapper diceTestResultMapper;
    @Resource
    ReportForSicboDiceMapper reportForSicboDiceMapper;
    @Resource
    ReportForRedBlueSicboDiceMapper reportForRedBlueSicboDiceMapper;
    @Resource
    ReportForThaiFishPrawnCrabMapper reportForThaiFishPrawnCrabMapper;


    @ResponseBody
    @RequestMapping(value = "trainingJsonInsert", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String getByJson(@RequestBody JSONObject jsonParam) {


        // 1.將訓練機器DataJson封裝成RequestJsonForm實踐類
        RequestJsonForm requestJsonForm = Utilities.getRequestJsonForm(jsonParam);

        // 2.將DiceTestResult實踐類insert到DB
        this.addList(requestJsonForm.getTxns());

        // 3.取得requestJsonForm的檢測報告
        Object report = Utilities.getReport(requestJsonForm);

        // 4.宣告報告類型
        String reportType = requestJsonForm.getTxns().get(0).getGameType();

        // 5.將檢測報告insert到對應的資料庫
        this.insertReport(reportType, report);

        // 6.產該彩種select結果excel
        this.getExcelReport(reportType);

        // 7.發送excel至telegram聊天室
        this.sendExcelViaTelegramBot(reportType, -930392618L);


        return getResponse(report);
    }


    // ----------------------method----------------------------

    // 將DiceTestResultList整筆insert到db
    public void addList(List<DiceTestResult> diceTestResultList) {
        for (DiceTestResult diceTestResult : diceTestResultList) {
            diceTestResultMapper.add(diceTestResult);
        }
    }

    //將檢測報告insert到對應db
    public <T> void insertReport(String reportType, T report) {
        switch (reportType) {
            case "RedBlueSicboDice":
                ReportForRedBlueSicboDice reportForRedBlueSicboDice = (ReportForRedBlueSicboDice) report;
                reportForRedBlueSicboDiceMapper.add(reportForRedBlueSicboDice);
//                System.out.println(reportForRedBlueSicboDice);
                break;
            case "SicboDice":
                ReportForSicboDice reportForSicboDice = (ReportForSicboDice) report;
                reportForSicboDiceMapper.add(reportForSicboDice);
//                System.out.println(reportForSicboDice);
                break;
            case "ThaiFishPrawnCrab":
                ReportForThaiFishPrawnCrab reportForThaiFishPrawnCrab = (ReportForThaiFishPrawnCrab) report;
                reportForThaiFishPrawnCrabMapper.add(reportForThaiFishPrawnCrab);
//                System.out.println(reportForThaiFishPrawnCrab);
                break;
        }
    }

    //產該彩種select結果excel by reportType
    public void getExcelReport(String reportType) {
        String fileName = null;
        switch (reportType) {
            case "RedBlueSicboDice":
                fileName = "/Users/lixiang/Documents/IDEA/IdeaProjects/DiceVerify/src/main/resources/output/ReportForRedBlueSicboDice.xlsx";
                List<ReportForRedBlueSicboDice> reportForRedBlueSicboDiceList = reportForRedBlueSicboDiceMapper.selectAll();
                EasyExcel.write(fileName, ReportForRedBlueSicboDice.class).sheet("report").doWrite(reportForRedBlueSicboDiceList);
                break;
            case "SicboDice":
                fileName = "/Users/lixiang/Documents/IDEA/IdeaProjects/DiceVerify/src/main/resources/output/ReportForSicboDice.xlsx";
                List<ReportForSicboDice> reportForSicboDiceList = reportForSicboDiceMapper.selectAll();
                EasyExcel.write(fileName, ReportForSicboDice.class).sheet("report").doWrite(reportForSicboDiceList);
                break;
            case "ThaiFishPrawnCrab":
                fileName = "/Users/lixiang/Documents/IDEA/IdeaProjects/DiceVerify/src/main/resources/output/ReportForThaiFishPrawnCrab.xlsx";
                List<ReportForThaiFishPrawnCrab> reportForThaiFishPrawnCrabList = reportForThaiFishPrawnCrabMapper.selectAll();
                EasyExcel.write(fileName, ReportForThaiFishPrawnCrab.class).sheet("report").doWrite(reportForThaiFishPrawnCrabList);
                break;
        }
    }

    //發送excel到telegram聊天室
    public void sendExcelViaTelegramBot(String reportType, Long chatId) {
        northBot001 northBot001 = new northBot001();
        String pathName = null;
        switch (reportType) {
            case "RedBlueSicboDice":
                pathName = "/Users/lixiang/Documents/IDEA/IdeaProjects/DiceVerify/src/main/resources/output/ReportForRedBlueSicboDice.xlsx";
                break;
            case "SicboDice":
                pathName = "/Users/lixiang/Documents/IDEA/IdeaProjects/DiceVerify/src/main/resources/output/ReportForSicboDice.xlsx";
                break;
            case "ThaiFishPrawnCrab":
                pathName = "/Users/lixiang/Documents/IDEA/IdeaProjects/DiceVerify/src/main/resources/output/ReportForThaiFishPrawnCrab.xlsx";
                break;
        }
        File file = new File(pathName);
        InputFile inputFile = new InputFile(file);
        northBot001.sentExcel(inputFile, chatId);
    }

    public String getResponse(Object report) {
        JSONObject result = new JSONObject();
        result.put("msg", "success");
        result.put("report", report);
        return result.toJSONString();
    }
}
