/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicoob.cro.cop.batch.configuration.annotation;

import com.google.inject.BindingAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author rogerioalves21
 */
@BindingAnnotation
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface FactoryStepExecutor {
    
}