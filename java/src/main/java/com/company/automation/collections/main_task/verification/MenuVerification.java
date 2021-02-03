package com.company.automation.collections.main_task.verification;

public class MenuVerification {
    public static boolean verifyInput(int option, int optionsQuantity) {
        return option >= 0 && option <= optionsQuantity;
    }

    public static boolean verifyPriceRange(int from, int to) {
        boolean verification = (from >= 0 && to >= 0) && (from <= to);
        if (!verification) {
            System.out.println("\nWRONG price range!!!\n");
        }
        return verification;
    }
}
