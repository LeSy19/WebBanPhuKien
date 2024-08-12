package com.poly.controller;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.poly.entity.Order;
import com.poly.service.OrderService;

@Controller
public class OrderController {
	
	@Autowired
	OrderService orderService;

	@RequestMapping("/order/checkout")
	public String checkout() {
		return "order/checkout";
	}
	
	@RequestMapping("/order/list")
	public String list(Model model, HttpServletRequest request) {
		String username = request.getRemoteUser();

        List<Order> orders = orderService.findByUsername(username);

        // Sắp xếp theo ngày từ mới nhất đến cũ nhất
        List<Order> sortedOrders = orders.stream()
            .sorted(Comparator.comparing(Order::getCreateDate).reversed())
            .collect(Collectors.toList());

        model.addAttribute("orders", sortedOrders);
		return "order/list";
	}
	
	@RequestMapping("/order/detail/{id}")
	public String detail(@PathVariable("id") Long id, Model model) {
		model.addAttribute("order", orderService.findById(id));
		return "order/detail";
	}
}
