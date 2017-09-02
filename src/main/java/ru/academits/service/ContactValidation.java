package ru.academits.service;

public class ContactValidation {
    private boolean valid;
    private Errors error;

    public boolean isValid() {
        return valid;
    }

    void setValid(boolean valid) {
        this.valid = valid;
    }

    public Errors getError() {
        return error;
    }

    void setError(Errors error) {
        this.error = error;
    }
}
