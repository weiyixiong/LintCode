
public class findFirstBadVersion {
	/**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        int i=1;
        int j=n;
        while(i<=j){
            int mid=(i+j)/2;
            if(VersionControl.isBadVersion(mid)){
                 j=mid-1;
            }else{
                 i=mid+1;
            }
        }
        return i;
    }
}
