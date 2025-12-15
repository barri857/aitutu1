package Javaproject;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // 1. Scanner объектісін құрамыз
        Scanner sc = new Scanner(System.in);
        String n = "Nurasyl";
        int a  = sc.nextInt();
        int b = sc.nextInt();

        System.out.println(a + b);
        System.out.println(a * b);
        System.out.println(n);
        sc.close();
    }
}
