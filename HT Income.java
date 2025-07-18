import java.util.ArrayList;
import java.util.Scanner;

public class HonestTechnologyIncome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // قراءة عدد السنوات
        int n = sc.nextInt();
        int[] income = new int[n];

        // قراءة الدخل لكل سنة
        for (int i = 0; i < n; i++) {
            income[i] = sc.nextInt();
        }

        // قائمة لتخزين السنوات التي تطابق النمو المثالي
        ArrayList<Integer> selectedYears = new ArrayList<>();
        int expectedIncome = 1; // الدخل المتوقع الأول

        for (int i = 0; i < n; i++) {
            if (income[i] == expectedIncome) {
                // إذا كان الدخل يطابق النمو المثالي، أضف السنة إلى القائمة
                selectedYears.add(2000 + i + 1);
                expectedIncome++; // انتقل إلى القيمة التالية
            }
        }

        // طباعة النتيجة
        System.out.println(selectedYears.size());
        for (int year : selectedYears) {
            System.out.print(year + " ");
        }
    }
}
