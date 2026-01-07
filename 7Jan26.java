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
        for (int i = 1; i < n - 1; i++) {
            if (height[i-1]>threshold) {
                        result.add(i);
        
            }
        }
    

    return result;
    }



}
