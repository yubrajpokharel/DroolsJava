package com.yubraj.drools.service.nondrools;

import com.yubraj.drools.model.Product;
import com.yubraj.drools.enums.TypeEnum;
import com.yubraj.drools.service.Processor;
import com.yubraj.drools.utils.SomeUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.google.common.base.Preconditions.checkArgument;
import static java.lang.String.format;

/**
 * Created by ypokhrel on 7/25/2017.
 */
public class MedicalProductProcessingService implements Processor<Product> {

    private static final Logger LOGGER = LoggerFactory.getLogger(MedicalProductProcessingService.class);

    @Override
    public void process(Product input) {
        checkArgument(TypeEnum.MEDICAL.equals(input.getTypeEnum()), "This processing service works only for medical devices");
        checkArgument(!SomeUtil.replaceAWithB(input.getProductName()).equals(input.getProductName()), "The input has already been processed");
        LOGGER.debug("Running processing for Medical Product");
        input.setProductName(SomeUtil.replaceAWithB(input.getProductName()));
        LOGGER.debug(format("MEDICAL rule applied without Drools, product name is now equal to [%s]", input.getProductName()));
    }
}
