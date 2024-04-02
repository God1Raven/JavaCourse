package Task10.personrepository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class MemoryRepository<T> implements Repository<T> {
        private final Map<Integer, T> storage = new HashMap<>();

    @Override
    public void save(T object) throws IOException {
        storage.put(getId(object), object);
    }

    @Override
    public T load(int id) throws IOException {
        return storage.get(id);
    }

    @Override
    public List<T> load(List<Integer> ids) throws IOException {
        List<T> arrList = new ArrayList<>();
        for (int i = 0; i < ids.size(); i++) {
            arrList.add(load(ids.get(i)));
        }
        return arrList;
    }

    public abstract int getId(T obg);
}
