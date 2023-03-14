package com.north.pojo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.north.utils.MathUtils;
import lombok.Data;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Data
@ExcelIgnoreUnannotated
@ColumnWidth(25)
public class ReportForRedBlueSicboDice {
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(index = 0, value = "start_date")
    private Date start_date;
    private Date end_date;
    @ExcelProperty(index = 4, value = "redPointsPValue")
    private Double redPointsPValue;
    @ExcelProperty(index = 5, value = "redPoint_1")
    private Double redPoint_1;
    @ExcelProperty(index = 6, value = "redPoint_2")
    private Double redPoint_2;
    @ExcelProperty(index = 7, value = "redPoint_3")
    private Double redPoint_3;
    @ExcelProperty(index = 8, value = "redPoint_4")
    private Double redPoint_4;
    @ExcelProperty(index = 9, value = "redPoint_5")
    private Double redPoint_5;
    @ExcelProperty(index = 10, value = "redPoint_6")
    private Double redPoint_6;
    @ExcelProperty(index = 11, value = "redBigSmallPValue")
    private Double redBigSmallPValue;
    @ExcelProperty(index = 12, value = "redBig")
    private Double redBig;
    @ExcelProperty(index = 13, value = "redSmall")
    private Double redSmall;
    @ExcelProperty(index = 14, value = "bluePointsPValue")
    private Double bluePointsPValue;
    @ExcelProperty(index = 15, value = "bluePoint_1")
    private Double bluePoint_1;
    @ExcelProperty(index = 16, value = "bluePoint_2")
    private Double bluePoint_2;
    @ExcelProperty(index = 17, value = "bluePoint_3")
    private Double bluePoint_3;
    @ExcelProperty(index = 18, value = "bluePoint_4")
    private Double bluePoint_4;
    @ExcelProperty(index = 19, value = "bluePoint_5")
    private Double bluePoint_5;
    @ExcelProperty(index = 20, value = "bluePoint_6")
    private Double bluePoint_6;
    @ExcelProperty(index = 21, value = "blueBigSmallPValue")
    private Double blueBigSmallPValue;
    @ExcelProperty(index = 22, value = "blueBig")
    private Double blueBig;
    @ExcelProperty(index = 23, value = "blueSmall")
    private Double blueSmall;
    @ExcelProperty(index = 1, value = "DiceName")
    private String DiceName;
    @ExcelProperty(index = 24, value = "SourceID")
    private String SourceID;
    @ExcelProperty(index = 2, value = "RESULTS")
    private String RESULTS;

    public ReportForRedBlueSicboDice() {
    }

    public ReportForRedBlueSicboDice(RequestJsonForm requestJsonForm) {
        List<DataRedBlueSicboDice> list = new ArrayList<>();
        for (DiceTestResult diceTestResult : requestJsonForm.getTxns()) {
            list.add(new DataRedBlueSicboDice(diceTestResult));
        }

        SourceID = requestJsonForm.getLocation();
        DiceName = requestJsonForm.getTxns().get(0).getDiceName();
        start_date = requestJsonForm.getTxns().get(0).getTrainingDate();
        end_date = requestJsonForm.getTxns().get(0).getTrainingDate();

        //-------------------------------------------------------------------------------------------------------------
        //計算紅骰點數
        //統計骰子點數次數
        long[] redPointsCount = MathUtils.getRedBlueSicboDiceRedPointsCount(list);
        //計算P_value
        long redPointsSum = MathUtils.getCountSum(redPointsCount);
        redPoint_1 = redPointsCount[0] * 1.0 / redPointsSum;
        redPoint_2 = redPointsCount[1] * 1.0 / redPointsSum;
        redPoint_3 = redPointsCount[2] * 1.0 / redPointsSum;
        redPoint_4 = redPointsCount[3] * 1.0 / redPointsSum;
        redPoint_5 = redPointsCount[4] * 1.0 / redPointsSum;
        redPoint_6 = redPointsCount[5] * 1.0 / redPointsSum;
        redPointsPValue = MathUtils.getRedBlueSicboDiceRedPointsPValue(redPointsCount);
        //-------------------------------------------------------------------------------------------------------------
        //計算藍骰點數
        long[] bluePointsCount = MathUtils.getRedBlueSicboDiceBluePointsCount(list);
        //計算P_value
        long bluePointsSum = MathUtils.getCountSum(redPointsCount);
        bluePoint_1 = bluePointsCount[0] * 1.0 / bluePointsSum;
        bluePoint_2 = bluePointsCount[1] * 1.0 / bluePointsSum;
        bluePoint_3 = bluePointsCount[2] * 1.0 / bluePointsSum;
        bluePoint_4 = bluePointsCount[3] * 1.0 / bluePointsSum;
        bluePoint_5 = bluePointsCount[4] * 1.0 / bluePointsSum;
        bluePoint_6 = bluePointsCount[5] * 1.0 / bluePointsSum;
        bluePointsPValue = MathUtils.getRedBlueSicboDiceBluePointsPValue(bluePointsCount);
        //-------------------------------------------------------------------------------------------------------------
        //計算紅骰大小
        long[] redBigSmallCount = MathUtils.getRedBlueSicboDiceRedBigSmallCount(list);
        //計算大小P_value
        long redBigSmallSum = MathUtils.getCountSum(redBigSmallCount);
        redBig = redBigSmallCount[0] * 1.0 / redBigSmallSum;
        redSmall = redBigSmallCount[1] * 1.0 / redBigSmallSum;
        redBigSmallPValue = MathUtils.getRedBlueSicboDiceRedBigSmallPVaule(redBigSmallCount);
        //-------------------------------------------------------------------------------------------------------------
        //計算藍骰大小
        long[] blueBigSmallCount = MathUtils.getRedBlueSicboDiceBlueBigSmallCount(list);
        //計算大小P_value
        long blueBigSmallSum = MathUtils.getCountSum(blueBigSmallCount);
        blueBig = blueBigSmallCount[0] * 1.0 / blueBigSmallSum;
        blueSmall = blueBigSmallCount[1] * 1.0 / blueBigSmallSum;
        blueBigSmallPValue = MathUtils.getRedBlueSicboDiceBlueBigSmallPVaule(blueBigSmallCount);

        //通過檢定與否
        RESULTS = redPointsPValue > 0.05 && redBigSmallPValue > 0.05 && bluePointsPValue > 0.05 && blueBigSmallPValue > 0.05 ? "Qualified" : "Unqualified";
    }

}
