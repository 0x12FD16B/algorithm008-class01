package lemonadeChange;

/**
 * https://leetcode-cn.com/problems/lemonade-change/
 *
 * @author David Liu
 */
public class Solution {

    public boolean lemonadeChange(int[] bills) {
        if (bills == null || bills.length == 0) return false;
        int bill5count = 0, bill10count = 0;
        for (int bill : bills) {
            if (bill == 5) bill5count++;
            else if (bill == 10) {
                bill10count++;
                if (bill5count == 0) return false;
                else bill5count--;
            } else {
                if (bill10count == 0) {
                    if (bill5count < 3) return false;
                    bill5count = bill5count - 3;
                } else {
                    if (bill5count == 0) return false;
                    bill10count--;
                    bill5count--;
                }
            }
        }
        return true;
    }

}
