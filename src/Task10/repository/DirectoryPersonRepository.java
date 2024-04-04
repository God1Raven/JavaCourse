package Task10.repository;

import Task10.entity.Person;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DirectoryPersonRepository implements Repository<Person> {

    private final File file;

    public DirectoryPersonRepository(File file){
        this.file = file;

        if(!file.exists()){
            file.mkdirs();
        }

        if (!file.isDirectory()){
            throw new IllegalArgumentException("");
        }
    }

    @Override
    public void save(Person person) throws IOException {
        File file = new File(this.file.getPath() + "/" + person.getId());
        Person.saveTo(file, person);
    }

    @Override
    public Person load(int id) throws IOException {
        File file = new File(this.file.getPath() + "/" + id);
        return Person.loadFrom(file);
    }

    @Override
    public List<Person> load(List<Integer> ids) throws IOException{
        List<Person> list = new ArrayList<>();
        for(int i = 0; i <= ids.size(); i++){
            list.add(load(ids.get(i)));
        }
        return list;
    }
}
