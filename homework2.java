package homework2;

import java.io.File;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class homework2 {
    static File logFile = null;
    static FileWriter fileWriter = null;
    static Scanner scanner = new Scanner(System.in);
    /*
     * 1) Дана строка sql-запроса "select * from students where ". 
     * Сформируйте часть WHERE этого запроса, используя StringBuilder. 
     * Данные для фильтрации приведены ниже в виде json-строки.
     * Если значение null, то параметр не должен попадать в запрос.
     * Параметры для фильтрации: 
     * {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
     * 
     * 2) Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.
     * 
     * 3) Дана json-строка (можно сохранить в файл и читать из файла)
     * [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},
     * {"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},
     * {"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
     * Написать метод(ы), который распарсит json и, используя StringBuilder,
     * создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
     * Пример вывода:
     * Студент Иванов получил 5 по предмету Математика.
     * Студент Петрова получил 4 по предмету Информатика.
     * Студент Краснов получил 5 по предмету Физика.
     * 
     * 4) К калькулятору из предыдущего ДЗ добавить логирование.
     */
    public static void main(String[] args) {
        boolean f = true;
        while (f) {
            System.out.println("Укажите номер задачи:");
            System.out.println("1 sql запрос");
            System.out.println("2 Пузырёк");
            System.out.println("3 Калькулятор");
            System.out.println("0 завершение работы");
            System.out.print("Введите номер задачи: ");
            int no = Integer.parseInt(scanner.nextLine());

            if (no == 1) {
                sqlData();
                System.out.println();
            } else if (no == 2) {
                puzirek();
                System.out.println();
                System.out.println();
            } else if (no == 3) {
                calculator();
                System.out.println();
                System.out.println();
            } else if (no == 0) {
                f = false;
                System.out.print("Завершение работы");
            }
        }
    }
        public static void sqlData(){
 Map<String, String> parameters = new HashMap<String,String>();
        parameters.put("name","Ivanov");
        parameters.put("country","Russia");
        parameters.put("city","Moscow");
        parameters.put("age",null);
        System.out.println(query(parameters));
    }

    public static String query(Map<String, String> params)
    {
        StringBuilder s = new StringBuilder();
        for (Map.Entry<String,String> pair : params.entrySet())
        {
            if (pair.getValue() != null)
            {
                s.append(pair.getKey() + " " + pair.getValue() + "\n");
            }
        }
        return s.toString();
    }

public static void calculator() {
        try {
        System.out.println("Введите первое число: ");
        double a = scanner.nextInt();
        System.out.println("Введите второе число: ");
        double b = scanner.nextInt();
        System.out.println("Введите операцию (+ - * /): ");
        char operation = scanner.next().charAt(0);
        if (operation == '+') {
            double result = a + b;
            System.out.printf("Ответ: %.2f + %.2f = %.2f\n", a, b, result);
            try{
            logFile = new File("JAVA/homework2/log.txt");
            fileWriter = new FileWriter(logFile);
            fileWriter.write(Double.toString(a));
            fileWriter.write(" + ");
            fileWriter.write(Double.toString(b));
            fileWriter.write(" = ");
            fileWriter.write(Double.toString(result));
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        else if (operation == '-') {
            double result = a - b;
            System.out.printf("Ответ: %.2f - %.2f = %.2f\n", a, b, result);
                        try{
            logFile = new File("JAVA/homework2/log.txt");
            fileWriter = new FileWriter(logFile);
            fileWriter.write(Double.toString(a));
            fileWriter.write(" - ");
            fileWriter.write(Double.toString(b));
            fileWriter.write(" = ");
            fileWriter.write(Double.toString(result));
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        else if (operation == '*') {
            double result = a * b;
            System.out.printf("Ответ: %.2f * %.2f = %.2f\n", a, b, result);
                        try{
            logFile = new File("JAVA/homework2/log.txt");
            fileWriter = new FileWriter(logFile);
            fileWriter.write(Double.toString(a));
            fileWriter.write(" * ");
            fileWriter.write(Double.toString(b));
            fileWriter.write(" = ");
            fileWriter.write(Double.toString(result));
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        else if (operation == '/') {
            double result = a / b;
            System.out.printf("Ответ: %.2f / %.2f = %.2f\n", a, b, result);
                        try{
            logFile = new File("JAVA/homework2/log.txt");
            fileWriter = new FileWriter(logFile);
            fileWriter.write(Double.toString(a));
            fileWriter.write(" / ");
            fileWriter.write(Double.toString(b));
            fileWriter.write(" = ");
            fileWriter.write(Double.toString(result));
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        fileWriter.close();
        } catch (Exception e) {
        }

        }
    
    public static void puzirek(){
    int[] array = new int[] {1, 5, 2, 12, 6, 43};
        System.out.println(arrayToString(array));
        bubbleSort(array);
        System.out.println(arrayToString(array));
    }

    public static void bubbleSort(int[] array) {
        boolean isSorted = false;
        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i - 1] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false;
                }
            }
        }
    }



    private static String arrayToString(int[] array) {
        StringBuilder s = new StringBuilder();
        s.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                s.append(", ");
            }
            s.append(array[i]);
        }
        s.append("]");
        return s.toString();
    }
}
