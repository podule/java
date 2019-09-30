package galia.lessons_1;

public class Main {

    // 1. Создать пустой проект в IntelliJ IDEA и прописать метод main();
    public static void main(String[] args) {
        //    2. Создать переменные всех пройденных типов данных, и инициализировать их значения;
        byte b = 1;
        short sh = 2;
        char c = 'a';
        int i = 3;
        long l = 4L;
        float f = 5F;
        double d = 6.0;
        boolean bl = true;
        String s = "Ссылочный тип";

        //3. Написать метод, вычисляющий выражение a * (b + (c / d)) и возвращающий результат, где a, b, c, d – входные параметры этого метода;
        int result_1 = calculateExpression(2, 2, 6, 2);
        System.out.println(result_1);

        //4. Написать метод, принимающий на вход два числа, и проверяющий, что их сумма лежит в пределах от 10 до 20 (включительно),
        // если да – вернуть true, в противном случае – false;
        boolean is_result_2 = calculateSum(5, 16);
        System.out.println(is_result_2);

        //5. Написать метод, которому в качестве параметра передается целое число, метод должен напечатать в консоль
        // положительное число передали или отрицательное (Замечание: ноль считаем положительным числом.);
        printWhatNumber(0);

        //6. Написать метод, которому в качестве параметра передается целое число, метод должен вернуть true, если число отрицательное;
        boolean is_result_3 = isWhatNumber(-5);
        System.out.println(is_result_3);

        //7. Написать метод, которому в качестве параметра передается строка, обозначающая имя,
        // метод должен вывести в консоль сообщение «Привет, указанное_имя!»;
        printHello("Galia");

        //8. *Написать метод, который определяет, является ли год високосным, и выводит сообщение в консоль.
        // Каждый 4-й год является високосным, кроме каждого 100-го, при этом каждый 400-й – високосный.
        printIsLeapYear(2000);

        //9. *Не набирая код в IDE, ответьте на следующий вопрос. Есть два метода:
        //    void myMethod(int a, String b) {}
        //    void myMethod(String b, int a) {}
        //
        //    Это две разных сигнатуры одного метода или один и тот же метод?

        // Ответ - это два разных метода, показан пример перезагрузки метода - если метод имеет разные параметры аргументов,
        // то методы  считаются разными.


    }

    private static void printIsLeapYear(int i) {
        String s;
        if( (i%4 == 0 && !(i%100 == 0)) || (i%400 == 0) ){
            s = "високосным";
        }else {
            s = "не високосным";
        }

        System.out.println("Год является " + s);
    }

    private static void printHello(String name) {
        System.out.println("Привет, " + name + "!");
    }

    private static boolean isWhatNumber(int a) {

        return (a < 0) ? true : false;

    }

    private static void printWhatNumber(int a) {
        String s;
        if(a >= 0){
            s = "положительное число";
        }else{
            s = "отрицательное число";
        }

        System.out.println("Передано " + s);
    }

    private static boolean calculateSum(int a, int b) {
        int c = a + b;
        return ( c >= 10 && c <= 20 ) ? true : false;
    }

    private static int calculateExpression(int a, int b, int c, int d) {

        return a * (b + (c / d));
    }

}
