# 키친포스

## 퀵 스타트

```sh
cd docker
docker compose -p kitchenpos up -d
```

## 요구 사항

### 상품

- 상품을 등록할 수 있다.
- 상품의 가격이 올바르지 않으면 등록할 수 없다.
    - 상품의 가격은 0원 이상이어야 한다.
- 상품의 이름이 올바르지 않으면 등록할 수 없다.
    - 상품의 이름에는 비속어가 포함될 수 없다.
- 상품의 가격을 변경할 수 있다.
- 상품의 가격이 올바르지 않으면 변경할 수 없다.
    - 상품의 가격은 0원 이상이어야 한다.
- 상품의 가격이 변경될 때 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 크면 메뉴가 숨겨진다.
- 상품의 목록을 조회할 수 있다.

### 메뉴 그룹

- 메뉴 그룹을 등록할 수 있다.
- 메뉴 그룹의 이름이 올바르지 않으면 등록할 수 없다.
    - 메뉴 그룹의 이름은 비워 둘 수 없다.
- 메뉴 그룹의 목록을 조회할 수 있다.

### 메뉴

- 1 개 이상의 등록된 상품으로 메뉴를 등록할 수 있다.
- 상품이 없으면 등록할 수 없다.
- 메뉴에 속한 상품의 수량은 0 이상이어야 한다.
- 메뉴의 가격이 올바르지 않으면 등록할 수 없다.
    - 메뉴의 가격은 0원 이상이어야 한다.
- 메뉴에 속한 상품 금액의 합은 메뉴의 가격보다 크거나 같아야 한다.
- 메뉴는 특정 메뉴 그룹에 속해야 한다.
- 메뉴의 이름이 올바르지 않으면 등록할 수 없다.
    - 메뉴의 이름에는 비속어가 포함될 수 없다.
- 메뉴의 가격을 변경할 수 있다.
- 메뉴의 가격이 올바르지 않으면 변경할 수 없다.
    - 메뉴의 가격은 0원 이상이어야 한다.
- 메뉴에 속한 상품 금액의 합은 메뉴의 가격보다 크거나 같아야 한다.
- 메뉴를 노출할 수 있다.
- 메뉴의 가격이 메뉴에 속한 상품 금액의 합보다 높을 경우 메뉴를 노출할 수 없다.
- 메뉴를 숨길 수 있다.
- 메뉴의 목록을 조회할 수 있다.

### 주문 테이블

- 주문 테이블을 등록할 수 있다.
- 주문 테이블의 이름이 올바르지 않으면 등록할 수 없다.
    - 주문 테이블의 이름은 비워 둘 수 없다.
- 빈 테이블을 해지할 수 있다.
- 빈 테이블로 설정할 수 있다.
- 완료되지 않은 주문이 있는 주문 테이블은 빈 테이블로 설정할 수 없다.
- 방문한 손님 수를 변경할 수 있다.
- 방문한 손님 수가 올바르지 않으면 변경할 수 없다.
    - 방문한 손님 수는 0 이상이어야 한다.
- 빈 테이블은 방문한 손님 수를 변경할 수 없다.
- 주문 테이블의 목록을 조회할 수 있다.

### 주문

- 1개 이상의 등록된 메뉴로 배달 주문을 등록할 수 있다.
- 1개 이상의 등록된 메뉴로 포장 주문을 등록할 수 있다.
- 1개 이상의 등록된 메뉴로 매장 주문을 등록할 수 있다.
- 주문 유형이 올바르지 않으면 등록할 수 없다.
- 메뉴가 없으면 등록할 수 없다.
- 매장 주문은 주문 항목의 수량이 0 미만일 수 있다.
- 매장 주문을 제외한 주문의 경우 주문 항목의 수량은 0 이상이어야 한다.
- 배달 주소가 올바르지 않으면 배달 주문을 등록할 수 없다.
    - 배달 주소는 비워 둘 수 없다.
