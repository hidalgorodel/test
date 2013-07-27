/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moneyapp;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 *
 * @author rodel
 */
public class MoneyProcessor {

    private static MoneyProcessor instance;

    public static MoneyProcessor getInstance() {
        if (instance == null) {
            instance = new MoneyProcessor();
        }
        return instance;
    }
    
    public BigDecimal addAndTotal(BigDecimal value, BigDecimal prevValue) {
        BigDecimal total = prevValue.add(value).round(MathContext.UNLIMITED);
        return total;
    }
}
