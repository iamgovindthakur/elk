package com.iamgkt.elk.interceptor;

import com.iamgkt.elk.correlation.CorrelationIdHolder;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

public class CorrelationIdInterceptor implements HandlerInterceptor {

    private static final Logger logger = LoggerFactory.getLogger(CorrelationIdInterceptor.class);
    private static final String CORRELATION_ID_HEADER = "X-Correlation-ID";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String correlationId = request.getHeader(CORRELATION_ID_HEADER);
        if (correlationId == null || correlationId.isEmpty()) {
            correlationId = generateCorrelationId();
            logger.info("Generated Correlation ID: {}", correlationId);
        }
        CorrelationIdHolder.setCorrelationId(correlationId); // Set correlation ID using CorrelationIdHolder
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        CorrelationIdHolder.clearCorrelationId(); // Clear correlation ID from CorrelationIdHolder
    }

    private String generateCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
