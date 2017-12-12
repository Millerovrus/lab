package Sorters;

import Comporators.InterfaceComparator;
import java.util.List;

public interface SorterInterface <T>{
    List<T> sort(List<T> objects, InterfaceComparator comparator);
}
