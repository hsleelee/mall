package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class DeliveryCancelled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long productId;
    private Integer qty;
    private String productName;
    private String status;

    public DeliveryCancelled(Delivery aggregate){
        super(aggregate);
    }
    public DeliveryCancelled(){
        super();
    }
}
