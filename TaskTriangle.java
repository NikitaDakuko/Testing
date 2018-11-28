import java.util.Scanner;

public class TaskTriangle {
    public static boolean triangleTest(int a, int b, int c) {
        if ((a + b) > c && (a + c) >  b && (b + c) > a)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int s1 = sc.nextInt();
        int s2 = sc.nextInt();
        int s3 = sc.nextInt();

        System.out.println(triangleTest(s1, s2, s3) ? "Треугольник существует.":"Треугольник не существует.");
    }
}
