package mall.domain;

import mall.domain.StockDecreased;
import mall.domain.StockIncreased;
import mall.ProductApplication;
import javax.persistence.*;
import java.util.List;
import lombok.Data;
import java.util.Date;


@Entity
@Table(name="Inventory_table")
@Data

public class Inventory  {


    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)    
    private Long id;    
    private String productName;    
    private Integer stock;

    @PostUpdate
    public void onPostUpdate(){


        // StockDecreased stockDecreased = new StockDecreased(this);
        // stockDecreased.publishAfterCommit();



        // StockIncreased stockIncreased = new StockIncreased(this);
        // stockIncreased.publishAfterCommit();

    }

    public static InventoryRepository repository(){
        InventoryRepository inventoryRepository = ProductApplication.applicationContext.getBean(InventoryRepository.class);
        return inventoryRepository;
    }



    public static void stockDecrease(DeliveryStarted deliveryStarted){
        repository().findById(deliveryStarted.getProductId()).ifPresent(inventory->{
            inventory.setStock(inventory.getStock() - deliveryStarted.getQty());
            repository().save(inventory);

            StockDecreased stockDecreased = new StockDecreased(inventory);
            stockDecreased.publishAfterCommit();
         });
        
    }
    public static void stockIncrease(DeliveryCancelled deliveryCancelled){
        
        repository().findById(deliveryCancelled.getProductId()).ifPresent(inventory->{            
            inventory.setStock(inventory.getStock() + deliveryCancelled.getQty());
            repository().save(inventory);

            StockIncreased stockIncreased = new StockIncreased(inventory);
            stockIncreased.publishAfterCommit();
         });      
    }

}
