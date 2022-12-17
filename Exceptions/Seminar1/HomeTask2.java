package Excepts;

/**
 * Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
 */
public class HomeTask2 {
    /**
     * 1. выход за границы массива ArrayIndexOutOfBoundsException
     * 2. не совпадение типов при Integer.parseInt  -> NumberFormatException
     * 3. null String при Integer.parseInt
     * 4. не проинициализированый массив
     * 5. NegativeArraySizeException отрицательная длина массива
     */
    public static int sum2d(String[][]arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {
                int val = Integer.parseInt(arr[i][j]);
                sum += val;
            }
        }
        return sum;
    }
    public static void main(String[] args) {
        String[][]array = new String[][]{{"0","1","1","2","3"},{"0","2","3","0","1"},{"r","2","3","2","2"},{"0","2","3","0","1"},{"0","2","3","0","1"}};
    //    String[][]ar1 = new String[-1][1];
        sum2d(array);
    //    sum2d(ar1);

    }
}
