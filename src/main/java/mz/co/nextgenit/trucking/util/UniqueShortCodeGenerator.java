package mz.co.nextgenit.trucking.util;

import java.security.SecureRandom;

public class UniqueShortCodeGenerator {

    private static final String UPPERCASE_CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom random = new SecureRandom();

    public static String generateShortCode(int length) {

        if (length < 6) {
            throw new IllegalArgumentException("Length must be at least 6");
        }

        StringBuilder code = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(UPPERCASE_CHARS.length());
            code.append(UPPERCASE_CHARS.charAt(randomIndex));
        }

        return code.toString();
    }

}
