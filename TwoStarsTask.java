package Seminar2;

import java.util.Random;

/**
 * **Сравнить время выполнения пунка 6 со строкой содержащей 10000 символов "=" средствами String и StringBuilder.
 */
public class TwoStarsTask {
    static String filStr(){
        Random rand = new Random();
        String str = "";
        for (int i = 0; i <= 10000 ; i++) {
            str = str + (char)(rand.nextInt(78)+34);
        }
        return str;
    }
    static String filling(){
        String result = String.valueOf('=').repeat(10000);
        return result;
    }
 //   static String
    static void replStr(String str){
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int i = 0; i < sb.length(); i++) {
            int ind = sb.indexOf("=");
            if (ind >= 0){
                sb.replace(ind, ind+1, "равно");
            }
        }
        System.out.println(sb);
    }
    static void replString(String str){
        str = str.replaceAll("=","равно");
        System.out.println(str);
    }

    public static void main(String[] args) {
/**
*    Тут полностью случайное заполнение
*/
//        long st = System.currentTimeMillis();
//        String s = filStr();
//        System.out.println(s);
//        replStr(s);
//        long end = System.currentTimeMillis();
//        System.out.println(end - st+ "  Работал StringBuilder");
//
//        long st2 = System.currentTimeMillis();
//        String s2 = filStr();
//        System.out.println(s2);
//        replString(s2);
//        long end2 = System.currentTimeMillis();
//        System.out.println(end2-st2 + " работал метод напрямую со String");
/**
 * Тут заполнение строки только символами "="
 */
        long st = System.currentTimeMillis();
        String s = filling();
        System.out.println(s);
        replStr(s);
        long end = System.currentTimeMillis();
        System.out.println(end - st+ "  Работал StringBuilder");

        long st2 = System.currentTimeMillis();
        String s2 = filling();
        System.out.println(s2);
        replString(s2);
        long end2 = System.currentTimeMillis();
        System.out.println(end2-st2 + " работал метод напрямую со String");
    }
}
