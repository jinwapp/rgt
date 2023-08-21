package jay.demo.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import jay.demo.dto.ReqOrderPostDto;
import jay.demo.entity.OrderEntity;
import jay.demo.mapper.OrderMapper;
import jay.demo.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    /**
     * 1. RESTful API 작성, 2.2 데이터 수정
     */
    public ResponseEntity<?> order(ReqOrderPostDto reqOrderPostDto) {
        try {
            OrderEntity orderEntity = orderMapper.reqReqOrderPostDtoToOrderEntity(reqOrderPostDto);
            System.out.println(orderEntity.toString());
            OrderEntity savedOrderEntity = orderRepository.save(orderEntity);
            modifyData();
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonString = "<pre>" + objectMapper.writeValueAsString(savedOrderEntity) + "<pre/> 주문번호 : 0007 : 수신";
            System.out.println(jsonString);
            return new ResponseEntity(jsonString, HttpStatus.OK);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "Error");
        }
    }

    /**
     * 2.1 데이터 중복 처리
     */
    public void dataDuplicateProcess() {
        List<Object[]> objectList = orderRepository.duplicatedList();

        for (Object[] obj : objectList) {
            String orderId = (String) obj[0];
            Integer orderCount = Integer.valueOf((String) obj[1]);
            orderRepository.deleteByOrderIdAndOrderCount(orderId, orderCount);
        }
    }

    /**
     * 2.2 데이터 수정
     */
    public void modifyData() {
        orderRepository.update();
    }
}