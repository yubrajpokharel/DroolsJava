package com.yubraj.drools.service.nondrools;

import com.yubraj.drools.model.Product;
import com.yubraj.drools.enums.TypeEnum;
import com.yubraj.drools.service.Processor;
import com.yubraj.drools.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * Created by ypokhrel on 7/25/2017.
 */
@Component("NoRulesProductServiceImpl")
public class NoRulesProductServiceImpl implements ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NoRulesProductServiceImpl.class);

    @Autowired
    @Qualifier("ProductProcessingService")
    private Processor<List<Product>> productProcessingService;

    @Override
    public void runProductLogic() {
        LOGGER.debug("Running product logic without Drools");
        Product medicalProduct = new Product(TypeEnum.MEDICAL);
        Product electronicProduct = new Product(TypeEnum.ELECTRONIC);
        LOGGER.debug("Running rules for products...");
        productProcessingService.process(newArrayList(medicalProduct, electronicProduct));
        LOGGER.debug("...finished running products.");
    }
}