# HOMEWORK №2

## Task 1: 
Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float),
и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению 
приложения, вместо этого, необходимо повторно запросить у пользователя ввод данных.

### Реализация кода 
[**FloatNumInput**](https://github.com/VeraNik1/ExeptionsHW2/blob/master/FloatNumInput.java)
```java
public class FloatNumInput {
    public static void main(String[] args) {
        float userInput = floatInput();
        System.out.println("Вы ввели число: " + userInput);
    }

    public static float floatInput() {
        Scanner scanner = new Scanner(System.in);
        float num = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введите дробное число в формате 5,324 или 8.2: ");
            try {
                String input = scanner.nextLine().replace(',', '.');
                num = Float.parseFloat(input);

                // Проверяем, не является ли число целым
                if (num == (int) num) {
                    System.out.println("Введено целое число. Пожалуйста, введите дробное число.");
                    continue; // В случае, если введено целое число, повторно запрашиваем ввод
                }

                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод дробного числа. Попробуйте еще раз.");
            }
        }

        return num;
    }
}
```

### Примеры выполнения для различных вводов
```textmate
Введите дробное число в формате 5,324 или 8.2: 
Некорректный ввод дробного числа. Попробуйте еще раз.

Введите дробное число в формате 5,324 или 8.2: й
Некорректный ввод дробного числа. Попробуйте еще раз.

Введите дробное число в формате 5,324 или 8.2: 12
Введено целое число. Пожалуйста, введите дробное число.

Введите дробное число в формате 5,324 или 8.2: 12,3
Вы ввели число: 12.3

Process finished with exit code 0
```
## Task 2: 
Если необходимо, исправьте код:
```java
try {
int d = 0;
double catchedRes1 = intArray[8] / d;
System.out.println("catchedRes1 = " + catchedRes1);
} catch (ArithmeticException e) {
System.out.println("Catching exception: " + e);
}
```
### Исправления [**TaskTwo**](https://github.com/VeraNik1/ExeptionsHW2/blob/master/TaskTwo.java)
```java
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
 }
```

## Task 3: 
Если необходимо, исправьте код:

```java
public static void main(String[] args) throws Exception {
   try {
       int a = 90;
       int b = 3;
       System.out.println(a / b);
       printSum(23, 234);
       int[] abc = { 1, 2 };
       abc[3] = 9;
   } catch (Throwable ex) {
       System.out.println("Что-то пошло не так...");
   } catch (NullPointerException ex) {
       System.out.println("Указатель не может указывать на null!");
   } catch (IndexOutOfBoundsException ex) {
       System.out.println("Массив выходит за пределы своего размера!");
   }
}
public static void printSum(Integer a, Integer b) throws FileNotFoundException {
   System.out.println(a + b);
}

```
### Исправления [**TaskThree**](https://github.com/VeraNik1/ExeptionsHW2/blob/master/TaskThree.java)

```java
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
        {System.out.println(a + b);}
```


## Task 4: 
Разработайте программу, которая выбросит Exception, когда пользователь 
вводит пустую строку. Пользователю должно показаться сообщение, 
что пустые строки вводить нельзя.

Решение приведено в файле [**EmptyString**](https://github.com/VeraNik1/ExeptionsHW2/blob/master/EmptyString.java)

Код:
```java
    public static void main(String[] args) {
        while (true){
        try {
        String userInput = getInput();
        System.out.println("Ввод пользователя: " + userInput);
        break;
        } catch (Exception e) {
        System.out.println("Ошибка ввода: " + e.getMessage());
        }}
        }
public static String getInput() throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст: ");
        String input = scanner.nextLine();
        if (input.isEmpty()) {
        throw new Exception("Пустые строки вводить нельзя!");
        }
        return input;
        }
```
### Пример вывода
```
Введите текст: 
Ошибка ввода: Пустые строки вводить нельзя!
Введите текст: 
Ошибка ввода: Пустые строки вводить нельзя!
Введите текст: 3
Ввод пользователя: 3

Process finished with exit code 0
```
