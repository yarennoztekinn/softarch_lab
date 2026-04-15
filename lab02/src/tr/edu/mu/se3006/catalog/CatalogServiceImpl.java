package tr.edu.mu.se3006.catalog;

import tr.edu.mu.se3006.catalog.ProductRepository;

// Package-private implementation. Hidden from the outside world.
class CatalogServiceImpl implements CatalogService {
    
    // TODO: Define ProductRepository dependency
    private final ProductRepository productRepository;
    
    // TODO: Implement Constructor Injection
    CatalogServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void checkAndReduceStock(Long productId, int quantity) {
        // TODO 1: Find product via repository
        Product product = productRepository.findById(productId);
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + productId);
        }

        // TODO 2: Check stock (throw IllegalArgumentException if insufficient)
        if (product.getStock() < quantity) {
            throw new IllegalArgumentException("Insufficient stock for product " + productId + ". Requested: " + quantity + ", Available: " + product.getStock());
        }

        // TODO 3: Reduce stock
        product.setStock(product.getStock() - quantity);
        // TODO 4: Save updated product

        productRepository.save(product);
    }
}
