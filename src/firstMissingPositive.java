import java.util.Arrays;


public class firstMissingPositive {
	 /**    
     * @param A: an array of integers
     * @return: an integer
     */
    public int firstMissingPositive(int[] A) {
        if(A.length==0){
            return 1;
        }
        Arrays.sort(A);
        int j=0;
        for(int i=0;i<A.length;i++){
            if(i>0&&A[i]==A[i-1]){
                continue;
            }
            if(A[i]>0&&++j!=A[i]){
                return j;
            }
        }
        if(A[A.length-1]>0){
            return A[A.length-1]+1;
        }
        return 1;
    }
}
