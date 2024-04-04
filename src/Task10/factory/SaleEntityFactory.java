package Task10.factory;

import Task10.entity.Sale;

public class SaleEntityFactory extends SimpleEntityFactory<Sale>{
    @Override
    public Sale create() {
        return new Sale(getNextId());
    }
}
