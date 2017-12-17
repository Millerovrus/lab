package Repositories;

import Comparators.Comparator;
import Entity.Idable;
import Search.Checker;
import Sorters.Configurator;
import Sorters.FactorySorter;
import Sorters.SorterInterface;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.LinkedList;
import java.util.List;

public abstract class RepositoryAbstract<T extends Idable<ID>, ID> implements RepositoryInterface<T, ID>{
    private Configurator configurator = new Configurator();
    private List<T> objects = new LinkedList<>();
    private static Logger LOGGER = LogManager.getLogger();

    /**
     * Добавление объекта в репозиторий
     * @param object - сам объект
     */
    @Override
    public void add(T object) {
        LOGGER.info("add");
        objects.add(object);
    }

    /**
     * Удаление из репозитория
     * @param id - по ID объекта
     */
    @Override
    public void remove(ID id) {
        LOGGER.info("remove");
        if (exists(id)) {
            objects.remove(searchById(id));
        }
    }

    /**
     * Поиск по ID
     * @param id
     * @return - единственное найденное значение или null
     */
    @Override
    public T searchById(ID id) {
        LOGGER.info("searchByID");
        for (T object:objects) {
            if (object.getId().equals(id)) {
                return object;
            }
        }
        return null;
    }

    /**
     * Сортировка по любым компараторам
     * @param objects - передаем объект сортировки
     * @param comparator - передаем компаратор
     */
    public void sort(List<T> objects, Comparator<T> comparator) {
        LOGGER.info("sort");
        SorterInterface<T> sorter = new FactorySorter<T>().getSorter(configurator.config);
        sorter.sort(objects, comparator);
    }

    /**
     * Поиск по любым параметрам
     * @param checker - передаем по какому параметру хотим искать
     * @param o - передаем искомое значение
     * @return - список найденных объектов
     */
    public List<T> searchBy(Checker<T> checker, Object o) {
        LOGGER.info("search");
        List <T> foundObjects = new LinkedList<>();
        for (T object : objects) {
            if (checker.check(o, object)) {
                foundObjects.add(object);
            }
        }
        return foundObjects;
    }

    /**
     * Проверка на существования пользователя по ID
     * @param id
     * @return - true/false
     */
    @Override
    public boolean exists(ID id) {
        return searchById(id) != null;
    }

    /**
     * Метод получения размера репозитория
     * @return
     */
    @Override
    public int getSize() {
        return objects.size();
    }

    /**
     * Метод получения i-ого элемента
     * @param i
     * @return - элемент
     */
    @Override
    public T get(int i) {
        return objects.get(i);
    }

    /**
     * Получаем репозиторий
     * @return
     */
    public List<T> getRepository() {
        return this.objects;
    }
}
