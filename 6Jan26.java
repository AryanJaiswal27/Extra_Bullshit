import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];

        }
        long target = sum % k;
        return (int) target;

    }

    public int scoreOfString(String s) {
        int score = 0;
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }

    public int theMaximumAchievableX(int num, int t) {
        return num + 2 * t;
    }

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = nums[nums[i]];
        }
        return result;
    }

    public int minimumOperations(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i] % 3;

            sum += Math.min(x, Math.abs(3 - x));
        }
        return (int) sum;
    }

    public int[] recoverOrder(int[] order, int[] friends) {
        HashSet<Integer> friendSet = new HashSet<>();
        for (int friend : friends) {
            friendSet.add(friend);
        }

        int n = friends.length;
        int[] result = new int[n];
        int index = 0;
        for (int i = 0; i < order.length; i++) {
            if (friendSet.contains(order[i])) {
                result[index++] = order[i];
            }
        }

        return result;

    }

    public int finalValueAfterOperations(String[] operations) {
        int x = 0;
        int n = operations.length;
        for (int i = 0; i < n; i++) {
            if (operations[i].charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }

        return x;
    }

    public double[] convertTemperature(double celsius) {
        double[] result = new double[2];
        result[0] = celsius + 273.15;
        result[1] = celsius * 1.80 + 32.00;
        return result;
    }

    // public int subsetXORSum(int[] nums) {

    // }

    // public int[] helper(int nums[], int i){
    // int x = helper(nums, i+1);
    // return x+nums[i];
    // }

    public String defangIPaddr(String address) {
        address = address.replaceAll("[.]", "[.]");
        return address;
    }

    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int goodPairs = 0;
        for (int num : nums) {
            goodPairs += freqMap.get(num) != null ? freqMap.get(num) : 0;
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }
        return goodPairs;
    }

    public int[] transformArray(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int evenCount = 0;
        int oddCount = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] % 2 == 0) {
                evenCount++;

            } else {
                oddCount++;
            }
        }

        for (int i = evenCount; i < n; i++) {
            result[i] = 1;
        }

        return result;
    }

}