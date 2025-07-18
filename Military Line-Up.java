import java.util.Scanner;

public class MilitaryLineUp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // قراءة عدد الجنود
        int n = scanner.nextInt();
        int[] heights = new int[n];

        // قراءة أطوال الجنود
        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        // إيجاد أطول جندي (الظهور الأول) وأقصر جندي (الظهور الأخير)
        int maxIndex = 0; // موقع أطول جندي
        int minIndex = 0; // موقع أقصر جندي

        for (int i = 0; i < n; i++) {
            if (heights[i] > heights[maxIndex]) {
                maxIndex = i;
            }
            if (heights[i] <= heights[minIndex]) {
                minIndex = i;
            }
        }

        // حساب عدد التبديلات المطلوبة
        int swaps = maxIndex + (n - 1 - minIndex);

        // تعديل التبديلات إذا كان أطول جندي أمام أقصر جندي
        if (maxIndex > minIndex) {
            swaps--;
        }

        // طباعة النتيجة
        System.out.println(swaps);

        scanner.close();
    }
}
