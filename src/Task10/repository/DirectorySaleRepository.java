package Task10.repository;

import Task10.entity.Person;
import Task10.entity.Product;
import Task10.entity.Sale;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.util.Map.Entry;


public class DirectorySaleRepository implements Repository<Sale> {

    private final File file;

    public DirectorySaleRepository(File file) {
        this.file = file;

        if (!file.exists()) {
            file.mkdirs();
        }

        if (!file.isDirectory()) {
            throw new IllegalArgumentException("");
        }
    }

    @Override
    public void save(Sale sale) throws IOException {
        File file = new File(this.file.getPath() + "/" + sale.getId());
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println(sale.getId());
            writer.println(sale.getAmount());
            writer.println(sale.getPerson().getId());
            writer.println(sale.getPerson().getName());
            writer.println(sale.getPerson().getLastName());
            writer.println(sale.getPerson().getEmail());
            writer.println(sale.getProducts().size());
            for (Entry<Product, Double> productDoubleEntry: sale.getProducts().entrySet()){
                writer.println(productDoubleEntry.getKey().getId());
                writer.println(productDoubleEntry.getKey().getName());
                writer.println(productDoubleEntry.getKey().getPrice());
                writer.println(productDoubleEntry.getValue());
            }
        }
    }

    @Override
    public Sale load(int id) throws IOException {
        File file = new File(this.file.getPath() + "/" + id);
        try (Scanner scanner = new Scanner(file)) {
            double amount = Double.parseDouble(scanner.nextLine());
            int personId = scanner.nextInt();
            scanner.nextLine();
            String personName = scanner.nextLine();
            String personLastName = scanner.nextLine();
            String personEmail = scanner.nextLine();
            scanner.nextLine();

            Person person = new Person(personId, personName, personLastName, personEmail);

            Integer productsSize = scanner.nextInt();

            Map<Product, Double>  products =  new HashMap<>();
            for (int i = 0; i < productsSize; i++) {
                int productsId = scanner.nextInt();
                String productsName = scanner.nextLine();
                double price = Double.parseDouble(scanner.nextLine());
                Product product = new Product(productsId, productsName, price);
                products.put(product, Double.parseDouble(scanner.nextLine()));
            }
            return new Sale(id, amount, person, products);
        }
    }

    @Override
    public List<Sale> load(List<Integer> ids) throws IOException {
        List<Sale> list = new ArrayList<>();
        for (int i = 0; i <= ids.size(); i++) {
            list.add(load(ids.get(i)));
        }
        return list;
    }
}
