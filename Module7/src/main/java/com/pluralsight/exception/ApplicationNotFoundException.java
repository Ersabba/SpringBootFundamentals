package com.pluralsight.exception;

import graphql.ErrorType;
import graphql.GraphQLError;
import graphql.language.SourceLocation;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplicationNotFoundException extends RuntimeException implements GraphQLError {

    // Oggetto definito per dettagliare ulteriormente l'erreore che poi sarà restiutio
    private Map<String, Object> extensions = new HashMap<>();

    public ApplicationNotFoundException(String message, Long invalidApplicationId) {
        super(message);
        extensions.put("invalidApplicationId", invalidApplicationId);
    }

    @Override
    public List<SourceLocation> getLocations() {
        return null;
    }

    // Ridefinizione metodo di default per restituire il messaggo di errore personalizzato
    @Override
    public Map<String, Object> getExtensions() {
        return extensions;
    }

    @Override
    public ErrorType getErrorType() {
        return ErrorType.DataFetchingException;
    }
}
