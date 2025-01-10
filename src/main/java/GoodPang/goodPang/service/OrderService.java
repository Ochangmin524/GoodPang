package GoodPang.goodPang.service;

import GoodPang.goodPang.converter.DeliveryConverter;
import GoodPang.goodPang.converter.OrderConverter;
import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.domain.item.Item;
import GoodPang.goodPang.domain.member.Member;
import GoodPang.goodPang.domain.order.Delivery;
import GoodPang.goodPang.domain.order.OrderItem;
import GoodPang.goodPang.domain.order.Orders;
import GoodPang.goodPang.repository.*;
import GoodPang.goodPang.response.exception.handler.CartHandler;
import GoodPang.goodPang.response.exception.handler.ItemHandler;
import GoodPang.goodPang.response.exception.handler.MemberHandler;
import GoodPang.goodPang.response.exception.handler.OrderHandler;
import GoodPang.goodPang.response.fail.ErrorStatus;
import GoodPang.goodPang.web.dto.OrderRequestDto;
import GoodPang.goodPang.web.dto.OrderResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;
    private final CartItemRepository cartItemRepository;
    private final OrderItemRepository orderItemRepository;
    private final DeliveryRepository deliveryRepository;

    //한번에 결제할 장바구니 상품들의 리스트가 입력된다.
    @Transactional
    public Orders createOrder(OrderRequestDto.createOrderDto request) {
        //멤버 조회
        Member member = memberRepository.findById(request.getMemberId()).orElseThrow(() -> new MemberHandler(ErrorStatus._MEMBER_NOT_FOUND));

        //order 생성
        Orders order = OrderConverter.toOrder(member);
        //장바구니 상품 조회 및 제고 비교
        for (Long cartItemId : request.getCartItemId()) {
            CartItem cartItem = cartItemRepository.findById(cartItemId).orElseThrow(() -> new CartHandler(ErrorStatus._CART_ITEM_NOT_FOUND));
            Item item = itemRepository.findById(cartItem.getItem().getId()).orElseThrow(() -> new ItemHandler(ErrorStatus._ITEM_NOT_FOUND));
            //제고 비교
            if (item.getStockQuantity() < cartItem.getCount()) {
                throw new ItemHandler(ErrorStatus._OUT_OF_STOCK);
            }

            //orderItem 생성
            OrderItem orderItem = OrderItem.builder()
                    .orderPrice(item.getPrice() * cartItem.getCount())
                    .count(cartItem.getCount())
                    .item(item)
                    .build();
            //order에 orderItem 추가
            order.addOrderItems(orderItem);
            //아이템 제고 수량 빼기
            item.removeCount(cartItem.getCount());
            //장바구니에서 장바구니 상품 제거
            member.getCart().removeCartItem(cartItem);
            orderItemRepository.save(orderItem); //orderitem 저장
            //장바구니 상품은 더티 체킹으로 사라질 것.
        }
        //배송정보 생성
        Delivery delivery = DeliveryConverter.toDelivery(request);

        //연관관계 매핑
        order.setDelivery(delivery);
        //order 저장
        deliveryRepository.save(delivery);
        return orderRepository.save(order);

        //order item 저장
    }

    @Transactional
    public Orders changeOrder(OrderRequestDto.changeOrderDto request) {
        Long orderId = request.getOrderId();
        Orders order = orderRepository.findById(orderId).orElseThrow(() -> new OrderHandler(ErrorStatus._ORDER_NOT_FOUND));
        order.changeOrderStatus(request.getOrderStatus()); //더티 체킹
        return order;
    }

    @Transactional(readOnly = true)
    public Orders  getOrder(Long orderId) {
         return orderRepository.findById(orderId).orElseThrow(() -> new OrderHandler(ErrorStatus._ORDER_NOT_FOUND));

    }





}

