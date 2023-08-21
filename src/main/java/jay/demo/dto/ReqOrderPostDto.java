package jay.demo.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@ToString
@Getter
public class ReqOrderPostDto {
    private String order_id;
    private String product_name;
    private String options;
    private Long table_no;
    private Long quantity;
    private String order_date;
    private String order_time;
    private String date_time;
    private String robot_status;
    private String dong;
    private String ho;
    private String seq;
    private String orderer_name;
}
