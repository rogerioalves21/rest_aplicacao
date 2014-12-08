/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicoob.cro.cop.batch.configuration;

/**
 * Define o comportamento de uma classe injector.
 *
 * @author Rogerio Alves Rodrigues
 */
public interface Injector {

    /**
     * Injeta as dependencias necessarias.
     *
     * @throws IllegalArgumentException para argumento ilegal.
     * @throws IllegalAccessException para acesso ilegal.
     */
    void inject() throws IllegalArgumentException, IllegalAccessException;

}
