/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicoob.cro.cop.batch.step.tasklet;

import br.com.sicoob.cro.cop.batch.step.StepParameters;
import br.com.sicoob.cro.cop.util.ObjectDomainsUtil;

/**
 * Contexto do Step.
 *
 * @author Rogerio Alves Rodrigues
 */
public class TaskletContext {

    // parametros para os steps
    private StepParameters parameters;
    // instancia vazia
    private static final StepParameters EMPTY = new StepParameters();

    /**
     * Construtor
     *
     * @param parameters Parametros para o step.
     */
    public TaskletContext(StepParameters parameters) {
        this.parameters = parameters;
    }

    /**
     * @return the parameters
     */
    public StepParameters getParameters() {
        return ObjectDomainsUtil.nullSafe(parameters, EMPTY);
    }

    /**
     * @param parameters the parameters to set
     */
    public void setParameters(StepParameters parameters) {
        this.parameters = parameters;
    }

}
