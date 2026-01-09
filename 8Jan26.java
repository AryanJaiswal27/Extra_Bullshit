public class 8Jan26 {
    public String restoreString(String s, int[] indices) {
        char[] restored = new char[s.length()];
        for (int i = 0; i < s.length(); i++) {
            restored[indices[i]] = s.charAt(i);
        }
        return new String(restored);
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
       

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(heights[i] < heights[j]) {
                    
                    int tempHeight = heights[i];
                    heights[i] = heights[j];
                    heights[j] = tempHeight;

                    
                    String tempName = names[i];
                    names[i] = names[j];
                    names[j] = tempName;
                }
            }
        }

        return names;




    }


    public int maxDepth(String s) {
        int n = s.length();
        int maxDepth = 0;
        int currentDepth = 0;


        for(int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if(ch == '(') {
                currentDepth++;
                maxDepth = Math.max(maxDepth, currentDepth);
            } else if(ch == ')') {
                currentDepth--;
            }
        }



        return maxDepth;
    }


    public int earliestTime(int[][] tasks) {
       int n = tasks.length;
       int earliestTime = Integer.MAX_VALUE;
       for(int i = 0; i < n ; i++) {
           if(earliestTime > tasks[i][0]+tasks[i][1]) {
               earliestTime = tasks[i][0]+tasks[i][1];

           }
       }
       return earliestTime;
    }


    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int maxAltitude = 0;
        int currentAltitude = 0;
        for(int i = 0; i < n; i++) {
            currentAltitude += gain[i];
            maxAltitude = Math.max(maxAltitude, currentAltitude);
        }
        return maxAltitude;
    }


    public int uniqueMorseRepresentations(String[] words) {
       String arr[] =  {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        HashSet<String> set = new HashSet<>();
        int n = words.length;
        for(int i = 0; i < n; i++) {
            StringBuilder morseCode = new StringBuilder();
            for(int j = 0; j < words[i].length(); j++) {
                morseCode.append(arr[words[i].charAt(j) - 'a']);
            }
            set.add(morseCode.toString());
        }

        return set.size();

    }


    public String maximumOddBinaryNumber(String s) {
        int n = s.length();
        int countOnes = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == '1') {
                countOnes++;
            }
        }
        countOnes--;
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < countOnes; i++) {
            result.append('1');
        }
        for(int i = 0; i < n - countOnes - 1; i++) {
            result.append('0');
        }
        result.append('1');
        return result.toString();
    }

     public boolean checkTree(TreeNode root) {
        if(root.val == root.left.val + root.right.val){
            return true;

        }
        else{
            return false;
        }
    }

    TreeNode targetNode = null;
    public final void helper(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null){
            return;

        }
        if(original == target){
            targetNode = cloned;
            return;
        }
        getTargetCopy(original.right, cloned.right, target);
        getTargetCopy(original.left, cloned.left, target);

    }
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
       
        helper(original, cloned, target);
        return targetNode;

    }
    

    public boolean evaluateTree(TreeNode root) {
        if(root.left == null && root.right == null){
            return root.val == 1;
        }

        if(root.val == 2){
            return evaluateTree (root.left) || evaluateTree (root.right);
        }
        else{
            return evaluateTree (root.left) && evaluateTree (root.right);
        }

    }


    public TreeNode searchBST(TreeNode root, int val) {
        if(root == null){
            return null;
        }
        if(root.val == val){
            return root;
        }
        else if(val < root.val){
            return searchBST(root.left, val);
        }
        else{
            return searchBST(root.right, val);
        }
    }

    List<Integer> result = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root==null){
            return;
        }
        for(Node child : root.children){
            postorder(child);

        }
        result.add(root.val);
        
    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null){
            return root2;
        }
        if(root2 == null){
            return root1;
        }
        root1.val += root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);
        return root1;
    }


    List<Integer> result = new ArrayList<>();
    public void traverse(TreeNode root) {
        if(root == null){
            return;
        }
        traverse(root.left);
        result.add(root.val);
        traverse(root.right);
    }

    public TreeNode increasingBST(TreeNode root) {
        traverse(root);
        TreeNode newRoot = new TreeNode(0);
        TreeNode current = newRoot;
        for(int val : result){
            current.right = new TreeNode(val);
            current = current.right;
        }
        return newRoot.right;
    }

    HashMap<Integer, List<Integer>> levelMap = new HashMap<>();
    public void helper(TreeNode root, int level) {
        if(root == null){
            return;
        }

        levelMap.putIfAbsent(level, new ArrayList<>());
        levelMap.get(level).add(root.val);
        helper(root.left, level + 1);
        helper(root.right, level + 1);

    
    }

    public List<Double> averageOfLevels(TreeNode root) {
        helper(root, 0);
        List<Double> result = new ArrayList<>();
        for(int level : levelMap.keySet()){
            List<Integer> values = levelMap.get(level);
            double sum = 0;
            for(int val : values){
                sum += val;
            }
            result.add(sum / values.size());
        }
        return result;
    }

    int totalSum = 0;


    public void helper(TreeNode root, String path) {
        if(root == null){
            return;
        }
        String currentSum = path + root.val;
        if(root.left == null && root.right == null){
            
            totalSum += Integer.parseInt(currentSum, 2);
            return;
        }
        if(root.left != null)
            helper(root.left, currentSum);

        if(root.right != null)
            helper(root.right, currentSum);
    }


    public int sumRootToLeaf(TreeNode root) {
        helper(root, "");
        return totalSum;
    }


    public int maxDepth(Node root) {
        if(root == null){
            return 0;
        }
        int max_depth = 0;
        for(Node child : root.children){
            int childDepth = maxDepth(child);
            max_depth = Math.max(max_depth, childDepth);
        }
        return max_depth;
    }


    public int getDecimalValue(ListNode head) {
        String binaryString = "";
        ListNode current = head;
        while(current != null){
            binaryString += current.val;
            current = current.next;
        }
        return Integer.parseInt(binaryString, 2);
    }


    public boolean isPalindrome(ListNode head) {
       
        ListNode current = head;
        String str = "";
        while(current != null){
            str += current.val;
            current = current.next;
        }
        String reversedStr = new StringBuilder(str).reverse().toString();
        return str.equals(reversedStr);

        
    
    
    }

    public ListNode removeElements(ListNode head, int val) {
        ListNode start  = head;
        ListNode prev = null;
        while(head != null){
            if(head.val == val){
                if(prev == null){
                    start = start.next;
                    head = head.next;
                }
                else{
                    prev.next = head.next;
                    head = head.next;
                }
            }
            else{

                prev = head;
                head = head.next;
            }
        }
        return start;
    }



    public double minimumAverage(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        double currAvg = 0;
        double minAvg = Double.MAX_VALUE;
        for(int i = 0; i < n/2; i++) {
            
            currAvg = (double)((nums[i]+nums[n-i-1]) / 2);
            System.out.println(currAvg);
            minAvg = Math.min(minAvg, currAvg);
        }

        return minAvg;
    }


    

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if(root == null){
            return null;
        }

        if(root.left == null && root.right == null && root.val == target){
            return null;
        }

        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);

        if(root.left == null && root.right == null && root.val == target){
            return null;
        }

        return root;



    }















}
