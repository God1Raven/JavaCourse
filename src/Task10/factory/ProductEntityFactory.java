package Task10.factory;

import Task10.entity.Product;
import Task10.entity.Sale;

public class ProductEntityFactory extends SimpleEntityFactory<Product>{
    @Override
    public Product create() {
        return new Product(getNextId());
    }
}
