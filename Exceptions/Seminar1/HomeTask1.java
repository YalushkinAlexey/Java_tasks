package Excepts;

/**
 * Реализуйте 3 метода, чтобы получить в них три разных исключения
 */
public class HomeTask1 {
    static void exOne(int[]array){
        int res;
        for (int i = 0; i < array.length; i++) {
            try {
                System.out.println(res = array[i] / i);
            } catch (ArithmeticException ae) {
                System.out.println("Деление на ноль");
            }
        }
    }
    static void exTwo(String[]array) {
        try {
            System.out.println(array[0] + array[1]);
        } catch (ArrayIndexOutOfBoundsException a) {
            System.out.println("За границами массива");
        }
    }
    static void exThree(String[] array){

        for (int i = 0; i < array.length; i++) {
            try{
                int x = Integer.parseInt(array[i]);
            }
            catch (NumberFormatException nf)
            {
                throw new RuntimeException("в массиве не только числа");
            }
        }
    }

    public static void main(String[] args) {
        int [] arrayOne = new int[]{4,2,0,-2,-4};
        exOne(arrayOne);
        String [] arrayTwo = new String[]{};
        exTwo(arrayTwo);
        String [] arrayThree = new String[]{"1","2","e","5","y"};
        exThree(arrayThree);

    }
}
