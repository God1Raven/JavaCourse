package Task10.entity;

public class Product implements Comparable<Product> {

    private final Integer id;

    private String name;

    private Double price;


    public  Product(Integer id){
        this.id = id;
    }

    public Product(Integer id, String name, Double price) {

        this.id = id;
        this.name = name;
        this.price = price;

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int compareTo(Product product) {
        return Integer.compare(id, product.id);
    }
}
