package com.yubraj.drools.factory.nondrools;

import com.google.common.collect.ImmutableMap;
import com.yubraj.drools.model.Product;
import com.yubraj.drools.enums.TypeEnum;
import com.yubraj.drools.factory.ProcessingFactory;
import com.yubraj.drools.service.Processor;
import com.yubraj.drools.service.nondrools.ElectronicProductProcessingService;
import com.yubraj.drools.service.nondrools.MedicalProductProcessingService;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by ypokhrel on 7/25/2017.
 */
@Component("NoRulesProcessingFactory")
public class NoRulesProcessingFactory  implements ProcessingFactory<Processor, Product> {

    private static final Map<TypeEnum, Processor> PROCESSOR_MAP = new ImmutableMap.Builder<TypeEnum, Processor>().
            put(TypeEnum.MEDICAL, new MedicalProductProcessingService()).
            put(TypeEnum.ELECTRONIC, new ElectronicProductProcessingService()).
            build();

    /**
     * By using the map we don't have any ifs
     * @param inputObject
     * @return
     */
    @Override
    public Processor createProcessingObject(Product inputObject) {
        return PROCESSOR_MAP.get(inputObject.getTypeEnum());
    }
}
