package Seminar2;
/**
 * *Замените символ “=” на слово “равно”. Используйте методы StringBuilder.replace().
 */
public class ReplaceByStringBuiderHardVersion {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Сколько раз нужно указать символ = ? ");
        sb.append("Предположим, что 2 символа = достаточно.");
        sb.append(" Добавим = и еще раз = ");
        System.out.println(sb);
        for (int i = 0; i < sb.length(); i++) {
            int ind = sb.indexOf("=");
            if (ind >= 0){
                sb.replace(ind, ind+1, "равно");
            }
        }
        System.out.println(sb);
    }
}
