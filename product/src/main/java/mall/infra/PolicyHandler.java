package mall.infra;

import javax.naming.NameParser;

import javax.naming.NameParser;
import javax.transaction.Transactional;

import mall.config.kafka.KafkaProcessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import mall.domain.*;

@Service
@Transactional
public class PolicyHandler{
    @Autowired InventoryRepository inventoryRepository;
    
    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString){}

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryCompleted'")
    public void wheneverDeliveryCompleted_StockDecrease(@Payload DeliveryCompleted deliveryCompleted){

        DeliveryCompleted event = deliveryCompleted;
        System.out.println("\n\n##### listener StockDecrease : " + deliveryCompleted + "\n\n");


        

        // Sample Logic //
        Inventory.stockDecrease(event);
        

        

    }

    @StreamListener(value=KafkaProcessor.INPUT, condition="headers['type']=='DeliveryReturned'")
    public void wheneverDeliveryReturned_StockIncrease(@Payload DeliveryReturned deliveryReturned){

        DeliveryReturned event = deliveryReturned;
        System.out.println("\n\n##### listener StockIncrease : " + deliveryReturned + "\n\n");


        

        // Sample Logic //
        Inventory.stockIncrease(event);
        

        

    }

}


