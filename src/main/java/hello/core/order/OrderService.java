package hello.core.order;

public interface OrderService {
    // 클라이언트가 주문을 하는 메소드 -> 주문을 하면 최종주문결과를 return 한다
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
