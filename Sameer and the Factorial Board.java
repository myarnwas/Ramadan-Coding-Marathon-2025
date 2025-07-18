import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        while (t-- > 0) {
            int n = scanner.nextInt();
            int d = scanner.nextInt();
            List<Integer> res = new ArrayList<>();
            // Always include 1
            res.add(1);
            // Check for 3, 9
            long factorial = 1; // n >=2, but for n >=7, 7! is 5040, etc., but we can't compute n! directly for large n.
            // But for 3 and 9, the sum is d * n!. So if d * n! mod 3 ==0, then 3 is a divisor.
            // Since n >=2, 2! is 2, etc. For n >=3, n! is divisible by 3.
            if (n >= 3 || (d % 3 == 0)) {
                // n! for n >=3 includes 3, so d * n! is divisible by 3.
                if (!res.contains(3)) res.add(3);
            } else {
                // n is 2, n! is 2. Sum is 2d. Check if 2d mod 3 ==0.
                if ((2 * d) % 3 == 0) {
                    if (!res.contains(3)) res.add(3);
                }
            }
            // For 9, similarly, if d * n! mod 9 ==0.
            if (n >= 6 || (d % 9 == 0)) {
                // n! for n >=6 includes 9 (since 6! =720 which is 9*80)
                if (!res.contains(9)) res.add(9);
            } else {
                // compute n! and check d * n! mod 9.
                long fact = 1;
                for (int i = 2; i <= n; i++) {
                    fact *= i;
                }
                if ((d * fact) % 9 == 0) {
                    if (!res.contains(9)) res.add(9);
                }
            }
            // Check for 5: the digit must be 5.
            if (d == 5) {
                res.add(5);
            }
            // Check for 7: if n >=7, always divisible.
            if (n >= 7) {
                res.add(7);
            } else {
                // Compute the number modulo 7.
                // The number is d repeated n! times. It's d * (10^{n!} -1)/9 mod7.
                // Compute (10^{n!} -1)/9 mod7 = ( (10 mod7)^{n!} -1 ) * inv(9 mod7) mod7.
                // 10 mod7 is 3. 9 mod7 is 2. inv(2) mod7 is 4 since 2*4=8 mod7=1.
                // So expression is (3^{n!} -1)*4 mod7.
                // The number mod7 is d * ( (3^{n!} -1)*4 mod7 ) mod7.
                // So if this is 0, then divisible.
                // Compute n! for n up to 6 (since n <7).
                int fn = 1;
                for (int i = 2; i <= n; i++) {
                    fn *= i;
                }
                long pow3 = powMod(3, fn, 7);
                long term = (pow3 - 1) %7;
                term = (term *4) %7;
                term = (term * d) %7;
                if (term ==0) {
                    res.add(7);
                }
            }
            // Prepare the output
            Collections.sort(res);
            StringBuilder sb = new StringBuilder();
            for (int num : res) {
                sb.append(num).append(" ");
            }
            String output = sb.toString().trim();
            System.out.println(output);
        }
    }
    
    private static long powMod(long base, long exponent, long mod) {
        long result =1;
        base = base % mod;
        while (exponent >0) {
            if (exponent %2 ==1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exponent = exponent /2;
        }
        return result;
    }
}
