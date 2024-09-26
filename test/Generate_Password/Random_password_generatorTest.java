package Generate_Password;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Random_password_generatorTest {

    private Random_password_generator generator;

    @BeforeEach
    public void setUp() {
        generator = new Random_password_generator();
    }

    @Test
    public void test_for_password_check() {
        String password = "samsonIbironke21";
    }

    @Test
    public void password_generator_length_to_be_16_in_lengthTest() {
        String password = generator.generate_password();
        assertEquals(16, password.length(),"Password should not be more than 16 characters long");
    }

    @Test
    public void password_generator_length_which_contains_upperCaseTest() {
        String password = generator.generate_password();
        assertEquals(password.matches(".*[A-Z].*"), true, "Password should contain at least minimum of one uppercase letter");
    }

    @Test
    public void password_generator_length_which_contains_lowerCaseTest() {
        String password = generator.generate_password();
        assertEquals(password.matches(".*[a-z].*"), true, "Password should contain at least minimum of one lowercase letter");
    }

    @Test
    public void password_generator_length_which_contains_digitsTest() {
        String password = generator.generate_password();
        assertEquals(password.matches(".*\\d.*"), true, "Password should contain at least minimum of one digit");
    }

    @Test void password_generator_length_which_contains_specialCharactersTest() {
        String password = generator.generate_password();
        assertEquals(password.matches(".*[@#$%^&*()-_+=<>?].*"), true, "Password should contain at least minimum of one special character");
    }

    @Test
    public void password_generator_length_is_strong_without_digit() {
        String password = "Abcdefghijklmnn@";
        boolean password_strength = generator.is_generate_password_strong(password);
        assertEquals(false, password_strength, "Password should contain at least minimum of one digit");
    }

    @Test
    public void password_generator_length_with_than_required_lengthTest() {
        String password = "Abcdefghijklmno12@";
        boolean password_strength = generator.is_generate_password_strong(password);
        assertEquals(true, password_strength, "Password should not be more than 16 characters long");
    }

    @Test
    public void password_generator_to_check_if_password_is_strongTest() {
        String password = generator.generate_password();
        boolean password_strength = generator.is_generate_password_strong(password);
        assertEquals(true, password_strength, "Password should be strong");
    }
}
