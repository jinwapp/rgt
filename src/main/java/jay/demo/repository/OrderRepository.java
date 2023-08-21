package jay.demo.repository;

import jay.demo.entity.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<OrderEntity,String> {

    @Query(value = "SELECT order_id, COUNT(order_id) AS order_count "
            + "	     FROM order_entity "
            + "	     GROUP BY order_id"
            + "	     HAVING COUNT(order_id) > 1; ", nativeQuery = true)
    List<Object[]> duplicatedList();

    @Query(value = "SELECT * "
            + "	     FROM order_entity "
            + "	     WHERE order_id = :order_id"
            + "	     LIMIT 1", nativeQuery = true)
    OrderEntity findByOrderId(@Param("order_id") String order_id);

    void deleteByOrderId(String orderId);

    @Modifying
    @Query(value = "DELETE FROM order_entity WHERE order_id = :order_id AND id NOT IN ("
            + "  SELECT id FROM order_entity WHERE order_id = :order_id ORDER BY id DESC LIMIT :order_count"
            + ")", nativeQuery = true)
    void deleteByOrderIdAndOrderCount(
            @Param("order_id") String orderId,
            @Param("order_count") Integer orderCount);

    @Modifying
    @Query(value = "UPDATE order_entity SET product_name = '카페라떼'"
            + "WHERE product_name = '카페테리아'", nativeQuery = true)
    void update();
}