package com.niqa.microservices.order.client;

// import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;

// @FeignClient(value = "inventory", url = "${inventory.url}")
public interface InventoryClient {
    
    // @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
    @GetExchange("api/inventory")
    boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity);
}


// import org.springframework.cloud.openfeign.FeignClient;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestMethod;
// import org.springframework.web.bind.annotation.RequestParam;

// @FeignClient(value = "inventory", url = "https://localhost:8082")
// public interface InventoryClient {

//     @RequestMapping(method = RequestMethod.GET, value = "/api/inventory")
//     boolean isInstock(RequestParam String skuCode, @RequestParam integer quantity);
//     // boolean isInstock(RequestParam String skuCode, @RequestParam integer quantity);
// }