- 빈 테이블에는 매장 주문을 등록할 수 없다.
- 숨겨진 메뉴는 주문할 수 없다.
- 주문한 메뉴의 가격은 실제 메뉴 가격과 일치해야 한다.
- 주문을 접수한다.
- 접수 대기 중인 주문만 접수할 수 있다.
- 배달 주문을 접수되면 배달 대행사를 호출한다.
- 주문을 서빙한다.
- 접수된 주문만 서빙할 수 있다.
- 주문을 배달한다.
- 배달 주문만 배달할 수 있다.
- 서빙된 주문만 배달할 수 있다.
- 주문을 배달 완료한다.
- 배달 중인 주문만 배달 완료할 수 있다.
- 주문을 완료한다.
- 배달 주문의 경우 배달 완료된 주문만 완료할 수 있다.
- 포장 및 매장 주문의 경우 서빙된 주문만 완료할 수 있다.
- 주문 테이블의 모든 매장 주문이 완료되면 빈 테이블로 설정한다.
- 완료되지 않은 매장 주문이 있는 주문 테이블은 빈 테이블로 설정하지 않는다.
- 주문 목록을 조회할 수 있다.

## 용어 사전

### 0. 기타

| 한글명   | 영문명         | 설명                                                   |
|-------|-------------|------------------------------------------------------|
| 키친 포스 | kitchen pos | 매장 운영 및 물품 판매를 목적으로 만들어진 시스템                         |
| 판매자   | seller      | 매장에서 메뉴를 판매 및 주문을 받는 사람                              |
| 손님    | customer    | 매장에 돈을 지불하고 판매자에게 주문을 하는 사람                          |
| 매장    | store       | 판매자가 메뉴를 판매 및 주문을 받는 장소 <br/> 손님이 주문한 메뉴를 식사할 수도 있다. |
| 비속어   | profanity   | 욕설 및 부적절한 단어를 지칭                                     |

### 1. 상품

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
| 상품 | product | 판매자가 팔고자 하는 음식을 의미하며, 메뉴를 구성하는 최소의 단위 |
| 상품 가격 | product price | 상품을 구매하기 위한 가격 |
| 상품 이름 | product name | 상품을 구별하기 위해 부르는 말 |
| 상품 목록 | products | 포스 시스템에 등록되어 있는 상품의 목록 |
| 상품을 등록하다 | register product | 상품을 포스 시스템에 등록하는 행위 |
| 상품의 가격을 변경하다 | change product price | 포스 시스템에 등록되어 있는 해당 상품의 가격을 변경하는 행위 |
| 상품의 목록을 조회하다 | retrieve products | 포스 시스템에 등록되어 있는 상품의 목록을 조회하는 행위 |

### 2. 메뉴그룹

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
| 메뉴 그룹 | menu group | 여러 메뉴를 묶어 분류하여 그룹화한 단위 |
| 메뉴 그룹 이름 | menu group name | 메뉴 그룹을 구별하기 위해 부르는 말 |
| 메뉴 그룹 목록 | menu groups | 포스 시스템에 등록되어 있는 메뉴 그룹 목록 |
| 메뉴 그룹을 등록하다 | register menu group | 메뉴 그룹을 포스 시스템에 등록하는 행위 |
| 메뉴 그룹 목록을 조회하다 | retrieve menu group | 포스 시스템에 등록되어 있는 메뉴 그룹의 목록을 조회하는 행위 |

### 3. 메뉴

| 한글명           | 영문명                  | 설명                                   |
|---------------|----------------------|--------------------------------------|
| 메뉴            | menu                 | 손님이 주문할 수 있는 단위                      |
| 메뉴 가격         | menu price           | 손님이 메뉴를 주문하기 위해 지불해야 하는 금액           |
| 메뉴 이름         | menu name            | 메뉴를 구별하기 위해 부르는 말                    |
| 메뉴 노출 여부      | displayed            | 손님이 해당 메뉴를 주문할 수 있도록 노출되어 있는지에 대한 여부 |
| 메뉴 목록         | menus                | 포스 시스템에 등록되어 있는 메뉴의 목록               |
| 메뉴에 속한 상품     | menu product         | 메뉴를 구성하고 있는 상품                       |
| 메뉴에 속한 상품의 수량 | menu product quantity | 메뉴에 속한 상품에 대한 수량                     |
| 메뉴에 속한 상품의 가격 | menu product price   | 메뉴에 속한 상품에 대한 가격                     |
| 메뉴에 속한 상품 목록  | menu products        | 메뉴를 구성하고 있는 상품들의 목록                  |
| 메뉴를 등록하다      | register menu        | 메뉴를 포스 시스템에 등록하는 행위                  |
| 메뉴 가격을 변경하다   | change menu price    | 포스 시스템에 등록되어 있는 해당 메뉴 가격을 변경하는 행위    |
| 메뉴를 노출하다      | display menu         | 손님이 해당 메뉴를 주문할 수 있도록 노출하는 행위         |
| 메뉴를 숨기다       | hide menu            | 손님이 해당 메뉴를 주문할 수 없도록 숨기는 행위          |
| 메뉴 목록을 조회하다   | retrieve menus       | 포스 시스템에 등록되어 있는 메뉴의 목록을 조회하는 행위      |

