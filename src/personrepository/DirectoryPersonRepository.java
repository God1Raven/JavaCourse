package personrepository;

import entity.Person;

import java.io.File;
import java.io.IOException;

public class DirectoryPersonRepository implements Repository{

    private final File dir;

    public DirectoryPersonRepository(File dir){
        this.dir = dir;

        if(!dir.exists()){
            dir.mkdirs();
        }

        if (!dir.isDirectory()){
            throw new IllegalArgumentException("Govno");
        }
    }

    @Override
    public void save(Person person) throws IOException {
        File file = new File(dir.getPath() + "/" + person.getId());
        Person.saveTo(file, person);
    }

    @Override
    public Person load(int id) throws IOException {
        File file = new File(dir.getPath() + "/" + id);
        return Person.loadFrom(file);
    }
}
