package kitchenpos.order.takeout.infra;

import kitchenpos.order.takeout.domain.TakeoutOrder;
import kitchenpos.order.takeout.domain.TakeoutOrderRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface JpaTakeoutOrderRepository extends TakeoutOrderRepository, JpaRepository<TakeoutOrder, UUID> {
}
