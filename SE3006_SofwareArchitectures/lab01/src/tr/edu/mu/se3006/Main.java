package tr.edu.mu.se3006;
import tr.edu.mu.se3006.presentation.OrderController;
import tr.edu.mu.se3006.business.OrderService;
import tr.edu.mu.se3006.persistence.ProductRepository;

public class Main {
    public static void main(String[] args) {
        System.out.println("🚀 System Starting...\n");
        
        // TODO 1: Create the lowest layer (ProductRepository)
        ProductRepository repository = new ProductRepository();
        
        // TODO 2: Create the middle layer (OrderService) and inject the repository
        OrderService service = new OrderService(repository);
        
        // TODO 3: Create the top layer (OrderController) and inject the service
        OrderController controller = new OrderController(service);
        
        System.out.println("--- Test Scenarios ---");
        // TODO 4: Call handleUserRequest via the controller to test the system
        // e.g., controller.handleUserRequest(1L, 2);

        controller.handleUserRequest(1l, 2);
        controller.handleUserRequest(1l, 2);
        controller.handleUserRequest(1l, 2);
        controller.handleUserRequest(1l, 2);
        controller.handleUserRequest(2l, 25);
    }
}
