package Generate_Password;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Random_password_generator {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789@#$%^&*()-_+=<>?";
    private static final int PASSWORD_LENGTH = 16;

    public static void main(String[] args) {

        String password = generate_password();

        System.out.println("\nGenerated Password Result: " + password);

        System.out.println("\nIs This Password Strong Enough?: " + is_generate_password_strong(password));
    }

    public static String generate_password() {

        Random random = new Random();

        StringBuilder password = new StringBuilder(PASSWORD_LENGTH);

        for(int index = 0; index < PASSWORD_LENGTH; index ++) {

            password.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));

        }

        return password.toString();
    }


    public static boolean is_generate_password_strong(String password) {

        generate_password();

        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&*()-_+=<>?]).{16,}$";

        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(password);

        return matcher.matches();
    }

}
