public class removeElement {
	/**
	 * @param A
	 *            : A list of integers
	 * @param elem
	 *            : An integer
	 * @return: The new length after remove
	 */
	public int removeElement(int[] A, int elem) {
		int j=0;
        for(int i=0;i<A.length;i++){
            if(A[i]!=elem){
                A[j++]=A[i];
            }
        }
        return j;
	}
}
