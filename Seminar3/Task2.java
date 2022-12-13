package Seminar3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * *Сортировка списка.
 */
public class Task2 {
    public static void main(String[] args) {
        ArrayList<String> colors = new ArrayList<String>();
        colors.add("Red");
        colors.add("Orange");
        colors.add("Yellow");
        colors.add("Green");
        colors.add("Cyan");
        colors.add("Blue");
        colors.add("Purple");
        System.out.print(colors);
        Collections.sort(colors);
        System.out.println("\n"+colors);
    }
}
