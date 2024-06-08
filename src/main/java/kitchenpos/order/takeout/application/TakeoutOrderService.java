package kitchenpos.order.takeout.application;

import kitchenpos.menu.domain.Menu;
import kitchenpos.menu.domain.MenuRepository;
import kitchenpos.order.takeout.domain.TakeoutOrder;
import kitchenpos.order.takeout.domain.TakeoutOrderLineItem;
import kitchenpos.order.takeout.domain.TakeoutOrderRepository;
import kitchenpos.order.takeout.domain.TakeoutOrderStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class TakeoutOrderService {
    private final TakeoutOrderRepository takeoutOrderRepository;
    private final MenuRepository menuRepository;

    public TakeoutOrderService(
        final TakeoutOrderRepository takeoutOrderRepository,
        final MenuRepository menuRepository
    ) {
        this.takeoutOrderRepository = takeoutOrderRepository;
        this.menuRepository = menuRepository;
    }

    @Transactional
    public TakeoutOrder create(final TakeoutOrder request) {
        final List<TakeoutOrderLineItem> orderLineItemRequests = request.getTakeoutOrderLineItems();
        if (Objects.isNull(orderLineItemRequests) || orderLineItemRequests.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final List<Menu> menus = menuRepository.findAllByIdIn(
            orderLineItemRequests.stream()
                .map(TakeoutOrderLineItem::getMenuId)
                .toList()
        );
        if (menus.size() != orderLineItemRequests.size()) {
            throw new IllegalArgumentException();
        }
        final List<TakeoutOrderLineItem> takeoutOrderLineItems = new ArrayList<>();
        for (final TakeoutOrderLineItem takeoutOrderLineItemRequest : orderLineItemRequests) {
            final long quantity = takeoutOrderLineItemRequest.getQuantity();
            if (quantity < 0) {
                throw new IllegalArgumentException();
            }
            final Menu menu = menuRepository.findById(takeoutOrderLineItemRequest.getMenuId())
                .orElseThrow(NoSuchElementException::new);
            if (!menu.isDisplayed()) {
                throw new IllegalStateException();
            }
            if (menu.getPrice().compareTo(takeoutOrderLineItemRequest.getPrice()) != 0) {
                throw new IllegalArgumentException();
            }
            final TakeoutOrderLineItem takeoutOrderLineItem = new TakeoutOrderLineItem();
            takeoutOrderLineItem.setMenu(menu);
            takeoutOrderLineItem.setQuantity(quantity);
            takeoutOrderLineItems.add(takeoutOrderLineItem);
        }
        TakeoutOrder order = new TakeoutOrder();
        order.setId(UUID.randomUUID());
        order.setStatus(TakeoutOrderStatus.WAITING);
        order.setOrderDateTime(LocalDateTime.now());
        order.setTakeoutOrderLineItems(takeoutOrderLineItems);
        return takeoutOrderRepository.save(order);
    }

    @Transactional
    public TakeoutOrder accept(final UUID orderId) {
        final TakeoutOrder order = takeoutOrderRepository.findById(orderId)
            .orElseThrow(NoSuchElementException::new);
        if (order.getStatus() != TakeoutOrderStatus.WAITING) {
            throw new IllegalStateException();
        }
        order.setStatus(TakeoutOrderStatus.ACCEPTED);
        return order;
    }

    @Transactional
    public TakeoutOrder serve(final UUID orderId) {
        final TakeoutOrder order = takeoutOrderRepository.findById(orderId)
            .orElseThrow(NoSuchElementException::new);
        if (order.getStatus() != TakeoutOrderStatus.ACCEPTED) {
            throw new IllegalStateException();
        }
        order.setStatus(TakeoutOrderStatus.SERVED);
        return order;
    }

    @Transactional
    public TakeoutOrder complete(final UUID orderId) {
        final TakeoutOrder order = takeoutOrderRepository.findById(orderId)
            .orElseThrow(NoSuchElementException::new);
        final TakeoutOrderStatus status = order.getStatus();
        if (status != TakeoutOrderStatus.SERVED) {
            throw new IllegalStateException();
        }
        order.setStatus(TakeoutOrderStatus.COMPLETED);
        return order;
    }

    @Transactional(readOnly = true)
    public List<TakeoutOrder> findAll() {
        return takeoutOrderRepository.findAll();
    }
}
