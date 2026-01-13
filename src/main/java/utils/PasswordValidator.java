package utils;
import java.util.regex.Pattern;

// Each rule gets its own exception
class PasswordTooShortException extends RuntimeException {
    public PasswordTooShortException() {
        super("Password must be at least 8 characters long.");
    }
}

class MissingUppercaseException extends RuntimeException {
    public MissingUppercaseException() {
        super("Password must contain at least one uppercase letter.");
    }

}

class MissingLowercaseException extends RuntimeException {
    public MissingLowercaseException() {
        super("Password must contain at least one lowercase letter.");
    }
}

class MissingSpecialCharacterException extends RuntimeException {
    public MissingSpecialCharacterException() {
        super("Password must contain at least one special character.");
    }
}


public class PasswordValidator {
    private static final Pattern UPPERCASE = Pattern.compile(".*[A-Z].*");
    private static final Pattern LOWERCASE = Pattern.compile(".*[a-z].*");
    private static final Pattern SPECIAL   = Pattern.compile(".*[!@#$%^&*()\\-+=<>?{}\\[\\]~].*");

    public static void validate(String password) {
        if (password == null || password.length() < 8) {
            throw new PasswordTooShortException();
        }
        if (!UPPERCASE.matcher(password).matches()) {
            throw new MissingUppercaseException();
        }
        if (!LOWERCASE.matcher(password).matches()) {
            throw new MissingLowercaseException();
        }
        if (!SPECIAL.matcher(password).matches()) {
            throw new MissingSpecialCharacterException();
        }
    }
}

