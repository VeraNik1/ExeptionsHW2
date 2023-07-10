public class TaskTwo {
    public static void main(String[] args) {
        int[] intArray = {1, 30, 75, 4, 5, 17, 7, 8, 9, 15, 6};
        taskTwo(intArray, 0, 8);

    }
    /** 1. создаем отдельный метод по делению заданного элемента массива
     целых чисел на заданное целое число, убираем хардкод **/

    public static void taskTwo(int[] intArray, int d, int index) {

        try {
            /** 2. для получения результата double
             кастуем элемент массива int  в double**/
            double catchedRes1 = (double) intArray[index] / d;
            /** 3. поскольку деление double на 0 = Infinity,
             обрабатываем деление на 0 через if пробрасывая ArithmeticException**/
            if (d == 0) {
                throw new ArithmeticException("деление на ноль");
            }
            System.out.println("catchedRes1 = " + catchedRes1);
        }
        /** 4.добавляю обработку NullPointerException для случая, если intArray = null
         5. добавляю обработку ArrayIndexOutOfBoundsException для случая,
         если в массиве отсутствует элемент с номером index **/

        catch (NullPointerException | ArithmeticException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exception: " + e);
        }
    }}


