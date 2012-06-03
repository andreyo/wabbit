package com.wabbit.selenium.auto;

import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

/**
 * User: andrey.osipov
 */
public class AutoSearchRequestTest {
    private static final Logger LOG = Logger.getLogger(AutoSearchRequestTest.class);


    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }


    @Test
    public void testManufacturerIsNull() {

        AutoSearchRequest request = new AutoSearchRequest();
        request.setMake("234532 dfgdfg dfg");

        Set<ConstraintViolation<AutoSearchRequest>> constraintViolations = validator.validate(request);

        for (ConstraintViolation<AutoSearchRequest> constraintViolation : constraintViolations) {
            LOG.info(constraintViolation);
        }
    }
}