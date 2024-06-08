package kitchenpos.order.eatin;

import kitchenpos.asis.domain.Order;
import kitchenpos.asis.domain.OrderLineItem;
import kitchenpos.asis.domain.OrderStatus;
import kitchenpos.asis.domain.OrderType;
import kitchenpos.order.eatin.domain.EatInOrder;
import kitchenpos.order.eatin.domain.EatInOrderLineItem;
import kitchenpos.order.eatin.domain.EatInOrderStatus;
import kitchenpos.order.eatin.domain.OrderTable;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static kitchenpos.menu.MenuFixtures.menu;

public class EatInOrderFixtures {

    public static final UUID INVALID_ID = new UUID(0L, 0L);

    public static EatInOrder order(final EatInOrderStatus status, final OrderTable orderTable) {
        final EatInOrder order = new EatInOrder();
        order.setId(UUID.randomUUID());
        order.setStatus(status);
        order.setOrderDateTime(LocalDateTime.of(2020, 1, 1, 12, 0));
        order.setEatInOrderLineItems(List.of(eatInOrderLineItem()));
        order.setOrderTable(orderTable);
        return order;
    }

    public static EatInOrderLineItem eatInOrderLineItem() {
        final EatInOrderLineItem orderLineItem = new EatInOrderLineItem();
        orderLineItem.setSeq(new Random().nextLong());
        orderLineItem.setMenu(menu());
        return orderLineItem;
    }

}
