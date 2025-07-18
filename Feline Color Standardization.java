import java.util.Scanner;

public class FelineColorStandardization {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // قراءة عدد القطط وسلسلة الألوان
        int n = scanner.nextInt();
        String s = scanner.next();

        // إذا كان هناك قطة واحدة فقط
        if (n == 1) {
            System.out.println("YES");
            return;
        }

        // التحقق من وجود قطتين متجاورتين لهما نفس اللون
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                System.out.println("YES");
                return;
            }
        }

        // إذا لم نجد أي قطتين متجاورتين بنفس اللون
        System.out.println("NO");
    }
}
