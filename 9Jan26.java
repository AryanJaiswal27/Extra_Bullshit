public class 9Jan26 {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(Math.abs(arr[i] - arr[j]) <= a &&
                       Math.abs(arr[j] - arr[k]) <= b &&
                       Math.abs(arr[i] - arr[k]) <= c) {
                        count++;
                    }
                }
            }
        }

        return count;

    }


    public int minimumSum(int num) {
        String s = Integer.toString(num);
        int d1 = Character.getNumericValue(s.charAt(0));
        int d2 = Character.getNumericValue(s.charAt(1));
        int d3 = Character.getNumericValue(s.charAt(2));
        int d4 = Character.getNumericValue(s.charAt(3));

        int[] arr = new int[]{d1, d2, d3, d4};
        java.util.Arrays.sort(arr);
        
  

        int min =  Integer.parseInt(arr[0] + arr[2]) + Integer.parseInt(arr[1] + arr[3]);
        return min;
    }

    public int[] decompressRLElist(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for(int j = 0; j < freq; j++) {
                list.add(val);
            }
        }

        int[] result = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    public int numberOfSteps(int num) {
        int steps = 0;
        while(num > 0) {
            if(num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
            steps++;
        }
        return steps;
    }

    public int subarraySum(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n; i++) {
            
            for(int j = Math.max(0,i-nums[i]); j <= i; j++) {
                sum += nums[j];
                
            }
        }
        return sum;
    }


     public int arithmeticTriplets(int[] nums, int diff) {
        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                for(int k=j+1;k<n;k++){
                    if(nums[j]-nums[i]==diff && nums[k]-nums[j]==diff){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public int countKDifference(int[] nums, int k) {
        
            int count = 0;
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(Math.abs(nums[i] - nums[j]) == k) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int n = items.size();
        int count=0;
        for(int i = 0; i < n; i++) {
            List<String> item = items.get(i);
            if(ruleKey.equals("type")) {
                if(item.get(0).equals(ruleValue)) {
                    count++;
                }
            } else if(ruleKey.equals("color")) {
                if(item.get(1).equals(ruleValue)) {
                    count++;
                }
            } else if(ruleKey.equals("name")) {
                if(item.get(2).equals(ruleValue)) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countPartitions(int[] nums) {
       int n = nums.length;
        int totalSum = 0;
        for(int num : nums) {
            totalSum += num;
        }
        int curr = 0;
        int count = 0;
        for(int i = 0; i < n-1; i++) {
            curr += nums[i];
            if(Math.abs(totalSum -  curr - curr)%2 == 0) {
                count++;
            }
        }

        return count;


    }


    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i : nums) {
            int sum = 0;
            while(i > 0) {
                int d = i % 10;
                i /= 10;
                sum += d;

            }
            if(sum < min) {
                min = sum;
            }


        }
        return min;
    }

    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }

        }

        return count;
    }


    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;
        
        for(int length = 1; length <= n; length += 2) {
            for(int start = 0; start <= n - length; start++) {
                for(int k = start; k < start + length; k++) {
                    totalSum += arr[k];
                }
            }
        }


        return totalSum;
    }

    public int findGCD(int a, int b) {
        if(b == 0) {
            return a;
        }

        return findGCD(b, a % b);
    }
    public int gcdOfOddEvenSums(int n) {

        int evenSum = 0;
        int oddSum = 0;
        n= 2*n;

        if(n % 2 == 0) {
            evenSum = n / 2 * (n + 1);
            oddSum = (n / 2) * (n / 2);
        } else {
            evenSum = (n / 2) * (n / 2 + 1);
            oddSum = ((n / 2) + 1) * ((n / 2) + 1);
        }
        return findGCD(evenSum, oddSum);
    }


    public int maxProduct(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(nums[i] < nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
                }
            }
        }

        return (nums[0] - 1) * (nums[1] - 1);
    }


    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] minCosts = new int[n];
        int min = Integer.MAX_VALUE;
        for(int i = 0; i <n ; i++) {
            if(cost[i] < min) {
                min = cost[i];
            }
            minCosts[i] = min;
        }

        return minCosts;
    }

    public boolean isAcronym(List<String> words, String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < words.size(); i++) {
            sb.append(words.get(i).charAt(0));
        }

        return sb.toString().equals(s);
    }


    public int canBeTypedWords(String text, String brokenLetters) {
        String arr []= text.split(" ");
        int count =0;
        for(int i=0;i<arr.length;i++){
            boolean flag=true;
            for(int j=0;j<brokenLetters.length();j++){
                if(arr[i].indexOf(brokenLetters.charAt(j))!=-1){
                    flag=false;
                    break;
                }
            }
            if(flag)
                count++;

        }
        return count;

    }

    public String clearDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(!Character.isDigit(ch)) {
                sb.append(ch);
            }
            else {
                sb.deleteCharAt(sb.length() - 1);
            }
        }
        return sb.toString();
    }

    public String replaceDigits(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder(s);
        for(int i = 1; i < n; i += 2) {
            char ch = s.charAt(i - 1);
            int shift = Character.getNumericValue(s.charAt(i));
            char newCh = (char)(ch + shift);
            sb.setCharAt(i, newCh);
        }
        return sb.toString();
    }

    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0;
        int y = 0;
        for(String command : commands) {
            if(command.equals("UP")) {
                y--;
            } else if(command.equals("DOWN")) {
                y++;
            }
            else if(command.equals("LEFT")) {
                x--;
            } else if(command.equals("RIGHT")) {
                x++;
            }


        }

        return x + (y*n);
    }


    public List<Integer> findMissingElements(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
            if(num > max) {
                max = num;
            }
            if(num < min) {
                min = num;
            }
        }


        List<Integer> missingElements = new ArrayList<>();
        for(int i = min + 1; i < max; i++) {
            
            if(!set.contains(i)) {
                missingElements.add(i);
            }
        }
        return missingElements;

    }


}
