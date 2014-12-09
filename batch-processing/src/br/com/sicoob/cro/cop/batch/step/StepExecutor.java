/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sicoob.cro.cop.batch.step;

import br.com.sicoob.cro.cop.batch.configuration.TaskletInjector;
import br.com.sicoob.cro.cop.batch.core.IStepExecutor;
import br.com.sicoob.cro.cop.batch.core.Result;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;

/**
 * Classe responsavel por obter o tasklet do step e coloca-lo no contexto de
 * execucao do {@code executor}.
 *
 * @author Rogerio Alves Rodrigues
 */
public class StepExecutor implements IStepExecutor {

    private final Step step;
    private final ExecutorService service;
    private FutureTask<Result> task;

    /**
     * Constri um StepExecutor.
     *
     * @param step Step a ser executado.
     * @param service Servico de execucao.
     */
    public StepExecutor(Step step, ExecutorService service) {
        this.step = step;
        this.service = service;
    }

    @Override
    public void start() throws Exception {
        new TaskletInjector(this.step).inject();
        this.task = new FutureTask<>(this.step.getTasklet());
        this.service.execute(task);
    }

    @Override
    public FutureTask<Result> getResult() {
        return this.task;
    }

}