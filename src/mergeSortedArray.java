
public class mergeSortedArray {
	/**
     * @param A: sorted integer array A which has m elements, 
     *           but size of A is m+n
     * @param B: sorted integer array B which has n elements
     * @return: void
     */
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        m--;
        n--;
        int i=m+n+1;
        while(m>=0&&n>=0){
            if(A[m]>B[n]){
                A[i--]=A[m--];
            }else{
                A[i--]=B[n--];
            }
        }
        while(m>=0){
            A[i--]=A[m--];
        }
        while(n>=0){
            A[i--]=B[n--];
        }
    }
}
