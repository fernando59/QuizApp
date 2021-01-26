package org.fundacionjala.app.quizz.model.validator;

public enum ValidatorType {
    REQUIRED(1, "Required", new RequiredValidator()),
    DATE(2, "Date", new DateValidator()),
    MIN(3, "Min", new MinValidator()),
    MAX(4,"Max",new onlyUppercase()),
    MAX_LENGTH(5,"Max Length",new onlyUppercase()),
    UPPERCASE(6,"Uppercase",new onlyUppercase()),
    MIN_LENGTH(7, "Min Length", new MinLengthValidator());

    private final int code;
    private final String displayName;
    private final Validator<?, ?> validator;

    private ValidatorType(int code, String displayName, Validator<?, ?> validator) {
        this.code = code;
        this.displayName = displayName;
        this.validator = validator;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return displayName;
    }

    public Validator<?, ?> getValidator() {
        return validator;
    }

    public static ValidatorType getByCode(int option) {
        for (ValidatorType validator : ValidatorType.values()) {
            if (validator.getCode() == option) {
                return validator;
            }
        }

        return null;
    }
}
