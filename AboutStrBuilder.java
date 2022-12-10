package Seminar2;

import java.util.Scanner;

/**
 * Дано два числа, например 3 и 56, необходимо составить следующие строки: 3 + 56 = 59 3 – 56 = -53 3 * 56 = 168
 * Используем метод StringBuilder.append().
 */
public class AboutStrBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите 2 числа, затем операцию + - * /");
        int a = scan.nextInt();
        int b = scan.nextInt();
        int res;
        String op = scan.next();
        try {
            switch (op){
                case "+":   res = a + b;
                            sb.append(a); sb.append("+"); sb.append(b); sb.append("="); sb.append(res);
                            break;
                case "-":   res = a - b;
                            sb.append(a); sb.append("-"); sb.append(b); sb.append("="); sb.append(res);
                            break;
                case "*":   res = a * b;
                            sb.append(a); sb.append("*"); sb.append(b); sb.append("="); sb.append(res);
                            break;
                case "/":   res = a / b;
                            sb.append(a); sb.append("/"); sb.append(b); sb.append("="); sb.append(res);
                            break;
                default:
                            System.out.println("что то я не знаю такой операции");
                            break;
            }
        }
        catch(Exception e){
            System.out.println("Делим на ноль?");
        }
        System.out.println(sb+"   А это результат работы StringBuilder");
    }
}
