package lesson2;

public class MySortedArrayList<T extends Comparable<T>> extends MyArrayList<T> {

    @Override
    public void add(T item) {
        int i = 0;
        while (i < size() && get(i).compareTo(item) < 0) {
            i++;
        }

        super.add(i, item);
    }

    @Override
    public void add(int index, T item) {
        super.add(item);
    }

    @Override
    public void set(int index, T item) {
        throw new UnsupportedOperationException("Not");
    }

    public int binaryFind(T item) {
        int start = 0;
        int finish = size() - 1;
        int mid;

        while (start <= finish) {
            mid = start + (finish - start) / 2;
            if (item.compareTo(get(mid)) < 0) {
                finish = mid - 1;
            } else if (item.compareTo(get(mid)) > 0){
                start = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
