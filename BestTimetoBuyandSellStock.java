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


//THIRD QUESTION
class Solution {
    /**
     * @param prices: Given an integer array
     * @return: Maximum profit
     */
    public int maxProfit(int[] prices) {
        // write your code here
        if(prices==null|prices.length<=1){
            return 0;
        }
        int[] firstMaxProfit= new int[prices.length];
        firstMaxProfit[0]=0;
        int minPrice = prices[0];
        int secondMinPrice = prices[1];
        //firstMaxProfit[1]=Math.max(0,prices[1]-prices[0]);
        int[] secondMaxProfit = new int[prices.length];
        secondMaxProfit[0]=0;
        //secondMaxProfit[1]=firstMaxProfit[1];
        
        int max = 0;
        int cur=0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i]<minPrice) minPrice = prices[i];
            cur = Math.max(0,prices[i]-minPrice);
            firstMaxProfit[i]=Math.max(cur,firstMaxProfit[i-1]);
            for(int j = i;j<prices.length;j++){
                secondMinPrice=prices[i];
                if(prices[j]<secondMinPrice) secondMinPrice=prices[j];
                cur = Math.max(0,prices[j]-secondMinPrice);
                secondMaxProfit[j] = Math.max(cur,secondMaxProfit[j-1]);
            }
            max = Math.max(max,firstMaxProfit[i]+secondMaxProfit[prices.length-1]);
            secondMaxProfit=new int[prices.length]; 
        }
        
        return max;
    }
}
