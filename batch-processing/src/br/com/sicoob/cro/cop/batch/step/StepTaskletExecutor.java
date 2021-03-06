/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicoob.cro.cop.batch.step;

import br.com.sicoob.cro.cop.batch.service.BatchExecutorService;
import br.com.sicoob.cro.cop.batch.configuration.TaskletInjector;
import br.com.sicoob.cro.cop.batch.core.IStepExecutor;
import br.com.sicoob.cro.cop.batch.step.tasklet.Tasklet;
import br.com.sicoob.cro.cop.batch.step.tasklet.TaskletExecutor;
import br.com.sicoob.cro.cop.util.BatchKeys;
import java.util.concurrent.FutureTask;
import org.apache.commons.beanutils.ConstructorUtils;
import org.apache.commons.beanutils.PropertyUtils;

/**
 * Classe responsavel por obter o tasklet do step e coloca-lo no contexto de
 * execucao do {@code executor}.
 *
 * @author Rogerio Alves Rodrigues
 */
public class StepTaskletExecutor implements IStepExecutor {

    private final Step step;
    private final BatchExecutorService service;
    private FutureTask<Boolean> task;

    /**
     * Constri um StepExecutor.
     *
     * @param step Step a ser executado.
     * @param service Servico de execucao.
     */
    public StepTaskletExecutor(Step step, BatchExecutorService service) {
        this.step = step;
        this.service = service;
    }

    public void start() throws Exception {
        ConstructorUtils.invokeConstructor(TaskletInjector.class, this.step).inject();
        TaskletExecutor taskletExecutor = new TaskletExecutor(this.step);
        this.task = new FutureTask(taskletExecutor);
        this.service.executeTask(task);
    }

    public FutureTask<Boolean> getResult() {
        return this.task;
    }

}
