//First Level Question
public class Solution {
    /**
     * @param nums: A list of integers
     * @return: A integer indicate the sum of max subarray
     */
    public int maxSubArray(int[] nums) {
        // write your code
        int max= 0;
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> temp = new ArrayList<Integer>();
        sub(result,nums,0,temp,max);
        return max;
    }
    
    public void sub(ArrayList<ArrayList<Integer>> result,int[] nums,int pos,ArrayList<Integer> temp,int max){
        int sum = 0;
        for(Integer n:temp){
            sum=sum+n.intValue();
        }
        max = Math.max(sum,max);
        result.add(temp);
        
        for(int i=pos;i<nums.length;i++){
            temp.add(nums[pos]);
            sub(result,nums,pos+1,temp,max);
            temp.remove(temp.size()-1);
        }
        
    }
}
