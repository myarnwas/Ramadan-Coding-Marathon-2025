import java.util.Scanner;

public class HazemDecreasingNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // قراءة المدخلات
        long n = scanner.nextLong();
        int k = scanner.nextInt();

        // تنفيذ العملية k مرة
        for (int i = 0; i < k; i++) {
            if (n % 10 != 0) {
                // إذا كان الرقم الأخير غير صفري، ننقص 1
                n -= 1;
            } else {
                // إذا كان الرقم الأخير صفري، نقسم الرقم على 10
                n /= 10;
            }
        }

        // طباعة النتيجة
        System.out.println(n);
        scanner.close();
    }
}
