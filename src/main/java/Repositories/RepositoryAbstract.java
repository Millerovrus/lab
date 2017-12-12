package Repositories;

import Interfaces.Idable;
import java.util.LinkedList;
import java.util.List;

public abstract class RepositoryAbstract<T extends Idable<ID>, ID> implements RepositoryInterface<T, ID>{
    protected List<T> objects = new LinkedList<>();

    @Override
    public void add(T object) {
        objects.add(object);
    }

    @Override
    public void remove(ID id) {
        if (exists(id)) {
            objects.remove(searchById(id));
        }
    }

    @Override
    public T searchById(ID id) {
        for (T object:objects) {
            if (object.getId().equals(id)) {
                return object;
            }
        }
        return null;
    }

    @Override
    public boolean exists(ID id) {
        return searchById(id) != null;
    }

    @Override
    public int getSize() {
        return objects.size();
    }
}
