package com.krishna.banda.instrumentation;

import graphql.ExecutionResult;
import graphql.ExecutionResultImpl;
import graphql.execution.instrumentation.Instrumentation;
import graphql.execution.instrumentation.InstrumentationContext;
import graphql.execution.instrumentation.InstrumentationState;
import graphql.execution.instrumentation.SimpleInstrumentationContext;
import graphql.execution.instrumentation.parameters.InstrumentationExecutionParameters;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
public class GraphInstrumentation implements Instrumentation {
    @Autowired
    HttpServletRequest httpServletRequest;

    public InstrumentationContext<ExecutionResult> beginExecution(InstrumentationExecutionParameters parameters, InstrumentationState state) {
        log.info("Execution Id:"+parameters.getExecutionInput().getExecutionId().toString());

        return new SimpleInstrumentationContext<ExecutionResult>() {
            public void onCompleted(ExecutionResult result, Throwable t){
                log.info("Log statement if any");
            }
        };

    }
    public CompletableFuture<ExecutionResult> instrumentExecutionResult(ExecutionResult executionResult, InstrumentationExecutionParameters parameters, InstrumentationState state) {
        CompletableFuture<ExecutionResult> executionResultCompletableFuture = CompletableFuture.completedFuture(executionResult);
        String executionId = parameters.getExecutionInput().getExecutionId().toString();
        Map<Object,Object> customParamtersMap = new HashMap<>();
        customParamtersMap.put("executionId",executionId);
        return CompletableFuture.completedFuture(
                new ExecutionResultImpl(executionResult.getData(), executionResult.getErrors(), customParamtersMap)
        );
    }

}
