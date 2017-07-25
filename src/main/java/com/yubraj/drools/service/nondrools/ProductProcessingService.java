package com.yubraj.drools.service.nondrools;

import com.yubraj.drools.model.Product;
import com.yubraj.drools.factory.ProcessingFactory;
import com.yubraj.drools.service.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by ypokhrel on 7/25/2017.
 */
@Component("ProductProcessingService")
public class ProductProcessingService implements Processor<List<Product>> {

    @Autowired
    @Qualifier("NoRulesProcessingFactory")
    private ProcessingFactory<Processor, Product> processingFactory;

    @Override
    public void process(List<Product> input) {
        for(Product product : input){
            Processor<Product> processor = processingFactory.createProcessingObject(product);
            processor.process(product);
        }
    }
}