### 4. 주문테이블

| 한글명              | 영문명                   | 설명                                         |
|------------------|-----------------------|--------------------------------------------|
| 주문 테이블           | order table           | 매장에서 손님이 메뉴를 소비할 수 있는 테이블                  |
| 주문 테이블 이름        | order table name      | 주문 테이블을 구별하기 위해 부르는 말                      |
| 올바르지 않은 주문 테이블 이름 | invalid order table name | 포스 시스템에 등록할 수 없는 주문 테이블 이름                 |
| 빈 주문 테이블         | empty order table     | 아무도 앉지 않은 주문 테이블                           |
| 방문한 손님 수         | number of guest       | 현재 주문 테이블에 앉아 있는 손님의 수                     |
| 주문 테이블 점유 여부     | occupied              | 현재 주문 테이블에 손님이 앉아 있는 지에 대한 여부              |
| 주문 테이블 목록        | order tables          | 포스 시스템에 등록되어 있는 주문 테이블의 목록                 |
| 주문 테이블을 등록하다     | register order table  | 주문 테이블을 포스 시스템에 등록하는 행위                    |
| 정리하다             | clear order table     | 주문 테이블에 앉았던 손님이 떠나 다른 손님이 앉을 수 있도록 정리하는 행위 |
| 앉다               | sit order table       | 빈 주문 테이블에 손님이 앉는 행위                        |
| 주문 테이블 목록을 조회하다  | retrieve order tables | 포스 시스템에 등록되어 있는 주문 테이블의 목록을 조회하는 행위        |
| 방문한 손님 수를 변경하다   | change number of guest | 현재 주문 테이블에 앉아 있는 손님의 수를 변경한다.              |

### 5. 주문

| 한글명 | 영문명 | 설명 |
| --- | --- | --- |
| 주문 | order | 손님이 메뉴를 소비하기 위해 판매자에게 메뉴를 요청하는 것 |
| 주문 유형 | order type | 손님에게 메뉴를 전달하는 방식에 따른 구분 |
| 주문 목록 | orders | 포스 시스템에 등록되어 있는 주문의 목록 |
| 주문 목록을 조회하다 | retrieve orders | 포스 시스템에 등록되어 있는 주문 목록을 조회하는 행위 |

### 5-1. 매장 주문

| 한글명         | 영문명                             | 설명                                   |
|-------------|---------------------------------|--------------------------------------|
| 매장 주문       | eat in order                    | 손님이 매장의 주문 테이블에 앉아 메뉴를 소비하는 유형의 주문   |
| 매장 주문 일시    | eat in order date time          | 손님이 판매자에게 매장 주문을 요청한 날짜 및 시각         |
| 매장 주문 상태    | eat in order status             | 현재 매장 주문의 진행 상태                      |
| 접수 대기       | waiting                         | 손님이 주문한 후 판매자가 접수하기 전까지의 상태          |
| 접수          | accepted                        | 판매자가 주문건에 대해 접수를 한 상태                |
| 서빙          | served                          | 판매자가 메뉴 준비를 완료한 후 매장의 주문 테이블로 전달한 상태 |
| 주문 완료       | completed                       | 주문이 완료된 상태                           |
| 매장 주문 항목    | eat in order line item          | 손님이 매장 주문한 메뉴 목록의 항목                 |
| 매장 주문 항목 수량 | eat in order line item quantity | 매장 주문 항목에 대한 수량                      |
| 매장 주문 항목 가격 | eat in order line item price         | 매장 주문 항목에 대한 가격                      |
| 매장 주문을 등록하다 | register eat in order           | 매장 주문을 포스 시스템에 등록하는 행위               |

### 5-2. 배달 주문

