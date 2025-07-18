import java.util.Scanner;

public class MaxFib {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // قراءة عدد حالات الاختبار
        int t = scanner.nextInt(); // عدد الحالات (1 ≤ t ≤ 500)

        // معالجة كل حالة اختبار
        while (t-- > 0) {
            // قراءة القيم الأربعة
            int a1 = scanner.nextInt();
            int a2 = scanner.nextInt();
            int a4 = scanner.nextInt();
            int a5 = scanner.nextInt();

            int maxFib = 0;

            // تجربة جميع القيم الممكنة لـ a3
            // العلاقة الأولى: a4 = a2 + a3
            int a3_case1 = a4 - a2;

            // العلاقة الثانية: a5 = a3 + a4
            int a3_case2 = a5 - a4;

            // تحقق من كل حالة لـ a3
            maxFib = Math.max(maxFib, calculateFibonacciness(a1, a2, a3_case1, a4, a5));
            maxFib = Math.max(maxFib, calculateFibonacciness(a1, a2, a3_case2, a4, a5));

            // طباعة النتيجة لهذه الحالة
            System.out.println(maxFib);
        }

        scanner.close();
    }

    // دالة لحساب عدد العلاقات الفيبوناتشية المحققة
    private static int calculateFibonacciness(int a1, int a2, int a3, int a4, int a5) {
        int count = 0;

        if (a3 == a1 + a2) count++; // العلاقة الأولى
        if (a4 == a2 + a3) count++; // العلاقة الثانية
        if (a5 == a3 + a4) count++; // العلاقة الثالثة

        return count;
    }
}
