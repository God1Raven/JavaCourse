package Task10.repository;

import Task10.entity.Product;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DirectoryProductRepository implements Repository<Product> {
    private final File file;

    public DirectoryProductRepository(File file){
        this.file = file;

        if(!file.exists()){
            file.mkdirs();
        }

        if (!file.isDirectory()){
            throw new IllegalArgumentException("");
        }
    }

    @Override
    public void save(Product product) throws IOException {
        File file = new File(this.file.getPath() + "/" + product.getId());
        try(PrintWriter writer = new PrintWriter(file)){
            writer.println(product.getId());
            writer.println(product.getName());
            writer.println(product.getPrice());
        }
    }

    @Override
    public Product load(int id) throws IOException {
        File file = new File(this.file.getPath() + "/" + id);
        try (Scanner scanner = new Scanner(file)){
            scanner.nextLine();
            String name = scanner.nextLine();
            double price = Double.parseDouble(scanner.nextLine().replace(',' , '.'));
            return new Product(id, name, price);
        }
    }

    @Override
    public List<Product> load(List<Integer> ids) throws IOException{
        List<Product> list = new ArrayList<>();
        for(int i = 0; i <= ids.size(); i++){
            list.add(load(ids.get(i)));
        }
        return list;
    }
}
