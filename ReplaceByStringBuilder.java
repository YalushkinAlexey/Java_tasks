package Seminar2;

/**
 * Замените символ “=” на слово “равно”. Используйте методы StringBuilder.insert(),StringBuilder.deleteCharAt().
 */
public class ReplaceByStringBuilder {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("Сколько раз нужно указать символ = ? ");
        sb.append("Предположим, что 2 символа = достаточно.");
        System.out.println(sb);
        for (int i = 0; i < sb.length(); i++) {
            int ind = sb.indexOf("=");
            if (ind > 0){
                sb.deleteCharAt(ind);
                sb.insert(ind, "равно");
            }
        }
        System.out.println(sb);

    }
}
