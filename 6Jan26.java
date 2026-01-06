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

    public int maxFreqSum(String s) {
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            int charValue = s.charAt(i);
            freqMap.put(charValue, freqMap.getOrDefault(charValue, 0) + 1);
        }

        int vowelFreq = 0;
        int consonantFreq = 0;
        for (Map.Entry<Integer, Integer> iterable_element : freqMap.entrySet()) {
            int key = iterable_element.getKey();
            int value = iterable_element.getValue();
            if (key == 'a' || key == 'e' || key == 'i' || key == 'o' || key == 'u') {
                vowelFreq = Math.max(vowelFreq, value);
            } else {
                consonantFreq = Math.max(consonantFreq, value);
            }

        }

        return vowelFreq + consonantFreq;

    }

    public int numJewelsInStones(String jewels, String stones) {
        HashSet<Character> jewelSet = new HashSet<>();
        for (int i = 0; i < jewels.length(); i++) {
            jewelSet.add(jewels.charAt(i));
        }

        int count = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewelSet.contains(stones.charAt(i))) {
                count++;
            }
        }

        return count;
    }

    public int alternatingSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            } else {
                sum -= nums[i];
            }
        }
        return sum;
    }

    public int findClosest(int x, int y, int z) {
        return Math.abs(x - z) == Math.abs(y - z) ? 0
                : Math.min(Math.abs(x - z), Math.abs(y - z)) == Math.abs(x - z) ? 1 : 2;
    }

    public String reversePrefix(String s, int k) {
        String result = "";
        for (int i = 0; i < k; i++) {
            result = s.charAt(i) + result;
        }
        return result + s.substring(k);
    }

    public int maximumWealth(int[][] accounts) {
        int m = accounts.length;
        int n = accounts[0].length;
        int maxWealth = 0;
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += accounts[i][j];
            }
            maxWealth = Math.max(maxWealth, sum);
        }

        return maxWealth;

    }

    public String convertDateToBinary(String date) {
        String[] parts = date.split("-");
        String result = "";
        for (int i = 0; i < parts.length; i++) {
            int x = Integer.parseInt(parts[i]);
            String resultPart = "";
            while (x != 0) {
                if ((x & 1) == 1) {
                    resultPart = "1" + resultPart;
                } else {
                    resultPart = "0" + resultPart;
                }
                x = x >> 1;
            }
            if (i == 0) {

                result = resultPart;
            } else {

                result = result + "-" + resultPart;
            }

        }

        return result;
    }

}