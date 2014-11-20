public class Solution {
    public int findMin(int[] num) {
        return find(num,0,num.length-1);
    }
    
    
    public int find(int[] num,int left,int right){
        
        int mid = left+(right-left)/2;
        if(mid==left) return Math.min(num[left],num[right]);
        
        if(num[mid]<num[right]) return find(num,left,mid);
        else return find(num,mid,right);
        
        
    }
}
