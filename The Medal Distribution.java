import java.util.Scanner;

public class MedalDistribution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // قراءة عدد المحاربين
        int n = scanner.nextInt();
        
        // قراءة تصنيفات المحاربين
        int[] ratings = new int[n];
        for (int i = 0; i < n; i++) {
            ratings[i] = scanner.nextInt();
        }

        // مصفوفة لتخزين عدد الميداليات لكل محارب، تبدأ بالقيمة 1
        int[] medals = new int[n];
        for (int i = 0; i < n; i++) {
            medals[i] = 1;
        }

        // المرحلة الأولى: المرور من اليسار إلى اليمين
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                medals[i] = medals[i - 1] + 1;
            }
        }

        // المرحلة الثانية: المرور من اليمين إلى اليسار
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                medals[i] = Math.max(medals[i], medals[i + 1] + 1);
            }
        }

        // حساب العدد الإجمالي للميداليات
        int totalMedals = 0;
        for (int i = 0; i < n; i++) {
            totalMedals += medals[i];
        }

        // طباعة النتيجة
        System.out.println(totalMedals);
        
        scanner.close();
    }
}
