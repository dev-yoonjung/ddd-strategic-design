package kitchenpos.order.eatin.infra;

import kitchenpos.asis.domain.Order;
import kitchenpos.asis.domain.OrderRepository;
import kitchenpos.order.eatin.domain.EatInOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaEatInOrderRepository extends EatInOrderRepository, JpaRepository<Order, UUID> {
}
