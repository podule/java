package ru.podule.lfive.threads;

public class HomeWork {

    private static final int size = 1000000;
    private static final int h = size / 2;


    public static void main(String[] args) {

        oneMethod();
        twoMethod();
    }

    private static void oneMethod(){
        float[] fl = new float[size];
        fillInUnits(fl);

        long a = System.currentTimeMillis();
        calcArrSomething(fl);
        System.out.println("Time met1: " + (System.currentTimeMillis() - a));

    }

    private static void twoMethod(){

        float[] fl = new float[size];
        fillInUnits(fl);

        long a = System.currentTimeMillis();
        float[] a1 = new float[h];
        float[] a2 = new float[h];
        System.arraycopy(fl, 0, a1, 0, h);
        System.arraycopy(fl, h, a2, 0, h);

        Runnable run1 = () -> calcArrSomething(a1);
        Runnable run2 = () -> calcArrSomething(a2);

        new Thread(run1).start();
        new Thread(run2).start();

        System.arraycopy(a1, 0, fl, 0, h);
        System.arraycopy(a2, 0, fl, h, h);

        System.out.println("Time met2: " + (System.currentTimeMillis() - a));

    }


    private static void fillInUnits(float[] arr){

        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1f;
        }
    }

    private static void calcArrSomething(float[] arrI){
        for (int i = 0; i < arrI.length; i++) {
            arrI[i] = (float)(arrI[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
