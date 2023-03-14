package com.north.utils;

import com.north.pojo.DataRedBlueSicboDice;
import com.north.pojo.DataSicbo;
import com.north.pojo.DataThaiFishPrawnCrab;
import org.apache.commons.math3.stat.inference.ChiSquareTest;

import java.util.List;

public class MathUtils {
    //骰寶點數
    public static long[] getSicboDicePointsCount(List<DataSicbo> dataSicboList) {
        long[] pointsCount = {0, 0, 0, 0, 0, 0};
        for (DataSicbo dataSicbo : dataSicboList) {
            for (int i = 0; i < 6; i++) {
                if (dataSicbo.getDice1() == (i + 1)) {
                    pointsCount[i]++;
                }
                if (dataSicbo.getDice2() == (i + 1)) {
                    pointsCount[i]++;
                }
                if (dataSicbo.getDice3() == (i + 1)) {
                    pointsCount[i]++;
                }
            }
        }
        return pointsCount;
    }

    //骰寶點數Ｐ值
    public static double getSicboDicePointsPValue(long[] pointsCount) {
        double avg = getCountAvg(pointsCount);
        double[] Expected = {avg, avg, avg, avg, avg, avg};
        double PValue = new ChiSquareTest().chiSquareTest(Expected, pointsCount);
        return PValue;
    }

    //骰寶大小

    public static long[] getSicboDiceBigSmallCount(List<DataSicbo> dataSicboList) {
        long[] bigSmallCount = {0, 0};
        for (DataSicbo dataSicbo : dataSicboList) {
            //計算大小次數
            int sum = dataSicbo.getDice1() + dataSicbo.getDice2() + dataSicbo.getDice3();
            if (sum > 10.5) {
                bigSmallCount[0]++;
            } else {
                bigSmallCount[1]++;
            }
        }
        return bigSmallCount;
    }

    //骰寶大小Ｐ值
    public static double getSicboDiceBigSmallPValue(long[] bigSmallCount) {
        double avg = getCountAvg(bigSmallCount);
        double[] Expected = {avg, avg};
        double PValue = new ChiSquareTest().chiSquareTest(Expected, bigSmallCount);
        return PValue;
    }

    //-------------------------------------------------------------------------------------------------------------------------
    //紅藍紅點數
    public static long[] getRedBlueSicboDiceRedPointsCount(List<DataRedBlueSicboDice> dataRedBlueSicboDiceList) {
        long[] redPointsCount = {0, 0, 0, 0, 0, 0};
        for (DataRedBlueSicboDice dataRedBlueSicboDice : dataRedBlueSicboDiceList) {
            //統計骰子點數次數
            for (int i = 0; i < 6; i++) {
                if (dataRedBlueSicboDice.getDice1() == (i + 1)) {
                    redPointsCount[i]++;
                }
            }
        }
        return redPointsCount;
    }

    //紅藍紅點數Ｐ值
    public static double getRedBlueSicboDiceRedPointsPValue(long[] redBigSmallCount) {
        double avg = getCountAvg(redBigSmallCount);
        double[] pointsExpected = {avg, avg, avg, avg, avg, avg};
        double PValue = new ChiSquareTest().chiSquareTest(pointsExpected, redBigSmallCount);
        return PValue;

    }

    //紅藍藍點數
    public static long[] getRedBlueSicboDiceBluePointsCount(List<DataRedBlueSicboDice> dataRedBlueSicboDiceList) {
        long[] bluePointsCount = {0, 0, 0, 0, 0, 0};
        for (DataRedBlueSicboDice dataRedBlueSicboDice : dataRedBlueSicboDiceList) {
            for (int i = 0; i < 6; i++) {
                if (dataRedBlueSicboDice.getDice2() == (i + 1)) {
                    bluePointsCount[i]++;
                }
            }
        }
        return bluePointsCount;
    }

    //紅藍藍點數Ｐ值
    public static double getRedBlueSicboDiceBluePointsPValue(long[] blueBigSmallCount) {
        double avg = getCountAvg(blueBigSmallCount);
        double[] pointsExpected = {avg, avg, avg, avg, avg, avg};
        double PValue = new ChiSquareTest().chiSquareTest(pointsExpected, blueBigSmallCount);
        return PValue;

    }

