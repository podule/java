package lessons_2;


public class Main {

    public static void main(String[] args) {
        //1. Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
        // С помощью цикла и условия заменить 0 на 1, 1 на 0;
        int[] nums_1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        for(int i = 0; i < nums_1.length; i++){
            nums_1[i] = (nums_1[i]== 0) ? 1 : 0;
            System.out.print(nums_1[i] + " ");
        }

        System.out.println("");

        //2. Задать пустой целочисленный массив размером 8. С помощью цикла заполнить его значениями 0 3 6 9 12 15 18 21;
        int[] nums_2 = new int[8];
        for (int i = 0; i < nums_2.length; i++){
            nums_2[i] = i*3;
            System.out.print(nums_2[i] + " ");
        }

        System.out.println("");

        //3. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], пройти по нему циклом, и числа, меньшие 6, умножить на 2;
        int[] nums_3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int a = 0;
        while (a < nums_3.length){
            if(nums_3[a] < 6){
                nums_3[a] *= 2;
            }
            System.out.print(nums_3[a] + " ");
            a++;
        }

        System.out.println("");

        //4. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
        // и с помощью цикла(-ов) заполнить его диагональные элементы единицами;
        int[][] nums_4 = new int[4][4];
        for (int i = 0; i < nums_4.length; i++){
            for (int j = 0; j < nums_4[i].length; j++){
                nums_4[i][j] = (i == j) ? 1 : 0;

                System.out.print(nums_4[i][j] + " ");
            }
            System.out.println("");
        }

        //5. Задать одномерный массив и найти в нем минимальный и максимальный элементы (без помощи интернета);
        int[] nums_5 = {5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        int min = nums_5[0];
        int max = nums_5[0];
        for(int i : nums_5){
            min = (i < min) ? i : min;
            max = (i > max) ? i : max;
        }
        System.out.println("min - " + min + " max - " + max);

        //6. Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
        // если в массиве есть место, в котором сумма левой и правой части массива равны.
        // Примеры: checkBalance([1, 1, 1, || 2, 1]) → true, checkBalance ([2, 1, 1, 2, 1]) → false,
        // checkBalance ([10, || 10]) → true, граница показана символами ||, эти символы в массив не входят;
        int[] nums_6_1 = {5, 3, 2, 6, 4};
        int[] nums_6_2 = {1, 1, 1, 2, 1};
        int[] nums_6_3 = {2, 1, 1, 2, 1};
        boolean b = checkBalance(nums_6_1);
        boolean c = checkBalance(nums_6_2);
        boolean d = checkBalance(nums_6_3);
        System.out.println(b + " " + c + " " + d);

        //7. *Написать метод, которому на вход подается одномерный массив и число n (может быть положительным или отрицательным),
        // при этом метод должен сместить все элементы массива на n позиций. Нельзя пользоваться вспомогательными массивами.
        displaceArr(nums_5, 3);
        System.out.println(" ");
        for(int i : nums_5){
            System.out.print(i + " ");
        }

    }



    private static void displaceArr(int[] arr, int a) {
        int b;
        int j = (a < 0) ?  arr.length + a : a;
        for (int i = 0; i < j; i++){
            b = arr[0];

            for(int y = 0; y < arr.length; y++){
                arr[y] = (y < arr.length-1) ? arr[y+1] : b;
            }

            //{5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1}; входной массив
            // {11, 4, 5, 2, 4, 8, 9, 1, 5, 3, 2};  n = 3
            // {8, 9, 1, 5, 3, 2, 11, 4, 5, 2, 4}; n = -3
        }
    }

    private static boolean checkBalance(int[] arr) {
        int summ = 0;
        for(int i : arr){
            summ += i;
        }

        int bitArr = 0;
        for(int i : arr){
            bitArr += i;
            if((summ - bitArr) == bitArr){
                return true;
            }
        }

        return false;
    }

}


