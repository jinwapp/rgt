package jay.demo.controller;

import jay.demo.dto.ReqOrderPostDto;
import jay.demo.entity.OrderEntity;
import jay.demo.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RgtController {

    private final OrderService orderService;

    @PostMapping("/codingTest/post")
    public ResponseEntity<?> test1(@RequestBody ReqOrderPostDto reqOrderPostDto) {
        System.out.println(reqOrderPostDto.toString());
        return orderService.order(reqOrderPostDto);
    }

    @GetMapping("/codingTest")
    public void test1() {
        orderService.dataDuplicateProcess();
    }
}
