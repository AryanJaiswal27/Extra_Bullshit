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

    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> allowedSet = new HashSet<>();
        for (int i = 0; i < allowed.length(); i++) {
            allowedSet.add(allowed.charAt(i));
        }
        int count = 0;
        for (String word : words) {
            boolean isConsistent = true;
            for (int i = 0; i < word.length(); i++) {
                if (!allowedSet.contains(word.charAt(i))) {
                    isConsistent = false;
                    break;
                }
            }
            if (isConsistent) {
                count++;
            }
        }
        return count;
    }

    public int reverseDegree(String s) {
        int sum = 0;
        for (int i = 0; i < s.length(); i++) {
            int x = 26 - (s.charAt(i) - 'a');
            x = x * (i + 1);
            sum += x;
        }
        return sum;
    }

    public int smallestEvenMultiple(int n) {
        if (n % 2 == 0) {
            return n;
        } else {
            return 2 * n;
        }
    }

    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> resList = new ArrayList<>();
        int maxCandies = 0;
        for (int i = 0; i < candies.length; i++) {
            maxCandies = Math.max(maxCandies, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            if (candies[i] + extraCandies >= maxCandies) {
                resList.add(true);
            } else {
                resList.add(false);
            }
        }

        return resList;

    }

    public String interpret(String command) {
        String result = "";
        while (command.length() > 0) {
            if (command.startsWith("G")) {
                result += "G";
                command = command.substring(1);
            } else if (command.startsWith("()")) {
                result += "o";
                command = command.substring(2);
            } else if (command.startsWith("(al)")) {
                result += "al";
                command = command.substring(4);
            }
        }
        return result;
    }

    public int sum(int num1, int num2) {
        return num1 + num2;
    }

    public int[] leftRightDifference(int[] nums) {

        int n = nums.length;
        int[] leftSum = new int[n];
        int[] rightSum = new int[n];
        int[] ans = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            leftSum[i] = sum;
            sum += nums[i];
        }
        int sum2 = 0;
        for (int i = n - 1; i >= 0; i--) {

            rightSum[i] = sum2;
            ans[i] = Math.abs(leftSum[i] - rightSum[i]);
            sum2 += nums[i];
        }

        return ans;

    }

    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] result = new int[n - 2][n - 2];

        int index = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int row = index / (n - 2);
                int col = index % (n - 2);
                int maxVal = Integer.MIN_VALUE;
                maxVal = Math.max(maxVal, grid[i - 1][j - 1]);
                maxVal = Math.max(maxVal, grid[i - 1][j]);
                maxVal = Math.max(maxVal, grid[i - 1][j + 1]);
                maxVal = Math.max(maxVal, grid[i][j - 1]);
                maxVal = Math.max(maxVal, grid[i][j]);
                maxVal = Math.max(maxVal, grid[i][j + 1]);
                maxVal = Math.max(maxVal, grid[i + 1][j - 1]);
                maxVal = Math.max(maxVal, grid[i + 1][j]);
                maxVal = Math.max(maxVal, grid[i + 1][j + 1]);
                result[row][col] = maxVal;
                index++;
            }
        }

        return result;

    }

    public int minBitFlips(int start, int goal) {
        int count = 0;
        while (start != 0 || goal != 0) {
            if ((start & 1) != (goal & 1)) {
                start = start >> 1;
                goal = goal >> 1;
                count++;
            } else {
                start = start >> 1;
                goal = goal >> 1;
            }

        }

        return count;

    }

    public int countPairs(List<Integer> nums, int target) {
        int n = nums.size();
        int pairCount = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums.get(i) + nums.get(j) < target) {
                    pairCount++;
                }
            }
        }
        return pairCount;

    }

    public int findPermutationDifference(String s, String t) {
        HashMap<Character, Integer> freqMapS = new HashMap<>();

        int n = s.length();
        for (int i = 0; i < n; i++) {
            freqMapS.put(s.charAt(i), i);
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (freqMapS.get(t.charAt(i)) != i) {
                sum += Math.abs(freqMapS.get(t.charAt(i)) - i);
            }
        }

        return sum;

    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            return rangeSumBST(root.right, low, high);
        }
        if (root.val > high) {
            return rangeSumBST(root.left, low, high);
        }

        return root.val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);

    }

    public int[] decode(int[] encoded, int first) {
        int n = encoded.length;
        int[] result = new int[n + 1];
        result[0] = first;
        for (int i = 0; i < n; i++) {
            result[i + 1] = result[i] ^ encoded[i];
        }
        return result;
    }

    public int minMovesToSeat(int[] seats, int[] students) {
        Arrays.sort(seats);
        Arrays.sort(students);
        int n = seats.length;
        int moves = 0;
        for (int i = 0; i < n; i++) {
            moves += Math.abs(seats[i] - students[i]);
        }
        return moves;
    }

    public int balancedStringSplit(String s) {
        int count = 0;
        int n = s.length();
        int balance = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                balance++;
            } else {
                balance--;
            }
            if (balance == 0) {
                count++;
            }
        }
        return count;

    }

    class ParkingSystem {

        int type1;
        int type2;
        int type3;

        public ParkingSystem(int big, int medium, int small) {
            type1 = big;
            type2 = medium;
            type3 = small;
        }

        public boolean addCar(int carType) {
            if (carType == 1) {
                if (type1 > 0) {
                    type1--;
                    return true;
                } else {

                    return false;
                }
            } else if (carType == 2) {
                if (type2 > 0) {
                    type2--;
                    return true;
                } else {

                    return false;
                }
            } else {
                if (type3 > 0) {
                    type3--;
                    return true;
                } else {

                    return false;
                }
            }
        }
    }

    public int maxWidthOfVerticalArea(int[][] points) {

        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int maxWidth = 0;
        for (int i = 1; i < points.length; i++) {
            maxWidth = Math.max(maxWidth, points[i][0] - points[i - 1][0]);
        }
        return maxWidth;

    }

}