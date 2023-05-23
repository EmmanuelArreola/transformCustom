package com.cloudgen.n3xgen.transformCustom.stream;

import java.util.function.Function;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.integration.transformer.ExpressionEvaluatingTransformer;
import org.springframework.messaging.Message;

import com.cloudgen.n3xgen.transformCustom.bean.SpelFunctionProperties;

@Configuration
@EnableConfigurationProperties(SpelFunctionProperties.class)
public class SpelFunctionConfiguration {

	@Bean
	public Function<Message<?>, Message<?>> spelFunction(
			ExpressionEvaluatingTransformer expressionEvaluatingTransformer) {

		return message -> expressionEvaluatingTransformer.transform(message);
	}

	@Bean
	public ExpressionEvaluatingTransformer expressionEvaluatingTransformer(
			SpelFunctionProperties spelFunctionProperties) {

		return new ExpressionEvaluatingTransformer(new SpelExpressionParser()
				.parseExpression(spelFunctionProperties.getExpression()));
	}

}