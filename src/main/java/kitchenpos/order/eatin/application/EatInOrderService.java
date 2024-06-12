package kitchenpos.order.eatin.application;

import kitchenpos.menu.domain.Menu;
import kitchenpos.menu.domain.MenuRepository;
import kitchenpos.order.eatin.domain.EatInOrder;
import kitchenpos.order.eatin.domain.EatInOrderLineItem;
import kitchenpos.order.eatin.domain.EatInOrderRepository;
import kitchenpos.order.eatin.domain.EatInOrderStatus;
import kitchenpos.order.eatin.domain.OrderTable;
import kitchenpos.order.eatin.domain.OrderTableRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.UUID;

@Service
public class EatInOrderService {
    private final EatInOrderRepository eatInOrderRepository;
    private final MenuRepository menuRepository;
    private final OrderTableRepository orderTableRepository;

    public EatInOrderService(
        final EatInOrderRepository eatInOrderRepository,
        final MenuRepository menuRepository,
        final OrderTableRepository orderTableRepository
    ) {
        this.eatInOrderRepository = eatInOrderRepository;
        this.menuRepository = menuRepository;
        this.orderTableRepository = orderTableRepository;
    }

    @Transactional
    public EatInOrder create(final EatInOrder request) {
        final List<EatInOrderLineItem> eatInOrderLineItemRequests = request.getEatInOrderLineItems();
        if (Objects.isNull(eatInOrderLineItemRequests) || eatInOrderLineItemRequests.isEmpty()) {
            throw new IllegalArgumentException();
        }
        final List<Menu> menus = menuRepository.findAllByIdIn(
                eatInOrderLineItemRequests.stream()
                .map(EatInOrderLineItem::getMenuId)
                .toList()
        );
        if (menus.size() != eatInOrderLineItemRequests.size()) {
            throw new IllegalArgumentException();
        }
        final List<EatInOrderLineItem> eatInOrderLineItems = new ArrayList<>();
        for (final EatInOrderLineItem eatInOrderLineItemRequest : eatInOrderLineItemRequests) {
            final long quantity = eatInOrderLineItemRequest.getQuantity();
            final Menu menu = menuRepository.findById(eatInOrderLineItemRequest.getMenuId())
                .orElseThrow(NoSuchElementException::new);
            if (!menu.isDisplayed()) {
                throw new IllegalStateException();
            }
            if (menu.getPrice().compareTo(eatInOrderLineItemRequest.getPrice()) != 0) {
                throw new IllegalArgumentException();
            }
            final EatInOrderLineItem eatInOrderLineItem = new EatInOrderLineItem();
            eatInOrderLineItem.setMenu(menu);
            eatInOrderLineItem.setQuantity(quantity);
            eatInOrderLineItems.add(eatInOrderLineItem);
        }
        EatInOrder order = new EatInOrder();
        order.setId(UUID.randomUUID());
        order.setStatus(EatInOrderStatus.WAITING);
        order.setOrderDateTime(LocalDateTime.now());
        order.setEatInOrderLineItems(eatInOrderLineItems);
        final OrderTable orderTable = orderTableRepository.findById(request.getOrderTableId())
                .orElseThrow(NoSuchElementException::new);
        if (!orderTable.isOccupied()) {
            throw new IllegalStateException();
        }
        order.setOrderTable(orderTable);
        return eatInOrderRepository.save(order);
    }

    @Transactional
    public EatInOrder accept(final UUID orderId) {
        final EatInOrder order = eatInOrderRepository.findById(orderId)
            .orElseThrow(NoSuchElementException::new);
        if (order.getStatus() != EatInOrderStatus.WAITING) {
            throw new IllegalStateException();
        }
        order.setStatus(EatInOrderStatus.ACCEPTED);
        return order;
    }

    @Transactional
    public EatInOrder serve(final UUID orderId) {
        final EatInOrder order = eatInOrderRepository.findById(orderId)
            .orElseThrow(NoSuchElementException::new);
        if (order.getStatus() != EatInOrderStatus.ACCEPTED) {
            throw new IllegalStateException();
        }
        order.setStatus(EatInOrderStatus.SERVED);
        return order;
    }

    @Transactional
    public EatInOrder complete(final UUID orderId) {
        final EatInOrder order = eatInOrderRepository.findById(orderId)
            .orElseThrow(NoSuchElementException::new);
        final EatInOrderStatus status = order.getStatus();
        if (status != EatInOrderStatus.SERVED) {
            throw new IllegalStateException();
        }
        order.setStatus(EatInOrderStatus.COMPLETED);
        final OrderTable orderTable = order.getOrderTable();
        if (!eatInOrderRepository.existsByOrderTableAndStatusNot(orderTable, EatInOrderStatus.COMPLETED)) {
            orderTable.setNumberOfGuests(0);
            orderTable.setOccupied(false);
        }
        return order;
    }

    @Transactional(readOnly = true)
    public List<EatInOrder> findAll() {
        return eatInOrderRepository.findAll();
    }
}