| 한글명              | 영문명                                 | 설명                                                 |
|------------------|-------------------------------------|----------------------------------------------------|
| 배달 주문            | delivery order                      | 손님이 매장에 방문하여 요청한 메뉴를 가지고 가는 유형의 주문                 |
| 배달 주소            | delivery address                    | 손님이 주문한 주문 항목을 배달해야 하는 주소                          |
| 배달 주문 일시         | delivery order date time            | 손님이 판매자에게 배달 주문을 요청한 날짜 및 시각                       |
| 배달 주문 상태         | delivery order status               | 현재 배달 주문의 진행 상태                                    |
| 접수 대기            | waiting                             | 손님이 주문한 후 판매자가 접수하기 전까지의 상태                        |
| 접수               | accepted                            | 판매자가 주문건에 대해 접수를 한 상태                              |
| 서빙               | served                              | 판매자가 메뉴 준비를 완료한 후 손님에게 배달을 하기 위해 배달 기사에게 메뉴를 전달한 상태 |
| 배달 중             | delivering                          | 메뉴를 전달받은 배달 기사가 손님에게 배달 중인 상태                      |
| 배달 완료            | delivered                           | 배달 기사가 손님이 요청한 배달 주소에 메뉴 배달이 완료된 상태                |
| 주문 완료            | completed                           | 주문이 완료된 상태                                         |
| 배달 대행사           | delivery agency                     | 주문에 대한 배달을 대신 수행해주는 대행사                            |
| 배달 기사            | delivery rider                      | 손님에게 메뉴를 전달하기 위해 배달을 수행하는 배달 대행사 소속 라이더            |
| 배달 주문 항목         | delivery order line item            | 손님이 배달 주문한 메뉴 목록의 항목                               |
| 배달 주문 항목 수량      | delivery order line item quantity   | 배달 주문 항목에 대한 수량                                    |
| 배달 주문 항목 가격      | delivery order line item price           | 배달 주문 항목에 대한 가격                                    |
| 배달 주문을 등록하다      | register delivery order             | 배달 주문을 포스 시스템에 등록하는 행위                             |
| 배달 대행사에 배달을 요청하다 | request delivery to delivery agency | 판매자가 손님에게 배달 주문 항목을 배달하기 위해 배달 대행사에 배달을 요청하는 행위    |

### 5-3. 포장 주문

| 한글명         | 영문명                              | 설명                                         |
|-------------|----------------------------------|--------------------------------------------|
| 포장 주문       | takeout order                    | 손님이 매장에 방문하여 요청한 메뉴를 가지고 가는 유형의 주문         |
| 포장 주문 일시    | takeout order date time          | 손님이 판매자에게 포장 주문을 요청한 날짜 및 시각               |
| 포장 주문 상태    | takeout order status             | 현재 포장 주문의 진행 상태                            |
| 접수 대기       | waiting                          | 손님이 주문한 후 판매자가 접수하기 전까지의 상태                |
| 접수          | accepted                         | 판매자가 주문건에 대해 접수를 한 상태                      |
| 서빙          | served                           | 판매자가 메뉴 준비를 완료한 후 손님이 매장에 방문하여 메뉴를 가지고 간 상태 |
| 주문 완료       | completed                        | 주문이 완료된 상태                                 |
| 포장 주문 항목    | takeout order line item          | 손님이 포장 주문한 메뉴 목록의 항목                       |
| 포장 주문 항목 수량 | takeout order line item quantity | 포장 주문 항목에 대한 수량                            |
| 포장 주문 항목 가격 | takeout order line item price         | 포장 주문 항목에 대한 가격                            |
| 포장 주문을 등록하다 | register takeout order           | 포장 주문을 포스 시스템에 등록하는 행위                     |

## 모델링

<img src="https://file.notion.so/f/f/1011ccbc-e1ee-4af0-9d87-e570697dbbb4/c2c672e2-b914-4a3b-8962-b1a6942ba5ba/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-06-01_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_4.33.03.png?id=d742521e-704f-4166-b567-c60383449108&table=block&spaceId=1011ccbc-e1ee-4af0-9d87-e570697dbbb4&expirationTimestamp=1717322400000&signature=fHZyDOe2dnuZaqS_AbHR-zO2IRQxrLh2NUMitESOTfg&downloadName=%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA+2024-06-01+%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE+4.33.03.png" />

### 상품(Product)

- `Product`는 식별자와 `profanity`가 포함되지 않은 `productName` 그리고 0원 이상의 `productPrice`를 가진다.

### 메뉴(Menu)

- `MenuGroup`은 식별자와 공백이 아닌 `menuGroupName`을 가진다.


