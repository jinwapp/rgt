package jay.demo.mapper;
import jay.demo.dto.ReqOrderPostDto;
import jay.demo.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;


@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderMapper {
    @Mapping(source = "order_id", target = "orderId")
    OrderEntity reqReqOrderPostDtoToOrderEntity(ReqOrderPostDto reqOrderPostDto);
}
