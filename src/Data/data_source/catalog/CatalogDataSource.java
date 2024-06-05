package Data.data_source.catalog;

import Data.models.Product;

import java.util.ArrayList;

public abstract class CatalogDataSource {

    public abstract ArrayList<Product> getCatalog ();

}
