package lessons1;

class Task1 <T> {

    T[] revertArrayWithToElement(T[] list)
    {
        T t = list[0];
        list[0] = list[1];
        list[1] = t;

        return list;
    }

    void printArray(T[] list)
    {
        for (T t : list) {
            System.out.println(t.toString());
        }

    }
}
