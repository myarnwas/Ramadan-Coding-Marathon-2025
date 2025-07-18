import java.util.Scanner;

public class RegexiaScrolls {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String p = scanner.nextLine();
        System.out.println(isMatch(s, p) ? "YES" : "NO");
    }

    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        
        // Initialize the first row (s is empty)
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == '.' || pc == sc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    char prevP = p.charAt(j - 2);
                    dp[i][j] = dp[i][j - 2]; // zero occurrence
                    if (prevP == '.' || prevP == sc) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // one or more occurrence
                    }
                }
            }
        }
        return dp[m][n];
    }
}
