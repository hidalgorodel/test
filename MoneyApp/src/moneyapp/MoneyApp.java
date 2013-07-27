/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package moneyapp;

import java.math.BigDecimal;

/**
 *
 * @author rodel
 */
public class MoneyApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        Money m1 = new Money(new BigDecimal("125.05"), "PHP");
//        boolean isAdded = MoneyDAO.getInstance().add(m1);
//        if(isAdded) {
//            System.out.println("New Money added to DB.");
//        } else {
//            System.out.println("Failed to add new Money to DB.");
//        }
//        Money m = MoneyDAO.getInstance().findByDesc("PHP");
//        if(m != null) {
//            System.out.println("Result: " + m.toString());
//        } else {
//            System.out.println("No result found.");
//        }
//        System.out.println("Result with duplicates:");
//        BigDecimal prevValue = new BigDecimal("0");
//        for (Money money : MoneyDAO.getInstance().findAllWithDuplicate()) {
//            System.out.println(money.toString());
//            prevValue = MoneyProcessor.getInstance().addAndTotal(money.getAmount(), prevValue);
//            System.out.println("Total: " + prevValue);
//        }
//        
//        System.out.println("Result without duplicate:");
//        BigDecimal prevValue2 = new BigDecimal("0");
//        for (Money money : MoneyDAO.getInstance().findAllWithOutDuplicate()) {
//            System.out.println(money.toString());
//            prevValue2 = MoneyProcessor.getInstance().addAndTotal(money.getAmount(), prevValue2);
//            System.out.println("Total: " + prevValue2);
//        }
        for (Money money : MoneyDAO.getInstance().findAmountGreaterThan(new BigDecimal("125.05"))) {
            System.out.println(money.toString());
        }
//        boolean isRemoved = MoneyDAO.getInstance().delete("PHP");
//        if(isRemoved) {
//            System.out.println("Money has been removed from DB.");
//        } else {
//            System.out.println("Failed to removed Money from DB.");
//        }
    }
}
