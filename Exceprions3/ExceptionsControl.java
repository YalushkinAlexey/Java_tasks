package Excepts3;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionsControl {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите ФИО в формате (фамилия имя отчество) номер телеф. дату рождения (дд.мм.гггг). пол (m/f)");
        String str = sc.nextLine();

//        String str = "Иванов Иван Иванович m 30.12.1980 898903";
//        String str1 = "Иванов Иван Иванович mf 01.01.1980 898903";
        if (checkCount(str)){
            verifyStr(str);
        }
    }
    static boolean checkCount(String s){
        String[] strAr = s.split(" ");
        boolean flag = false;
        if (strAr.length < 6 ){
            throw new RuntimeException("Мало входных данных");
        }
        else if (strAr.length > 6){
            throw new RuntimeException("Лишние данные на входе");
        }
        return true;
    }
    static void verifyStr(String s){
        String[] strAr = s.split(" ");
        String birth = null;
        String gender = null;
        String fio = "";
        int phone = 0;
        for (int i = 0; i < strAr.length; i++) {
            if (strAr[i].length() == 1 && gender == null){
                // Отправим на проверку gendera
                verifyGender(strAr[i]);
                gender = strAr[i];
            }
            if (strAr[i].contains(".") && birth == null) {
                if (verifyBirth(strAr[i])){
                    birth = strAr[i];
                }
            }
            if (strAr[i].length() > 1 && Character.isLetter(strAr[i].charAt(1))){
                for (int j = 0; j < strAr[i].length(); j++) {
                   // System.out.println(strAr[i]);
                    if( !Character.isLetter(strAr[i].charAt(j))){
                        throw new RuntimeException("в ФИО где-то закралась ошибка");
                    }
                }
                fio += strAr[i]+" ";
            }
            if (Character.isDigit(strAr[i].charAt(0)) && Character.isDigit(strAr[i].charAt(1)) && Character.isDigit(strAr[i].charAt(2))) {
                try {
                    phone = Integer.parseInt(strAr[i]);
                } catch (NumberFormatException e) {
                    throw new RuntimeException(e + "  Ой, что то не так с телефоном");
                }
            }
        }
        String man = fio+birth+" "+phone+" "+gender;
        if (fio != null && birth != null && phone != 0 && gender != null && man.split(" ").length == 6){
            System.out.println(man);
            writeMan(man);
        }
        else throw new RuntimeException("перепроверьте данные на входе");

    }  //"(0?[1-9]|1[012]) [/.-] (0?[1-9]|[12][0-9]|3[01]) [/.-] ((19|20)\\d\\d)"
    static boolean verifyBirth(String s){
//        Matcher m = Pattern.compile("(0?[1-9]|1[012]) [/.-] (0?[1-9]|[12][0-9]|3[01]) [/.-] ((19|20)\\d\\d)").matcher(s);
//        if (m.find()) {return true;}
//        else {
//            System.out.println(s);
//            throw new RuntimeException("проверьте введенную дату");
//        }
        try {
            Calendar calendar = new GregorianCalendar();
            SimpleDateFormat df=new SimpleDateFormat("dd.MM.yyyy");
            df.setLenient(false);
            calendar.setTime(df.parse(s));
            return true;
        }
        catch (Exception e) {
            throw new RuntimeException("что то с датой не так");
        }
    }
    static boolean verifyGender(String s){
        String g = s.charAt(0)+"";
        if (s.length()==1 && (g.equalsIgnoreCase("m") || g.equalsIgnoreCase("f"))){
            return true;
        }
        else throw new RuntimeException("пол указан не корректно");
    }
    static void writeMan(String man){
        String fName = man.substring(0, man.indexOf(" "))+".txt";
        try (FileWriter writer = new FileWriter(fName, true)) { //Параметр true дозаписывает в файл однофамильцев
            writer.write(man);
            writer.append('\n');
            writer.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
