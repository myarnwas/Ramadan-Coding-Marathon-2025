import java.util.Scanner;

public class QuadraticRoots {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // قراءة المدخلات
        double A = scanner.nextDouble();
        double B = scanner.nextDouble();
        double C = scanner.nextDouble();
        
        // إذا كان A و B و C جميعها صفرًا
        if (A == 0 && B == 0 && C == 0) {
            System.out.println(-1);
        } 
        // إذا كان A و B صفرًا فقط
        else if (A == 0 && B == 0) {
            System.out.println(0);
        } 
        // إذا كانت المعادلة خطية (A = 0)
        else if (A == 0) {
            System.out.println(1);
            System.out.printf("%.6f\n", -C / B);
        } 
        // إذا كانت معادلة تربيعية
        else {
            double discriminant = B * B - 4 * A * C;
            
            if (discriminant < 0) {
                // لا توجد جذور حقيقية
                System.out.println(0);
            } else if (discriminant == 0) {
                // جذر واحد فقط
                double root = -B / (2 * A);
                System.out.println(1);
                System.out.printf("%.6f\n", root);
            } else {
                // جذران حقيقيان
                double root1 = (-B - Math.sqrt(discriminant)) / (2 * A);
                double root2 = (-B + Math.sqrt(discriminant)) / (2 * A);
                System.out.println(2);
                System.out.printf("%.6f\n", Math.min(root1, root2));
                System.out.printf("%.6f\n", Math.max(root1, root2));
            }
        }
        
        scanner.close();
    }
}
