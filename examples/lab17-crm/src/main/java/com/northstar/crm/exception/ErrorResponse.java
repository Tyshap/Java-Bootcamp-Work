package com.northstar.crm.exception;

import java.time.Instant;
import java.util.Map;
import java.util.List;
import java.util.Objects;

public class ErrorResponse {
    // TODO: fields timestamp, status, error, message, correlationId, errors (always present, maybe empty)
    private String timestamp;
    private int status;
    private String error;
    private String message;
    private String correlationId;
    private List<FieldError> errors;
    // TODO: constructor + getters

    public ErrorResponse(
            String timestamp,
            int status,
            String error,
            String message,
            String correlationId,
            List<FieldError> errors
    ) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.correlationId = correlationId;
        this.errors = errors;
    }

    public String getTimestamp() {
        return timestamp;
    }
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }
    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }

    public String getCorrelationId() {
        return correlationId;
    }
    public void setCorrelationId(String correlationId) {
        this.correlationId = correlationId;
    }

    public List<FieldError> getErrors() {
        return errors;
    }

    public void setErrors(List<FieldError> errors) {
        this.errors = errors;
    }

    public record FieldError(String field, String message) {}
    // TODO: toJson() that always includes errors:{}

    public String toJson() {
        StringBuilder json = new StringBuilder();
        json.append("{");
        json.append("\"timestamp\":\"").append(escapeJson(timestamp)).append("\",");
        json.append("\"status\":").append(status).append(",");
        json.append("\"error\":\"").append(escapeJson(error)).append("\",");
        json.append("\"message\":\"").append(escapeJson(message)).append("\",");
        json.append("\"correlationId\":\"").append(escapeJson(correlationId)).append("\",");
        json.append("\"errors\":[");
        
        if (!errors.equals(null)) {
            for (int i = 0; i < errors.size(); i++) {
                if (i > 0) json.append(",");
                FieldError fe = errors.get(i);
                json.append("{");
                json.append("\"field\":\"").append(escapeJson(fe.field())).append("\",");
                json.append("\"message\":\"").append(escapeJson(fe.message())).append("\"");
                json.append("}");
            }
        }
        
        json.append("]");
        json.append("}");
        return json.toString();
    }

    private String escapeJson(String value) {
        if (value.equals(null)) return "";
        return value.replace("\\", "\\\\")
                   .replace("\"", "\\\"")
                   .replace("\n", "\\n")
                   .replace("\r", "\\r")
                   .replace("\t", "\\t");
    }
}