package Repositories;

import Comparators.Comparator;
import Entity.Car;
import Entity.Idable;
import Entity.Person;
import Search.Checker;
import Sorters.Injector;
import Sorters.SorterConf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.xml.bind.annotation.*;
import java.util.LinkedList;
import java.util.List;

@XmlAccessorType(XmlAccessType.NONE)
@XmlTransient
@XmlSeeAlso({PersonRepository.class, CarRepository.class})
public abstract class RepositoryAbstract<T extends Idable<ID>, ID> implements RepositoryInterface<T, ID>{
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
        SorterConf sorterConf = (SorterConf) (new Injector().inject(new SorterConf()));
        sorterConf.sort(objects, comparator);
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
    @XmlElements({
            @XmlElement(name = "Person", type = Person.class),
            @XmlElement(name = "Car", type = Car.class)
    })
    public List<T> getRepository() {
        return this.objects;
    }
}