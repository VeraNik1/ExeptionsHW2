
public class TaskThree {
    public static void main(String[] args) { /** 1. убираю из main throws Exception*/

        try {
            int a = 90;
            int b = 3;
            System.out.println(a / b);
            printSum(23, 234);
            int[] abc = { 1, 2 };
            abc[3] = 9;
        } catch (NullPointerException ex) {
            /** 2. добавляю в вывод описание ошибки для всех обрабатыаемых исключений*/

            System.out.println("Указатель не может указывать на null! " + ex);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Массив выходит за пределы своего размера! " + ex);

            /** 3. переношу обработку Throwable в конец кода, для того, чтобы обработались NullPointerException и
             * IndexOutOfBoundsException с заданными ранее сообщениями
             */
        } catch (Throwable ex) {
            System.out.println("Что-то пошло не так..." + ex);
        }
    }
    public static void printSum(Integer a, Integer b) throws NullPointerException

    /**
     4. убираю "throws FileNotFoundException" исключение, так как оно бессмысленно, функция не обращается к файлу
     5. добавляю NullPointerException для случая, когда один или оба аргумента имеют значение null **/
    {System.out.println(a + b);    }


}