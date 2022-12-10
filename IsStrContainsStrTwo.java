package Seminar2;

/**
 * Напишите программу, чтобы найти вхождение в строке (содержащей все символы другой строки).
 */
public class IsStrContainsStrTwo {
    static class IsContains{   //создадим класс для формирования текстовых объектов
        String txt;
        public void setTxt(String txt){    //сеттеры и геттеры, куда без них нынче? :)
            this.txt = txt;
        }
        public String getTxt(){
            return txt;
        }
        public void isInside(String txt1, String txt2){    //метод для определения входит ли подстрока в строку
            if (txt1.contains(txt2)){
                System.out.println("Строка -"+txt2+" входит в состав строки -"+txt1);
            }
            else System.out.println("строки различны");
        }
        public void isInside(String txt1, String txt2, String txt3){ // перегрузим метод для сравнения 3 строк
            if (txt1.contains(txt2)){
                System.out.println("Строка - "+"\""+txt2+"\""+" входит в состав строки - "+"\""+txt1+"\"");
            }
            else System.out.println("Строка - "+"\""+txt2+"\""+" не входит в состав "+"\""+txt1+"\"");
            if (txt1.contains(txt3)){
                System.out.println("Строка - "+"\""+txt3+"\""+" входит в состав строки - "+"\""+txt1+"\"");
            }
            else System.out.println("Строка - "+"\"" +txt3+"\""+" не входит в состав "+"\""+txt1+"\"");
        }
    }
    public static void main(String[] args) {
        IsContains slovo1 = new IsContains();  //создаем объект нашего класса
        slovo1.setTxt("Проверка на вхождение строк. Это строка главная"); //определим его значение
        IsContains s = new IsContains(); // аналогично
        s.setTxt("ение");
        IsContains s3 = new IsContains();
        s3.setTxt("Труляля");
        s.isInside(slovo1.getTxt(), s.getTxt(), s3.getTxt());  //вызываем метод с тремя параметрами
    }
}
