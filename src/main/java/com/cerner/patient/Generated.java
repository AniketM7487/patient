package com.cerner.patient;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * The Interface Generated used for exclude package and class from code coverage.
 * @author Aniket
 * @version 0.1
 * @since 2023
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE,ElementType.PACKAGE,ElementType.METHOD, ElementType.CONSTRUCTOR})
public @interface Generated {
}
