import java.util.Scanner;

public class CashOutEfficiently {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // قراءة المبلغ المطلوب
        int n = scanner.nextInt();

        // الفئات الورقية
        int[] denominations = {100, 20, 10, 5, 1};
        int billsCount = 0;

        // حساب الحد الأدنى لعدد الأوراق
        for (int denomination : denominations) {
            billsCount += n / denomination; // عدد الأوراق من هذه الفئة
            n %= denomination; // المبلغ المتبقي بعد استخدام هذه الفئة
        }

        // طباعة النتيجة
        System.out.println(billsCount);

        scanner.close();
    }
}
