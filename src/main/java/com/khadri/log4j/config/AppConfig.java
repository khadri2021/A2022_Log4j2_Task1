package com.khadri.log4j.config;

import com.khadri.log4j.model.StudentRequest;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
public class AppConfig {

    @Bean
    public ExecutorService executorService() {
        return Executors.newFixedThreadPool(10);
    }

    @Bean
    public StudentRequest orderRequest() {
        return new StudentRequest();
    }

    @Bean(name = "expressionParser")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public ExpressionParser expressionParser() {
        return new SpelExpressionParser();
    }

    @Bean(name = "evaluationContext")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public StandardEvaluationContext standardEvaluationContext(ApplicationContext applicationContext) {
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext();
        standardEvaluationContext.setBeanResolver(new BeanFactoryResolver(applicationContext));
        return standardEvaluationContext;
    }

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
