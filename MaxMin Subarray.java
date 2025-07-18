import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // عدد العناصر في الترتيب
        int[] p = new int[n];
        
        // قراءة الترتيب
        for (int i = 0; i < n; i++) {
            p[i] = sc.nextInt();
        }

        // لحساب عدد المصفوفات الفرعية
        long result = 0;
        
        // نحسب عدد المصفوفات الفرعية حيث maxpos > minpos
        // تتطلب هذه العملية مكدسات للحفاظ على العناصر 
        // التي تحتوي على أكبر وأصغر العناصر في النطاق
        for (int i = 0; i < n; i++) {
            int maxPos = i, minPos = i;  // تهيئة maxPos و minPos عند الفهرس الحالي
            
            for (int j = i; j < n; j++) {
                // تحديث maxPos و minPos بناءً على الفهرس الحالي
                if (p[j] > p[maxPos]) maxPos = j;
                if (p[j] < p[minPos]) minPos = j;
                
                // إذا كانت maxPos أكبر من minPos، نقوم بزيادة النتيجة
                if (maxPos > minPos) result++;
            }
        }

        // طباعة النتيجة النهائية
        System.out.println(result);
    }
}
