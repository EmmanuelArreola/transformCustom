package com.cloudgen.n3xgen.transformCustom.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import lombok.Data;

/**
 * Configuration properties for the SpEL function.
 *
 * @author Gary Russell
 * @author Artem Bilan
 */
@ConfigurationProperties("spel.function")
@Data
public class SpelFunctionProperties {

	private static final Expression DEFAULT_EXPRESSION = new SpelExpressionParser().parseExpression("payload");

	/**
	 * A SpEL expression to apply.
	 */
	private String expression = DEFAULT_EXPRESSION.getExpressionString();

}