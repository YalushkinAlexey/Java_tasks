package Seminar2;

/**
 * Напишите программу, чтобы проверить, являются ли две данные строки вращением друг друга (вхождение в обратном порядке).
 */
public class IsPalindrom {
    // Дано 2 строки:  "абыр" и "рыба"
    // для решения необходимо развернуть одну из них и сравнить, если equals выдаст true значит одинаковые
    // Поэтому сразу выполним задачу палиндром, а чтобы сравнить 2 строки достаточно str1.equals(str2)
    //самый простой метод.  Другой вариант в цикле перебрать по символьно через charAt()
    static String reverse(String str){
        return new StringBuilder(str).reverse().toString();
    }
    // разворачиваем в ручную оО
    static void heavyTry(String str){
        String str1 = "";
        for (int i = 0;  i <str.length(); i++) {
            str1 = str.charAt(i)+str1;
        }
        if (str1.equals(str)){
            System.out.println(str + " - палиндром");
        }
        else System.out.println(str + " - не палиндром");
    }

    public static void main(String[] args) {
        String str = "бурлак";
        String tempStr = reverse(str);
        if (str.equals(tempStr)){
            System.out.println(str + " - палиндром");}
        else System.out.println(str + " - не палиндром");
        String str1 = "казак";
        String tempStr1 = reverse(str1);
        if (str1.equals(tempStr1)){
            System.out.println(str1 + " - палиндром");}
        else System.out.println(str1 + " - не палиндром");

        String str2 = "комок";          //для 2го  метода
        heavyTry(str2);
    }
}
