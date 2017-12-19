package Sorters;

public class FactorySorter<T> {
    /**
     * Возвращает способ сортировки в зависимости от конфига
     * @param config
     * @return метод сортировки
     */
    public SorterInterface<T> getSorter(int config) {
        SorterInterface sorter = null;
        if (config == 1) {
            sorter = new BubbleSort();
        } else if (config == 2) {
            sorter = new InsertionSort();
        }
        return sorter;
    }
}
