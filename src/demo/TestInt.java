package demo;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.net.URI;
import java.text.DecimalFormat;

/**
 * Author   : soldieryu.dev@gmail.com
 * Create   : 2020/4/20
 * Describe :
 */
public class TestInt {
    public static void main(String[] args){
//        String p = "8.99";
//        System.out.println(Double.valueOf(p).intValue());
        formatRMBPrice("123456789.13455765");
//        System.out.println(String.valueOf(""));
        
    }

    //格式化为带千分符RMB 111,234,56
    public static void formatRMBPrice(String price) {
        DecimalFormat format = new DecimalFormat(",###");
//        format.setRoundingMode(RoundingMode.HALF_UP);
        String formatPrice = format.format(new BigDecimal(price));
        System.out.println(formatPrice);
    }
}
