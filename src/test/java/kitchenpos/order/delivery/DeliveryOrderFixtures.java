package kitchenpos.order.delivery;

import kitchenpos.order.delivery.domain.DeliveryOrder;
import kitchenpos.order.delivery.domain.DeliveryOrderLineItem;
import kitchenpos.order.delivery.domain.DeliveryOrderStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import static kitchenpos.menu.MenuFixtures.menu;

public class DeliveryOrderFixtures {

    public static final UUID INVALID_ID = new UUID(0L, 0L);

    public static DeliveryOrder order(final DeliveryOrderStatus status, final String deliveryAddress) {
        final DeliveryOrder order = new DeliveryOrder();
        order.setId(UUID.randomUUID());
        order.setStatus(status);
        order.setOrderDateTime(LocalDateTime.of(2020, 1, 1, 12, 0));
        order.setDeliveryOrderOrderLineItems(List.of(orderLineItem()));
        order.setDeliveryAddress(deliveryAddress);
        return order;
    }

    public static DeliveryOrderLineItem orderLineItem() {
        final DeliveryOrderLineItem orderLineItem = new DeliveryOrderLineItem();
        orderLineItem.setSeq(new Random().nextLong());
        orderLineItem.setMenu(menu());
        return orderLineItem;
    }

}