    //紅藍紅大小
    public static long[] getRedBlueSicboDiceRedBigSmallCount(List<DataRedBlueSicboDice> dataRedBlueSicboDiceList) {
        long[] redBigSmallCount = {0, 0};
        for (DataRedBlueSicboDice dataRedBlueSicboDice : dataRedBlueSicboDiceList) {
            int sum = dataRedBlueSicboDice.getDice1();
            if (sum > 3.5) {
                redBigSmallCount[0]++;
            } else {
                redBigSmallCount[1]++;
            }
        }
        return redBigSmallCount;
    }

    //紅藍紅大小P值
    public static double getRedBlueSicboDiceRedBigSmallPVaule(long[] redBigSmallCount) {
        double avg = getCountAvg(redBigSmallCount);
        double[] Expected = {avg, avg};
        double PValue = new ChiSquareTest().chiSquareTest(Expected, redBigSmallCount);
        return PValue;
    }

    //紅藍藍大小
    public static long[] getRedBlueSicboDiceBlueBigSmallCount(List<DataRedBlueSicboDice> dataRedBlueSicboDiceList) {
        long[] blueBigSmallCount = {0, 0};
        for (DataRedBlueSicboDice dataRedBlueSicboDice : dataRedBlueSicboDiceList) {
            int sum = dataRedBlueSicboDice.getDice2();
            if (sum > 3.5) {
                blueBigSmallCount[0]++;
            } else {
                blueBigSmallCount[1]++;
            }
        }
        return blueBigSmallCount;
    }

    //紅藍紅大小P值
    public static double getRedBlueSicboDiceBlueBigSmallPVaule(long[] blueBigSmallCount) {
        double avg = getCountAvg(blueBigSmallCount);
        double[] Expected = {avg, avg};
        double PValue = new ChiSquareTest().chiSquareTest(Expected, blueBigSmallCount);
        return PValue;
    }

    //-------------------------------------------------------------------------------------------------------------------------
    //魚蝦蟹點數
    public static long[] getDataThaiFishPrawnCrabPointsCount(List<DataThaiFishPrawnCrab> dataThaiFishPrawnCrabList) {
        long[] pointsCount = {0, 0, 0, 0, 0, 0};
        for (DataThaiFishPrawnCrab dataThaiFishPrawnCrab : dataThaiFishPrawnCrabList) {
            for (int i = 0; i < 6; i++) {
                if (dataThaiFishPrawnCrab.getDice1() == (i + 1)) {
                    pointsCount[i]++;
                }
                if (dataThaiFishPrawnCrab.getDice2() == (i + 1)) {
                    pointsCount[i]++;
                }
                if (dataThaiFishPrawnCrab.getDice3() == (i + 1)) {
                    pointsCount[i]++;
                }
            }
        }
        return pointsCount;
    }

    //魚蝦蟹點數Ｐ值
    public static double getDataThaiFishPrawnCrabPointsPValue(long[] pointsCount) {
        double avg = getCountAvg(pointsCount);
        double[] Expected = {avg, avg, avg, avg, avg, avg};
        double PValue = new ChiSquareTest().chiSquareTest(Expected, pointsCount);
        return PValue;
    }

    //魚蝦蟹大小
    public static long[] getDataThaiFishPrawnCrabBigSmallCount(List<DataThaiFishPrawnCrab> dataThaiFishPrawnCrabList) {
        long[] bigSmallCount = {0, 0};
        for(DataThaiFishPrawnCrab dataThaiFishPrawnCrab:dataThaiFishPrawnCrabList){
            //計算大小次數
            int sum = dataThaiFishPrawnCrab.getDice1() + dataThaiFishPrawnCrab.getDice2() + dataThaiFishPrawnCrab.getDice3();
            if (sum > 10.5) {
                bigSmallCount[0]++;
            } else {
                bigSmallCount[1]++;
            }
        }
        return bigSmallCount;
    }

    //魚蝦蟹大小Ｐ值
    public static double getDataThaiFishPrawnCrabBigSmallPValue(long[] bigSmallCount) {
        double avg = getCountAvg(bigSmallCount);
        double[] Expected = {avg, avg};
        double PValue = new ChiSquareTest().chiSquareTest(Expected, bigSmallCount);
        return PValue;
    }

    //-------------------------------------------------------------------------------------------------------------------------
    //計算count的sum
    public static long getCountSum(long[] count) {
        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum = sum + count[i];
        }
        return sum;
    }

    //計算count的avg
    public static double getCountAvg(long[] count) {
        long sum = 0;
        for (int i = 0; i < count.length; i++) {
            sum = sum + count[i];
        }
        return sum * 1.0 / count.length;
    }
}
