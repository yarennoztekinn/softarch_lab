package tr.edu.mu.se3006.presentation;
import tr.edu.mu.se3006.business.OrderService;

public class OrderController {
    // TODO: Define OrderService dependency and use Constructor Injection
    private OrderService service;

    public OrderController(OrderService service){
        this.service = service;
    }

    public void handleUserRequest(Long productId, int quantity) {
        System.out.println(">>> New Request: Product ID=" + productId + ", Quantity=" + quantity);
        // TODO: Call placeOrder inside a try-catch block.
        // Print "✅ Order Confirmed" on success, or "❌ ERROR: [message]" on failure.
        try {service.placeOrder(productId, quantity);
            System.out.println("✅ Order Confirmed");
        }
        catch(Exception e){
            System.out.println("❌ Order Failed");
        }

    }
}
