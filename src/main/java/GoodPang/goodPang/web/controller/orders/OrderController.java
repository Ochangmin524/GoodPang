package GoodPang.goodPang.web.controller.orders;

import GoodPang.goodPang.api.dto.MemberResponseDto;
import GoodPang.goodPang.api.dto.OrderRequestDto;
import GoodPang.goodPang.converter.CartConverter;
import GoodPang.goodPang.converter.CartItemConverter;
import GoodPang.goodPang.domain.cart.CartItem;
import GoodPang.goodPang.domain.member.Address;
import GoodPang.goodPang.domain.order.Orders;
import GoodPang.goodPang.service.CartItemService;
import GoodPang.goodPang.service.MemberService;
import GoodPang.goodPang.service.OrderService;
import GoodPang.goodPang.web.controller.carts.CartController;
import GoodPang.goodPang.web.webDto.OrderResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.jaxb.SpringDataJaxb;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final MemberService memberService;
    private final CartItemService cartItemService;


    @GetMapping("/orderPage")
    public String getOderPage(Model model) {
        MemberResponseDto.GetMemberResultDTO memberDto = memberService.getMemberDtoByLoginId(); //세션 조회
        Long memberId = memberDto.getMemberId();
        List<CartItem> cartItems = cartItemService.findCartItemByMemberId(memberId);
        model.addAttribute("totalPrice", cartItemService.getTotalPrice(cartItems));

        model.addAttribute("addressForm", new Address());
        model.addAttribute("cartItems", CartItemConverter.getCartItemResultDto(cartItems));
        model.addAttribute("member", memberDto);
        return "orders/orderPage";
    }

    @PostMapping("/createOrder")
    public String createOrder(@ModelAttribute("addressForm") Address address, Model model) {
        log.info("address : {}, {}, {}", address.getCity(), address.getStreet(), address.getZipcode());
        MemberResponseDto.GetMemberResultDTO memberDto = memberService.getMemberDtoByLoginId();
        OrderRequestDto.createOrderDto createOrderDto = getCreateOrderRequest(address, memberDto.getMemberId());
        orderService.createOrder(createOrderDto);


        return "redirect:orders/orderList";
    }
    private OrderRequestDto.createOrderDto getCreateOrderRequest(Address address, Long memberId) {

        OrderRequestDto.createOrderDto createOrderDto = new OrderRequestDto.createOrderDto();
        createOrderDto.setAddress(address);
        createOrderDto.setMemberId(memberId);
        createOrderDto.setCartItemId(cartItemService.getCartItemIds(cartItemService.findCartItemByMemberId(memberId)));
        return createOrderDto;
    }
    @GetMapping("orders/orderList")
    public String orderList(Model model) {
        OrderResponse.OrderListDto orderLists = orderService.getOrderLists();
        model.addAttribute("orders", orderLists);
        log.info("Order List: {}", orderLists.getOrderList()); // orders.getOrderList()가 null이 아닌지 확인

        return "orders/orderSuccess";
    }


}
