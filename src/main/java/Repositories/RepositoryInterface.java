package Repositories;

import Entity.Idable;

import java.util.List;

public interface RepositoryInterface<T extends Idable<ID>, ID> {
    void add(T object);
    void remove(ID id);
    T searchById(ID id);
    boolean exists(ID id);
    int getSize();
    T get(int i);
    List<T> getRepository();
}