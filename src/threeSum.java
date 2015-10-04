import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class threeSum {
	/**
     * @param numbers : Give an array numbers of n integer
     * @return : Find all unique triplets in the array which gives the sum of zero.
     */
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        Arrays.sort(numbers);
        HashSet<String> tmp=new HashSet<String>();
        ArrayList<ArrayList<Integer>> res=new ArrayList<ArrayList<Integer>>();
        int N = numbers.length;
        for (int i = 0; i < N; i++) {
            for (int j = i+1; j < N; j++) {
                for (int k = j+1; k < N; k++) {
                    if (numbers[i] + numbers[j] + numbers[k] == 0) {
                        String tmpstr=numbers[i] +" "+ numbers[j]+""+ numbers[k];
                        if(tmp.contains(tmpstr)){
                            continue;
                        }
                        tmp.add(tmpstr);
                        ArrayList<Integer> resItem=new ArrayList<Integer>();
                        resItem.add(numbers[i]);
                        resItem.add(numbers[j]);
                        resItem.add(numbers[k]);
                        res.add(resItem);
                    }
                }
            }
        }
      
        return res;
        
    }
}
