package kitchenpos.menu.domain;

import kitchenpos.menu.domain.MenuGroup;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MenuGroupRepository {
    MenuGroup save(MenuGroup menuGroup);

    Optional<MenuGroup> findById(UUID id);

    List<MenuGroup> findAll();
}

