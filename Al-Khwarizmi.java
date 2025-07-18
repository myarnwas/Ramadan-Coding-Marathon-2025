import java.math.BigInteger;
import java.util.Scanner;

public class ZeroFreeNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String numStr = scanner.next();
        BigInteger t = new BigInteger(scanner.next());
        
        String result = findZeroFreeNumber(numStr, t);
        System.out.println(result);
    }
    
    private static String findZeroFreeNumber(String numStr, BigInteger t) {
        BigInteger current = new BigInteger(numStr);
        BigInteger one = BigInteger.ONE;
        
        while (true) {
            String s = current.toString();
            if (containsZero(s)) {
                current = current.add(one);
                continue;
            }
            
            BigInteger product = computeProduct(s);
            if (product.mod(t).equals(BigInteger.ZERO)) {
                return s;
            }
            
            current = current.add(one);
            // To prevent infinite loops in cases where it's not possible (though problem says if no such number, return -1)
            // However, for very large numbers, this might not be feasible, but given constraints, perhaps handled.
            // But need to handle cases where t is 1, any number is acceptable as long as no zeros.
            if (current.toString().length() > numStr.length() + 1) {
                // To prevent infinite loops in case of overflow, though problem may not have such cases
                return "-1";
            }
        }
    }
    
    private static boolean containsZero(String s) {
        for (char c : s.toCharArray()) {
            if (c == '0') {
                return true;
            }
        }
        return false;
    }
    
    private static BigInteger computeProduct(String s) {
        BigInteger product = BigInteger.ONE;
        for (char c : s.toCharArray()) {
            int digit = c - '0';
            product = product.multiply(BigInteger.valueOf(digit));
        }
        return product;
    }
}
