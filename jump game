public class Solution {
    public boolean canJump(int[] A) {
        if(A==null||A.length==0) return false;
        else if(A.length==1) return true;
        
        int index=0;
        for(int i=0;i<A.length-1;i++){
            if(i<=index){
                index=Math.max(index,A[i]+i);
                if(index>=A.length-1) return true;
            }
        }
        return false;
        /*
        return jump(0,A);
    }
    
    public boolean jump(int index,int[] A){
        if(A[index]==0) return false;
        if((A[index]+index)>=A.length-1) return true;
        else{
            for(int i=1;i<=A[index];i++){
                return jump(index+i,A);
            }
        }
        */
    }
}
