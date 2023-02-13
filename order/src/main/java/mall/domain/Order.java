package mall.domain;

import mall.domain.OrderPlaced;
import mall.domain.OrderCanceled;
import mall.OrderApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Order_table")
@Data

public class Order  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    
    
    
    
    
    private Long id;
    
    
    
    
    
    private String productName;
    
    
    
    
    
    private Long customerId;
    
    
    
    
    
    private Long productId;
    
    
    
    
    
    private Integer qty;
    
    
    
    
    
    private String status;

    @PostPersist
    public void onPostPersist(){


        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

    }
    @PostUpdate
    public void onPostUpdate(){


        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();

    }
    @PreUpdate
    public void onPreUpdate(){
    }

    public static OrderRepository repository(){
        OrderRepository orderRepository = OrderApplication.applicationContext.getBean(OrderRepository.class);
        return orderRepository;
    }






}
