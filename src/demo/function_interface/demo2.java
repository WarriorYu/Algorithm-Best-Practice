package demo.function_interface;

import java.awt.image.RescaleOp;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashSet;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/7/16
 * Describe :
 */
public class demo2 {
    public static void main(String[] args) {
//        String s = getFixedBigDecimal("99.98", 0).toString();
//        Double a = new Double("1.92");
//        String format = String.format("%.2f", a);
//        Double total = a*7;
       /* Double a = new Double("9");
        Double b = new Double("2");
        int c = 9;
        String mul = mul(a.toString(), Integer.toString(2));
        System.out.println(mul);*/


        //21.978
       /* Double a = new Double("2.22");
        int b = 3;
        for (int i = 0; i < 20; i++) {
            System.out.println(a * b);
        }*/
       /* Double a = null;
       double b = 2;

        if (a.doubleValue() > b) {

            System.out.println(a.doubleValue());
        }*/

        /*String format = new DecimalFormat("#.##").format(99.89);
        System.out.println(format);*/

        // 去除末尾多余的0
        try {
            BigDecimal result = new BigDecimal("1000.3467");
         result.setScale(2, BigDecimal.ROUND_HALF_UP);
            System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }


        float imgRatio = 1.5f;
        String url ="http://img.guanfu.cn/gf-images-1593762554477_2x3.jpg";

        int startIndex = url.lastIndexOf("_");
        int endIndex = url.lastIndexOf(".");
        if (startIndex != -1 && endIndex != -1) {
            String whStr = url.substring(startIndex+1, endIndex);
            if (whStr.contains("x")) {
                String[] split = whStr.split("x");
                try {
                    float w = Integer.parseInt(split[0]);
                    float h = Integer.parseInt(split[1]);
                    imgRatio = w / h;
                    System.out.println(imgRatio + " >>> w=" + w + ", h=" + h);

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static BigDecimal getFixedBigDecimal(String value, int fixed) {

        try {
            BigDecimal result = new BigDecimal(value);
            return result.setScale(fixed, BigDecimal.ROUND_HALF_UP);
        } catch (Exception e) {

        }
        return BigDecimal.ZERO;
    }

    public static String mul(String value1, String value2) {
        BigDecimal b1 = new BigDecimal(value1);
        BigDecimal b2 = new BigDecimal(value2);
        return b1.multiply(b2).toString();
    }

}
