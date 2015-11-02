//First Question
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

//SECOND QUESTION
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices==null||prices.length<=1){
            return 0;
        }
        int[] maxCurProfit = new int[prices.length];
        maxCurProfit[0]=0;
        //maxCurProfit[1]=Math.max(0,prices[1]-prices[0]);
        int lastProfit = 0;
        for(int i = 1;i<prices.length;i++){
            
            maxCurProfit[i]=0;
            for(int j = 0;j<i;j++){
                 lastProfit = Math.max(prices[i]-prices[j],0);
                 
                 maxCurProfit[i]=Math.max(maxCurProfit[i],maxCurProfit[j]+lastProfit);
            }
        }
        
        return maxCurProfit[prices.length-1];
    }
}
