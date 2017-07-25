package com.yubraj.drools.factory.drools;

import com.yubraj.drools.model.Product;
import com.yubraj.drools.factory.ProcessingFactory;
import org.drools.runtime.StatelessKnowledgeSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Created by ypokhrel on 7/25/2017.
 */
@Component("ProductProcessingFactory")
public class ProductProcessingFactory implements ProcessingFactory<StatelessKnowledgeSession, Product> {

    @Autowired
    private ApplicationContext applicationContext;

    @Override
    public StatelessKnowledgeSession createProcessingObject(Product inputObject) {
        return (StatelessKnowledgeSession)applicationContext.getBean(inputObject.getTypeEnum().getType() + "KSession");
    }
}