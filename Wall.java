import java.util.Scanner;

public class WoodenWall {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // إدخال القيم
        int n = scanner.nextInt(); // عدد الألواح
        int k = scanner.nextInt(); // عرض الممر المطلوب
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = scanner.nextInt();
        }
        
        // إيجاد أصغر مجموع باستخدام نافذة منزلقة
        int minSum = 0; // أقل مجموع
        int currentSum = 0; // المجموع الحالي
        int startIndex = 0; // بداية الشريحة
        
        // حساب مجموع أول k ألواح
        for (int i = 0; i < k; i++) {
            currentSum += h[i];
        }
        minSum = currentSum;
        
        // تمرير النافذة عبر باقي الألواح
        for (int i = k; i < n; i++) {
            currentSum += h[i] - h[i - k]; // تحديث المجموع
            if (currentSum < minSum) {
                minSum = currentSum;
                startIndex = i - k + 1; // تحديث البداية
            }
        }
        
        // طباعة النتيجة (نضيف 1 لتحويل المؤشر إلى أساس 1)
        System.out.println(startIndex + 1);
    }
}
