package Seminar2;

/**
 *      *Напишите программу, чтобы перевернуть строку с помощью рекурсии.
 */
// Описывать особо нечего, "опускаемся" на самое дно, и собираем строку
public class StringRecursion {
    static String strRec(String s, int len){
        if (len == 0){
            return s.charAt(len)+"";
        }
        else {
            return s.charAt(len)+strRec(s, len - 1);
        }
    }
    public static void main(String[] args) {
        String str = "123456789";    // исходная строка
        int len = str.length();
        System.out.println(str);
        str = strRec(str, len-1);
        System.out.println(str);
    }
}
