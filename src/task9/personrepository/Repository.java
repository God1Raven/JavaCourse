package task9.personrepository;

import task9.entity.Person;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
    void save(T object) throws IOException;
    T load(int id) throws IOException;

    List<T> load(List<Integer> ids) throws IOException;

}
