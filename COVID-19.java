import java.util.Scanner;

public class Covid19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // قراءة المدخلات
        int n = scanner.nextInt(); // عدد المقاعد
        int k = scanner.nextInt(); // عدد الطلاب الواقفين

        int[] seats = new int[n];
        for (int i = 0; i < n; i++) {
            seats[i] = scanner.nextInt();
        }

        // توزيع الطلاب الجالسين
        for (int i = 0; i < n; i++) {
            if (k == 0) break; // إذا تم توزيع جميع الطلاب الواقفين

            // إذا كان المقعد فارغًا والجهتين ليست مشغولة
            if (seats[i] == 0 &&
                (i == 0 || seats[i - 1] == 0) &&
                (i == n - 1 || seats[i + 1] == 0)) {
                seats[i] = 1; // اجلس طالبًا في هذا المقعد
                k--;          // قلل عدد الطلاب الواقفين
            }
        }

        // إخراج النتيجة
        System.out.println(k == 0 ? "YES" : "NO");

        scanner.close();
    }
}
