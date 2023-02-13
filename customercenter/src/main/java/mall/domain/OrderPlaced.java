package mall.domain;

import mall.infra.AbstractEvent;
import lombok.Data;
import java.util.*;


@Data
public class OrderPlaced extends AbstractEvent {

    private Long id;
    private String productName;
    private Long customerId;
    private Long productId;
    private Integer qty;
    private String status;
}
