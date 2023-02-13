package mall.domain;

import mall.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class DeliveryCompleted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long productId;
    private Integer qty;
    private String productName;
    private String status;
}
