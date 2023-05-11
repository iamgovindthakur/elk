package com.iamgkt.elk.correlation;

public class CorrelationIdHolder {
    private static final ThreadLocal<String> correlationIdHolder = new ThreadLocal<>();

    public static String getCorrelationId() {
        return correlationIdHolder.get();
    }

    public static void setCorrelationId(String correlationId) {
        correlationIdHolder.set(correlationId);
    }

    public static void clearCorrelationId() {
        correlationIdHolder.remove();
    }
}
