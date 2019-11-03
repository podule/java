package ru.podule.ltwo;

import java.util.regex.Pattern;

public class MainClass {

    static final int SIZE_MATRIX = 4;
    static String[][] arrayMatrix = new String[SIZE_MATRIX][SIZE_MATRIX];

    public static void main(String[] args) {

        String matrix = "10 3 1 2\\n2 3 2 2\\n5 6 7 1\\n300 3 1 0";
        int i = 0;
        try {
            arrayMatrix = convertInArrayMatrix(matrix);
            i = summDivide(arrayMatrix);
        }catch (CustomException e){
            e.printStackTrace();
        }

        System.out.println(i);

    }

    public static int summDivide(String[][] array) throws CustomException{
        int number = 0;


        for (int i = 0; i < SIZE_MATRIX; i++) {
            for (int j = 0; j < SIZE_MATRIX; j++) {
                // лишняя проверка, потому что в convertInArrayMatrix изначально парсятся только числа для массива матрицы
                if(array[i][j].matches("-?\\d+(\\.\\d+)?")){
                    number += Integer.valueOf(array[i][j]);
                }else{
                    throw new CustomException("В одной из ячеек полученной матрицы не число");
                }
            }
        }
        number /= 2;
        return number;
    }

    public static String[][] convertInArrayMatrix(String matrix) throws CustomException{

        Pattern pattern = Pattern.compile("\\D+");
        String[] array = pattern.split(matrix);

        if(array.length == SIZE_MATRIX * SIZE_MATRIX){

            for (int i = 0; i < SIZE_MATRIX; i++) {
                for (int j = 0; j < SIZE_MATRIX; j++) {
                    arrayMatrix[i][j] = array[(i * SIZE_MATRIX) + j];
                }
            }
            return arrayMatrix;
        }else{
            throw new CustomException("Размер матрицы, полученной из строки, не равен " + SIZE_MATRIX + "x" + SIZE_MATRIX);
        }

    }
}
