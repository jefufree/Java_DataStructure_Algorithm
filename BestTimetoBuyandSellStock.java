public class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices==null||prices.length<=1){
            return 0;
        }
        int minprice = prices[0];
        int max = prices[1]-prices[0];
        int cur = 0;
        
        for(int i = 1;i<prices.length;i++){
            if(prices[i]<minprice){
                minprice = prices[i];
            }else{
                cur = prices[i]-minprice;
                max = Math.max(cur,max);
            }
        }
        if(max <0) return 0;
        else return max;
        
    }
}
