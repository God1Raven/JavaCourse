package personrepository;

import entity.Person;

import java.io.File;
import java.io.IOException;

public interface Repository {
    void save(Person person) throws IOException;
    Person load(int id) throws IOException;
}
