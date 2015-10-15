public class fastPower {
	/*
	 * @param a, b, n: 32bit integers
	 * 
	 * @return: An integer
	 */
	int fastPower(int a, int b, int n) {
		if (n == 1) {
            return a % b;
        }
        if (n == 0) {
            return 1 % b;
        }
        
        long product = fastPower(a, b, n >> 1);
        product = (product * product) % b;
        if (n % 2 == 1) {
            product = (product * a) % b;
        }
        return (int) product;
	}

}
