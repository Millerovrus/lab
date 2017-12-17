package Sorters;

import Comparators.Comparator;
import java.util.List;

public interface SorterInterface <T>{
    List<T> sort(List<T> objects, Comparator<T> comparator);
}
