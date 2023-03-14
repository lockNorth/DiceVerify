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
public class ReportForThaiFishPrawnCrab {
    @DateTimeFormat("yyyy-MM-dd")
    @ExcelProperty(index = 0,value = "start_date")
    private Date start_date;
    private Date end_date;
    @ExcelProperty(index = 4,value = "pointsPValue")
    private Double pointsPValue;
    @ExcelProperty(index = 5,value = "point_1")
    private Double point_1;
    @ExcelProperty(index = 6,value = "point_2")
    private Double point_2;
    @ExcelProperty(index = 7,value = "point_3")
    private Double point_3;
    @ExcelProperty(index = 8,value = "point_4")
    private Double point_4;
    @ExcelProperty(index = 9,value = "point_5")
    private Double point_5;
    @ExcelProperty(index = 10,value = "point_6")
    private Double point_6;
    @ExcelProperty(index = 11,value = "bigSmallPValue")
    private Double bigSmallPValue;
    @ExcelProperty(index = 12,value = "big")
    private Double big;
    @ExcelProperty(index = 13,value = "small")
    private Double small;
    @ExcelProperty(index = 1,value = "DiceName")
    private String DiceName;
    @ExcelProperty(index = 114,value = "SourceID")
    private String SourceID;
    @ExcelProperty(index = 2,value = "RESULTS")
    private String RESULTS;
    public ReportForThaiFishPrawnCrab() {
    }

    public ReportForThaiFishPrawnCrab(RequestJsonForm requestJsonForm) {
        List<DataThaiFishPrawnCrab> list = new ArrayList<>();
        for (DiceTestResult diceTestResult : requestJsonForm.getTxns()) {
            list.add(new DataThaiFishPrawnCrab(diceTestResult));
        }

        SourceID = requestJsonForm.getLocation();
        DiceName = requestJsonForm.getTxns().get(0).getDiceName();
        start_date = requestJsonForm.getTxns().get(0).getTrainingDate();
        end_date = requestJsonForm.getTxns().get(0).getTrainingDate();

        //計算骰子點數次數
        long[] pointsCount = MathUtils.getDataThaiFishPrawnCrabPointsCount(list);

        //計算P_value
        long pointsSum = MathUtils.getCountSum(pointsCount);
        point_1 = pointsCount[0] * 1.0 / pointsSum;
        point_2 = pointsCount[1] * 1.0 / pointsSum;
        point_3 = pointsCount[2] * 1.0 / pointsSum;
        point_4 = pointsCount[3] * 1.0 / pointsSum;
        point_5 = pointsCount[4] * 1.0 / pointsSum;
        point_6 = pointsCount[5] * 1.0 / pointsSum;
        pointsPValue = MathUtils.getSicboDicePointsPValue(pointsCount);

        //計算大小
        long[] bigSmallCount = MathUtils.getDataThaiFishPrawnCrabBigSmallCount(list);
        //計算大小P_value
        long bigSmallSum = MathUtils.getCountSum(bigSmallCount);
        big = bigSmallCount[0] * 1.0 / bigSmallSum;
        small = bigSmallCount[1] * 1.0 / bigSmallSum;
        bigSmallPValue = MathUtils.getDataThaiFishPrawnCrabBigSmallPValue(bigSmallCount);

        //通過檢定與否
        RESULTS = pointsPValue > 0.05 && bigSmallPValue > 0.05 ? "Qualified" : "Unqualified";

    }

}
