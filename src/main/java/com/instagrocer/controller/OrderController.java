package com.instagrocer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.instagrocer.business.OrderItemDTO;
import com.instagrocer.entity.ItemEntity;
import com.instagrocer.entity.OrderEntity;
import com.instagrocer.entity.OrderItem;
import com.instagrocer.service.ItemService;
import com.instagrocer.service.OrderItemService;
import com.instagrocer.service.OrderService;

@RestController
public class OrderController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ItemService itemService;
	@Autowired
	private OrderItemService orderItemService;
	
	@RequestMapping(value = "/placeOrder", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.TEXT_HTML_VALUE)
	public ResponseEntity<String> placeOrder(@RequestBody OrderForm form, Errors errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<String>(errors.getAllErrors()+" ", HttpStatus.BAD_REQUEST);
		} else {
			List<OrderItemDTO> formDtos = new ArrayList<OrderItemDTO>();
			OrderItemDTO itemDTO = new OrderItemDTO();
			ItemEntity itemEntity = new ItemEntity();
			itemEntity.setDescription("Raw organic brown eggs in a basket");
			itemEntity.setTitle("Brown eggs");
			itemEntity.setQuantity(1);
			itemEntity.setPrice(28.1);
			itemEntity.setItemId(2);
			itemDTO.setProduct(itemEntity);
			itemDTO.setQuantity(3);
			formDtos.add(itemDTO);
	        //validateProductsExistence(formDtos);
	        OrderEntity order = new OrderEntity();
	        order.setAmount(100.5);
	        order = orderService.placeOrder(order);

	        List<OrderItem> orderProducts = new ArrayList<>();
	        for (OrderItemDTO dto : formDtos) {
	            orderProducts.add(orderItemService.create(new OrderItem(order, itemService.getItemById(dto
	              .getProduct()
	              .getItemId()), dto.getQuantity())));
	        }

	        order.setItems(orderProducts);

	        orderService.placeOrder(order);
			//OrderEntity orderEntity = orderService.placeOrder(orderBean);
			return new ResponseEntity<String>("Order created successfully with order id : " + order.getOrderId(),
					HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value = "/getOrderById/{orderid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OrderEntity> getItemById(@PathVariable("orderid") int orderID) {
		OrderEntity bean = orderService.getOrderById(orderID);
		if (bean != null)
			return new ResponseEntity<OrderEntity>(bean, HttpStatus.OK);
		else
			return new ResponseEntity<OrderEntity>(HttpStatus.NOT_FOUND);
	}
	
	public static class OrderForm {

	    private List<OrderItemDTO> orderProducts;

	    public List<OrderItemDTO> getProductOrders() {
	        return orderProducts;
	    }

	    public void setProductOrders(List<OrderItemDTO> orderProducts) {
	        this.orderProducts = orderProducts;
	    }
	}
}


