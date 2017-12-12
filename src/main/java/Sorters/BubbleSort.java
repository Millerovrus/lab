package Sorters;

import Comporators.InterfaceComparator;

import java.util.List;

public class BubbleSort <T> implements SorterInterface <T>{
    @Override
    public List<T> sort(List<T> objects, InterfaceComparator comparator){
        for(int i = 0; i < objects.size(); i++){
            for(int j = objects.size() - 1; j > i; j--){
                if(comparator.compare(objects.get(j), objects.get(j+1)) < 0){
                    T temp = objects.get(j);
                    objects.set(j, objects.get(j-1));
                    objects.set(j-1, temp);
                }
            }
        }
        return objects;
    }
}

