public class 7Jan26 {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        for(int j = 0; j < k; j++) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
            for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minIndex = i;
            }
        }
        nums[minIndex] *= multiplier;
    }
    return nums;
    }



    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int result[] = new int[n];
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            result[i] = sum;
        }
        return result;
    }

    public int mirrorDistance(int n) {
        int rev = 0;
        int x = n;
        while (x > 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }

        return Math.abs(n - rev);


    }


    public int findCenter(int[][] edges) {
        int first = edges[0][0];
        int second = edges[0][1];
        if (edges[1][0] == first || edges[1][1] == first) {
            return first;
        } else {
            return edges[0][1];
        }
    }


    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> result = new ArrayList<>();
        int n = height.length;
        for (int i = 1; i < n ; i++) {
            if (height[i-1]>threshold) {
                        result.add(i);
        
            }
        }
    

    return result;
    }


    public String removeOuterParentheses(String s) {
       int n = s.length();
       int count = 0;

       List<String> res = new ArrayList<>();
       
       for (int i = 0; i < n; i++) {
           char c = s.charAt(i);
           if (c == '(') {
               count++;
           } else {
               count--;
           }
           if (count == 0) {
               res.add(s.substring(0, i+1));
               s=s.substring(i+1);
               i=-1;
               n = s.length();
           }
       }
       String finalStr = "";
       for (int i = 0; i < res.size(); i++) {
           String str = res.get(i);
           str = str.substring(1, str.length()-1);
              finalStr += str;
       }

       return finalStr;

    }


    public String reversePrefix(String word, char ch) {
        int n = word.length();
        for (int i = 0; i < n; i++) {
            if (word.charAt(i) == ch) {
                String prefix = word.substring(0, i + 1);
                String suffix = word.substring(i + 1);
                String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                return reversedPrefix + suffix;
            }
        }

        return word;
    }


        public String truncateSentence(String s, int k) {
        String words[] = s.split(" ");
        String result = "";
        for (int i = 0; i < k; i++) {
            result += words[i];
            if (i != k - 1) {
                result += " ";
            }
        }
        return result;
    }

    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] < k) {
                count++;
            }
        }

        return count;


    }


}
