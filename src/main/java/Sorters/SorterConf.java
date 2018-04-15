package Sorters;

import Comparators.Comparator;

import java.util.List;

public class SorterConf<T> {

    @AutoInjectable
    private SorterInterface<T> sorter;

    public List<T> sort(List<T> objects, Comparator<T> comparator){
        return sorter.sort(objects, comparator);
    }
}
