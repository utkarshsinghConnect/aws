package com.example.demo.handler;

import com.amazonaws.serverless.exceptions.ContainerInitializationException;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyRequest;
import com.amazonaws.serverless.proxy.internal.model.AwsProxyResponse;
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.example.demo.SpringLambdaApplication;

/**
 * This is Lambda handler which is going to receieve the event
 * 
 * @author utkarshsingh
 *
 */
public class LambdaHandler implements RequestHandler<AwsProxyRequest, AwsProxyResponse> {
	private static SpringBootLambdaContainerHandler<AwsProxyRequest, AwsProxyResponse> handler;

	static {
		try {
			handler = SpringBootLambdaContainerHandler.getAwsProxyHandler(SpringLambdaApplication.class);
		} catch (ContainerInitializationException e) {
			// if we fail here. We re-throw the exception to force another cold start
			e.printStackTrace();
			throw new RuntimeException("Could not initialize Spring Boot application", e);
		}
	}

	@Override
	public AwsProxyResponse handleRequest(AwsProxyRequest awsProxyRequest, Context context) {
		return handler.proxy(awsProxyRequest, context);
	}

}
