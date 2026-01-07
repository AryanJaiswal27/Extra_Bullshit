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

    public int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

     public ListNode insertGreatestCommonDivisors(ListNode head) {
        
        if(head == null || head.next == null) {
            return head;

        }

        int firstVal = head.val;
        int secondVal = head.next.val;
        int gcdVal = gcd(firstVal, secondVal);
        ListNode temp = new ListNode(gcdVal);

        ListNode agla = head.next;
        head.next = temp;
        temp.next = insertGreatestCommonDivisors(agla);



        return head;



    }


     public int maxDistinct(String s) {
       HashSet<Character> set = new HashSet<>();
         for (char c : s.toCharArray()) {
              set.add(c);
         }
            return set.size(); 
    }


    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int rev = 0;
        int original = x;
        while (x > 0) {
            int digit = x % 10;
            rev = rev * 10 + digit;
            x = x / 10;
        }
        return rev == original;
    }

    public boolean isStrictlyPalindromic(int n) {
        for(int base = 2; base <= n - 2; base++) {
            String nstr = ""+n;
            int num = Integer.parseInt(nstr, base);
            if (!isPalindrome(num)) {
                return false;
            
         }
     }
    return true;
    }

public int[] createTargetArray(int[] nums, int[] index) {
        int n = nums.length;
        int target[] = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < n; i++) {
            target[i] = list.get(i);
        }
        return target;
    }


    public int numberOfMatches(int n) {
        if(n==1){
            return 0;
        }

        if(n%2==0){
            return n/2 + numberOfMatches(n/2);
        }
        else{
            return n/2 + numberOfMatches(n/2 + 1);
        }
       
    }



    public int numberOfPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (nums1[i] % (nums2[j]*k) == 0) {
                    count++;
                }
            }
        }


        return count;
    }


    public int maximum69Number (int num) {
        String numStr = Integer.toString(num);
        char[] numChars = numStr.toCharArray();
        for (int i = 0; i < numChars.length; i++) {
            if (numChars[i] == '6') {
                numChars[i] = '9';
                break;
            }
        }
        String modifiedNumStr = new String(numChars);
        return Integer.parseInt(modifiedNumStr);
    }

    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += mat[i][i];
            sum += mat[i][n - 1 - i];
        }
        if (n % 2 == 1) {
            sum -= mat[n / 2][n / 2];
        }
        return sum;
    }

     public String sortSentence(String s) {
        String arr[] = s.split(" ");
        String result[] = new String[arr.length];
        for (String str : arr) {
            int index = Character.getNumericValue(str.charAt(str.length() - 1)) - 1;
            result[index] = str.substring(0, str.length() - 1);
        }
        return String.join(" ", result);
    }


    public int pivotInteger(int n) {
        int totalSum = n * (n + 1) / 2;
        int leftSum = 0;
        for (int i = 1; i <= n; i++) {
            leftSum += i;
            if (leftSum == totalSum - leftSum + i) {
                return i;
            }
        }
        return -1;
    }


     public ListNode mergeNodes(ListNode head) {
        int sum =0;
        ListNode start = new ListNode(sum);
        ListNode holding = start;
        while(head!=null){
            if(head.val == 0){
                ListNode temp = new ListNode(sum);
                start.next = temp;
                start = start.next;
                sum = 0;

            }
            sum+=head.val;
            head = head.next;
        }

        return holding.next.next;

    }

    public int sumTree(TreeNode root) {
        if(root==null){
            return 0;
        }
        return root.val + sumTree(root.right)+sumTree(root.left);
    }

    public TreeNode helper(TreeNode root , int parentValue) {
        if(root==null){
            return root;
        }

        root.val += sumTree(root.right) + parentValue;
        root.right = helper( root.right ,  parentValue);
        parentValue = root.val;
        root.left = helper( root.left ,  parentValue);


        return root;


    }

    public TreeNode bstToGst(TreeNode root) {
        return helper(root,0);
    }




    public int numberOfBeams(String[] bank) {
        int n = bank.length;
        int count = 0;
        int[] lasers = new int[n];

        for (int i = 0; i < n; i++) {
            for(char c : bank[i].toCharArray()){
                if(c=='1'){
                    lasers[i]++;
                }
            }
            // boolean found = false;
            // for(int j=i+1; j<n; j++){
            //     if(found){
            //         break;
            //     }

            //     for(char c : bank[i].toCharArray()){
            //         if(c=='1'){
            //             count++;
            //             found = true;
                        
            //         }
            //     }

            // }
        }

        for (int i = 0; i < n; i++) {
            boolean found = false;
            for (int j = i + 1; j < n; j++) {
                if(found){
                    break;
                }
                if(lasers[j]>0){
                    found = true;
                }
                if (lasers[i] > 0 && lasers[j] > 0) {
                    count += lasers[i] * lasers[j];
                   
                }
            }
        }

        return count;

    }


    public int sum(TreeNode root) {
        if(root==null){
            return 0;

        }
        return root.val + sum(root.left) + sum(root.right);
    }
    public int count(TreeNode root) {
        if(root==null){
            return 0;

        }
        return 1 + count(root.left) + count(root.right);
    }

    public int averageOfSubtree(TreeNode root) {
        if(root==null){
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        int totalSum = leftSum + rightSum + root.val;
        int totalCount = leftCount + rightCount + 1;
        int avg = totalSum / totalCount;
        if(avg == root.val){
            return 1 + averageOfSubtree(root.left) + averageOfSubtree(root.right);
        }
        else{
            return averageOfSubtree(root.left) + averageOfSubtree(root.right);
        }
    }


    HashMap<Integer,ArrayList<TreeNode>> oddLevelNodes = new HashMap<>();
    public void helper(TreeNode root, int level){
        if(root==null){
            return;
        }

        if(level%2==1){
            if(!oddLevelNodes.containsKey(level)){
                oddLevelNodes.put(level, new ArrayList<>());
            }
            oddLevelNodes.get(level).add(root);
        }

        helper(root.left, level+1);
        helper(root.right, level+1);

        
    }

    public TreeNode reverseOddLevels(TreeNode root) {
        TreeNode newRoot = root;
        helper(newRoot, 0);

        for(int level : oddLevelNodes.keySet()){
            ArrayList<TreeNode> nodes = oddLevelNodes.get(level);
            int i = 0;
            int j = nodes.size()-1;
            while(i<j){
                int temp = nodes.get(i).val;
                nodes.get(i).val = nodes.get(j).val;
                nodes.get(j).val = temp;
                i++;
                j--;
            }
        }

        


        return root; 
    }


    int sum = 0;
    public int deepestLeavesSum(TreeNode root) {
        sum = 0;
        int deepestLevel = deepestLevel(root, 0);
        helper2(root, 0, deepestLevel);
        return sum;
    }

    public void helper2(TreeNode root, int level, int deepestLevel){
        if(root==null){
            return;
        }

        if(level==deepestLevel){
            sum += root.val;
        }

        helper2(root.left, level+1, deepestLevel);
        helper2(root.right, level+1, deepestLevel);
    }

    public int deepestLevel(TreeNode root, int level) {
        if(root==null){
            return level-1;
        }
        return Math.max(deepestLevel(root.left, level+1), deepestLevel(root.right, level+1));
    }


    public int countAsterisks(String s) {
        int n = s.length();
        int count = 0;
        boolean inPair = false;
        for(int i=0; i<n; i++){
           if(s.charAt(i)=='|'){
               inPair = !inPair;
           }
           else if(s.charAt(i)=='*' && !inPair){
               count++;
           }
        }

        return count;
    }


    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int n = x;
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n = n / 10;
        }
        if (x % sum == 0) {
            return sum;
        } else {
            return -1;
        }
    }


    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i=low; i<=high; i++){
            String numStr = Integer.toString(i);
            int n = numStr.length();
            if(n%2!=0){
                continue;
            }
            int leftSum = 0;
            int rightSum = 0;
            for(int j=0; j<n/2; j++){
                leftSum += Character.getNumericValue(numStr.charAt(j));
            }
            for(int j=n/2; j<n; j++){
                rightSum += Character.getNumericValue(numStr.charAt(j));
            }
            if(leftSum==rightSum){
                count++;
            }
        }
        return count;
    }


    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int n = word1.length;
        int m = word2.length;
        String str1 = "";
        String str2 = "";

        for(int i = 0; i < n; i++) {
            str1 += word1[i];

        }
        for(int j = 0; j < m; j++) {
            str2 += word2[j];

        }
        if(str1.equals(str2)){
            return true;

        }
        else{
            return false;
        }
        
    }


    public String decodeMessage(String key, String message) {
       HashSet<Character> seen = new HashSet<>();
        HashMap<Character, Character> mapping = new HashMap<>();
        
        for (char c : key.toCharArray()) {
            if (c != ' ' && !seen.contains(c)) {
                seen.add(c);
                char mappedChar = (char) ('a' + mapping.size());
                mapping.put(c, mappedChar);
            }
        }

        StringBuilder decodedMessage = new StringBuilder();
        for (char c : message.toCharArray()) {
            if (c == ' ') {
                decodedMessage.append(' ');
            } else {
                decodedMessage.append(mapping.get(c));
            }
        }
        return decodedMessage.toString();


    }


    public List<List<Integer>> findMatrix(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int maxCount = 0;
        // HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
           if(!freqMap.containsKey(nums[i])) {
               freqMap.put(nums[i], 0);
               maxCount = Math.max(maxCount, 0);
           }else{
                freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
                maxCount = Math.max(maxCount, freqMap.get(nums[i]));
           }
        }

        for(int i = 0; i <= maxCount; i++) {
            result.add(new ArrayList<>());
        }


        for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            int count = entry.getValue();
            int key = entry.getKey();

            while(count >= 0) {
                result.get(count).add(key);
                count--;
            }


        }


        return result;
    }

    public int helper(TreeNode root, TreeNode parent, TreeNode grandparent) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (grandparent != null && grandparent.val % 2 == 0) {
            sum += root.val;
        }
        sum += helper(root.left, root, parent);
        sum += helper(root.right, root, parent);
        return sum;

    }

    public int sumEvenGrandparent(TreeNode root) {
        return helper(root, null, null);
    }


    public void helper(HashSet<Integer> set, int num[],int i) {
       
    }

    public String smallestNumber(String pattern) {
        
    }

}
