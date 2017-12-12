package Repositories;

import Interfaces.Idable;

public interface RepositoryInterface<T extends Idable<ID>, ID> {
    void add(T object);
    void remove(ID id);
    T searchById(ID id);
    boolean exists(ID id);
    int getSize();
}