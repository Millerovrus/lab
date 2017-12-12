package Sorters;

import Comporators.InterfaceComparator;

import java.util.List;

public class InsertionSort <T> implements SorterInterface <T>{
    public List<T> sort(List<T> objects, InterfaceComparator comparator) {
        int i, j;
        for (i = 1; i < objects.size(); i++) {
            j = i;
            while (j > 0 && comparator.compare(objects.get(j - 1), objects.get(j)) > 0) {
                T temp = objects.get(j);
                objects.set(j, objects.get(j - 1));
                objects.set(j - 1, temp);
                j--;
            }
        }
        return objects;
    }
}
