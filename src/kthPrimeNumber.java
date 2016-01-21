import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * Created by winney on 16/1/18.
 */
public class kthPrimeNumber {
    /**
     * @param k: The number k.
     * @return: The kth prime number as description.
     */
    public long kthPrimeNumber(int k) {
        // write your code here
        PriorityQueue<Long> Q = new PriorityQueue<Long>();
        HashMap<Long, Boolean> inQ = new HashMap<Long, Boolean>();
        Long[] primes = new Long[3];
        primes[0] = Long.valueOf(3);
        primes[1] = Long.valueOf(5);
        primes[2] = Long.valueOf(7);
        for (int i = 0; i < 3; i++) {
            Q.add(primes[i]);
            inQ.put(primes[i], true);
        }
        Long number = Long.valueOf(0);
        for (int i = 0; i < n; i++) {
            number = Q.poll();
            for (int j = 0; j < 3; j++) {
                if (!inQ.containsKey(primes[j] * number)) {
                    Q.add(number * primes[j]);
                    inQ.put(number * primes[j], true);
                }
            }
        }
        return number;

    }
}
