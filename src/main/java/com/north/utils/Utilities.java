package com.north.utils;

import com.alibaba.fastjson2.JSONObject;
import com.north.mapper.DiceTestResultMapper;
import com.north.mapper.ReportForRedBlueSicboDiceMapper;
import com.north.mapper.ReportForSicboDiceMapper;
import com.north.mapper.ReportForThaiFishPrawnCrabMapper;
import com.north.pojo.*;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public class Utilities {

    public static RequestJsonForm getRequestJsonForm(JSONObject jsonParam) {
        String str = jsonParam.toString()
                .replaceAll("RedDice", "Dice1")
                .replaceAll("BlueDice", "Dice2")
                .replace('_', '-');
        return JSONObject.parseObject(str, RequestJsonForm.class);
    }

    public static <E> E getReport(RequestJsonForm requestJsonForm) {
        switch (requestJsonForm.getTxns().get(0).getGameType()) {
            case "RedBlueSicboDice":
                ReportForRedBlueSicboDice reportForRedBlueSicboDice = new ReportForRedBlueSicboDice(requestJsonForm);
                return (E) reportForRedBlueSicboDice;
            case "SicboDice":
                ReportForSicboDice reportForSicboDice = new ReportForSicboDice(requestJsonForm);
                return (E) reportForSicboDice;
            case "ThaiFishPrawnCrab":
                ReportForThaiFishPrawnCrab reportForThaiFishPrawnCrab = new ReportForThaiFishPrawnCrab(requestJsonForm);
                return (E) reportForThaiFishPrawnCrab;
        }
        return null;
    }

}
