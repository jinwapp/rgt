package jay.demo.entity;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.Value;

import javax.persistence.*;


@Entity
@ToString
@Getter
@Setter
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long primaryId;
    @Column (name = "order_id")
    private String orderId;
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
