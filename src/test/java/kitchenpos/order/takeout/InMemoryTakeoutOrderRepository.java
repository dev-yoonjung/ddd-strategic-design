package kitchenpos.order.takeout;

import kitchenpos.order.takeout.domain.TakeoutOrder;
import kitchenpos.order.takeout.domain.TakeoutOrderRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class InMemoryTakeoutOrderRepository implements TakeoutOrderRepository {
    private final Map<UUID, TakeoutOrder> orders = new HashMap<>();

    @Override
    public TakeoutOrder save(final TakeoutOrder order) {
        orders.put(order.getId(), order);
        return order;
    }

    @Override
    public Optional<TakeoutOrder> findById(final UUID id) {
        return Optional.ofNullable(orders.get(id));
    }

    @Override
    public List<TakeoutOrder> findAll() {
        return new ArrayList<>(orders.values());
    }

}
