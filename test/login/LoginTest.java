/**
*Student Name: Masike Rasenyalo
* Student Number: ST10452404
*/
package login;

import login.Login;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class LoginTest {
    @Test
    public void testCheckUserName() {
        Login login = new Login();
        assertTrue(login.checkUserName("kyl_1"));
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }

    @Test
    public void testCheckPasswordComplexity() {
        Login login = new Login();
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
        assertFalse(login.checkPasswordComplexity("password"));
    }

    @Test
    public void testRegisterUser() {
        Login login = new Login();
        assertEquals("Username successfully captured. Password successfully captured.", login.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe"));
        assertEquals("Username is not correctly formatted, please ensure that your username contains an underscore and is no more than 5 characters in length.", login.registerUser("kyle!!!!!!!", "Ch&&sec@ke99!", "John", "Doe"));
        assertEquals("Password is not correctly formatted, please ensure that the password contains at least 8 characters, a capital letter, a number and a special character.", login.registerUser("kyl_1", "password", "John", "Doe"));
    }

    @Test
    public void testLoginUser() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
        assertFalse(login.loginUser("kyl_1", "wrongpassword"));
    }

    @Test
    public void testReturnLoginStatus() {
        Login login = new Login();
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "John", "Doe");
        assertEquals("Welcome Jon Doe, it is great to see you again.", login.returnLoginStatus(login.loginUser("kyl_1", "Ch&&sec@ke99!")));
        assertEquals("Username or password incorrect, please try again", login.returnLoginStatus(login.loginUser("kyl_1", "wrongpassword")));
    }

    private void assertTrue(boolean checkUserName) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    private void assertFalse(boolean checkUserName) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
