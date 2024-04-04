package Task10.repository;

import java.io.IOException;
import java.util.List;

public interface Repository<T> {
    void save(T object) throws IOException;
    T load(int id) throws IOException;

    List<T> load(List<Integer> ids) throws IOException;

}