-`Menu`는 식별자와 `profanity`가 포함되지 않은 `menuName`, 0원 이상의 `menuPrice`, 메뉴 노출 여부를 나타내는 `displayed`, 그리고 `menuProduct`들을 가진다.
- `Menu`는 반드시 `MenuGroup`에 속해있어야 한다.
- `Menu`는 `menuProduct`들의 가격(`menuProductQuantity` * `menuProductPrice`)들의 합계보다 가격이 높지 않아야 한다는 가격정책을 가지고 있다.
- `Menu`는 가격정책 내에서 `menuPrice`를 변경할 수 있다.
- 가격정책이 지켜진 `Menu`는 고객이 볼 수 있도록 노출할 수 있다.
- `Menu`를 고객이 볼 수 없도록 숨길 수 있다.


- `MenuProduct`는 `profanity`가 포함되지 않은 `productName`, 0원 이상의 `productPrice`, 그리고 0개 이상의 `menuProductQuantity`를 가진다.

### 매장 주문(Eat in Order)

- `OrderTable`은 식별자, 공백이 아닌 `orderTableName`, 0명 이상의 `numberOfGuest`, 그리고 현재 고객이 앉아 있는지 테이블의 상태를 확인하기 위한 `occupied`를 가진다.
- `completed`되지 않은 `Order`가 없는 `OrderTable`은 고객이 앉을 수 있게 정리할 수 있다.
- `OrderTable`에 고객이 앉을 수 있다.
- 고객이 앉아 있는 `OrderTable`은 `numberOfGuest`를 변경할 수 있다.


- `EatInOrderLineItem`은 고객에게 노출되어 있는 `Menu`, `eatInOrderLineItemPrice` 그리고 `eatInOrderLineItemQuantity`를 가진다.


- `EatInOrder`는 식별자, `eatInOrderStatus`, `eatInOrderDateTime`, 고객이 앉아 있는 `OrderTable` 그리고 1개 이상의 `EatInOrderLineItem`을 가진다. 
- `EatInOrder`은 `WAITING` ▶︎ `ACCEPTED` ▶︎ `SERVED` ▶︎ `COMPLETED`의 순서로 주문이 진행된다.
  <img src="https://file.notion.so/f/f/1011ccbc-e1ee-4af0-9d87-e570697dbbb4/410a3880-f321-49d6-ae8d-2323fd68585f/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-06-01_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_5.07.18.png?id=414759eb-a0f4-42f4-8cd6-c7614af15f57&table=block&spaceId=1011ccbc-e1ee-4af0-9d87-e570697dbbb4&expirationTimestamp=1717322400000&signature=3m4mwPW8_4Wp8uOONtuyPEZBOaZtE2RcTh8WZ0_UL8A&downloadName=%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA+2024-06-01+%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE+5.07.18.png" />



### 배달 주문(Delivery Order)

- `DeliveryOrderLineItem`은 고객에게 노출되어 있는 `Menu`, `deliveryOrderLineItemPrice` 그리고 0개 이상의 `deliveryOrderLineItemQuantity`를 가진다.


- `DeliveryOrder`는 식별자, `deliveryOrderStatus`, `deliveryOrderDateTime`, 공백일 수 없는 `deliveryAddress`, 그리고 1개 이상의 `DeliveryOrderLineItem`을 가진다.
- `DeliveryOrder`은 `WAITING` ▶︎ `ACCEPTED` ▶︎ `SERVED` ▶︎ `DELIVERING` ▶︎ `DELIVERED` ▶︎ `COMPLETED`의 순서로 주문이 진행된다.


### 포장 주문(Takeout Order)

- `TakeoutOrderLineItem`은 고객에게 노출되어 있는 `Menu`, `takeoutOrderLineItemPrice` 그리고 0개 이상의 `deliveryOrderLineItemQuantity`를 가진다.


- `TakeoutOrder`는 식별자, `takeoutOrderStatus`, `takeoutOrderDateTime`, 그리고 1개 이상의 `TakeoutOrderLineItem`을 가진다.
- `TakeoutOrder`은 `WAITING` ▶︎ `ACCEPTED` ▶︎ `SERVED` ▶︎ `COMPLETED`의 순서로 주문이 진행된다.
   <img src="https://file.notion.so/f/f/1011ccbc-e1ee-4af0-9d87-e570697dbbb4/e126fd4b-edac-4da4-9c37-573d0842c2e9/%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2024-06-01_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_5.59.48.png?id=3f17249b-d264-46c3-a4e3-43e0d28ba86b&table=block&spaceId=1011ccbc-e1ee-4af0-9d87-e570697dbbb4&expirationTimestamp=1717322400000&signature=0aRHURVpUjsXifvEXNvoYUgZdWf9O7K0qgjVJ4vdLzc&downloadName=%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA+2024-06-01+%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE+5.59.48.png" />
