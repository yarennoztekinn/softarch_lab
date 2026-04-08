package tr.edu.mu.se3006.business;
import tr.edu.mu.se3006.persistence.ProductRepository;
import tr.edu.mu.se3006.domain.Product;

public class OrderService {
    // TODO: Define ProductRepository dependency
    private ProductRepository repository;

    // TODO: Implement Constructor Injection
    public OrderService(ProductRepository repository) {
        this.repository = repository;
    }
    
    public void placeOrder(Long productId, int quantity) {
        // TODO 1: Find product via repository
        Product product = repository.findById(productId);

        // TODO 2: Check stock (throw IllegalArgumentException if insufficient)
        if (product.getStock() == 0){
            throw new IllegalArgumentException("there is no enough stock");
        }

        // TODO 3: Reduce stock
        if (quantity > product.getStock()){
            throw new IllegalArgumentException("quantity less than stock");
        }else{
            // TODO 4: Save updated product
            product.setStock(product.getStock() - quantity);
            repository.save(product);
        }
    }
}
