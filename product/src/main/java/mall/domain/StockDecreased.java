package mall.domain;

import mall.domain.*;
import mall.infra.AbstractEvent;
import java.util.*;
import lombok.*;


@Data
@ToString
public class StockDecreased extends AbstractEvent {

    private Long id;
    private String productName;
    private Integer stock;

    public StockDecreased(Inventory aggregate){
        super(aggregate);
    }
    public StockDecreased(){
        super();
    }
}
