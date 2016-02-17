package com.example.rest;

import com.example.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/order")
public class OrderRestController {
    @Autowired
    private OrderService orderService;

    @RequestMapping(value = "/{name}/{price}", method = RequestMethod.POST)
    @ResponseBody
    public String addBookToOrder(@PathVariable("name") String name, @PathVariable("price") String price) {
        return orderService.addBookToOrder(new BookDTO(name, price)).getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void removeBookFromOrder(@PathVariable("id") String id) {
        orderService.deleteBookFromOrder(id);
    }

    @RequestMapping(value = "/calculate", method = RequestMethod.GET)
    @ResponseBody
    public String removeBookFromOrder() {
        return orderService.calculatePriceAfterAddingTax().getValue().toString();
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String previewOrder() {
        return orderService.previewOrder().toString();
    }
}
