public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null||triangle.get(0)==null) return -1;
        List<Integer> ll=triangle.get(triangle.size()-1);
        int[] l=new int[triangle.size()];
        
        for(int k=0;k<triangle.size();k++){
            l[k]=ll.get(k);
        }
        
        for(int i=triangle.size()-1;i>=1;i--){
            for(int j=0;j<i;j++){
                l[j]=Math.min(l[j],l[j+1])+triangle.get(i-1).get(j);
            }
        }
        return l[0];
    }
}
