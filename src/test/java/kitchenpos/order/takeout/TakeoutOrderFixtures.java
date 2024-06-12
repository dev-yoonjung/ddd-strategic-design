package kitchenpos.order.takeout;

import kitchenpos.order.takeout.domain.TakeoutOrder;
import kitchenpos.order.takeout.domain.TakeoutOrderLineItem;
import kitchenpos.order.takeout.domain.TakeoutOrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static kitchenpos.menu.MenuFixtures.menu;

public class TakeoutOrderFixtures {

    public static final UUID INVALID_ID = new UUID(0L, 0L);

    public static TakeoutOrder order(final TakeoutOrderStatus status) {
        final TakeoutOrder order = new TakeoutOrder();
        order.setId(UUID.randomUUID());
        order.setStatus(status);
        order.setOrderDateTime(LocalDateTime.of(2020, 1, 1, 12, 0));
        order.setTakeoutOrderLineItems(List.of(takeoutOrderLineItem()));
        return order;
    }

    public static TakeoutOrderLineItem takeoutOrderLineItem() {
        final TakeoutOrderLineItem orderLineItem = new TakeoutOrderLineItem();
        orderLineItem.setSeq(new Random().nextLong());
        orderLineItem.setMenu(menu());
        return orderLineItem;
    }

}
