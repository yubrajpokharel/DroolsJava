package com.yubraj.drools.service.drools;

import com.yubraj.drools.model.Product;
import com.yubraj.drools.enums.TypeEnum;
import com.yubraj.drools.factory.ProcessingFactory;
import com.yubraj.drools.service.ProductService;
import org.drools.runtime.StatelessKnowledgeSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by ypokhrel on 7/25/2017.
 */
@Component("ProductServiceImpl")
public class ProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    @Qualifier("ProductProcessingFactory")
    ProcessingFactory<StatelessKnowledgeSession, Product> processingFactory;

    @Override
    public void runProductLogic() {
        LOGGER.debug("Running product logic");
        Product medicalProduct = new Product(TypeEnum.MEDICAL);
        Product electronicProduct = new Product(TypeEnum.ELECTRONIC);
        StatelessKnowledgeSession statelessKnowledgeSession = processingFactory.createProcessingObject(medicalProduct);
        LOGGER.debug("Running rules for products...");
        statelessKnowledgeSession.execute(newArrayList(medicalProduct, electronicProduct));
        LOGGER.debug("...finished running products.");
    }
}