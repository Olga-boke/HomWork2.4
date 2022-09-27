import exception.WrongLoginException;
import exception.WrongPasswordException;

public class Main {
    public static void main(String[] args) {
        String login = "uuuuuuu";
        String password = "hhjjjj8999";
        String confirmPassword = "hhjjjj8999";
        System.out.println(acceptsThreeParameters(login, password, confirmPassword));

    }
    public static boolean acceptsThreeParameters(String login, String password, String confirmPassword) {
        try {
            checkValidationCharacter(login);
            checkValidationCharacter(password);
            checkLengthLogin(login);
            checkLengthPassword(password);
            checkingPasswordMatch(password, confirmPassword);
        } catch (WrongLoginException  | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
    public static boolean checkValidationCharacter(String checkWord){
        if(checkWord == null){
            System.out.println("Одно из значений отсутствует");
            return false;
        }
        if(checkWord.matches("\\w+")) {
            return true;
        }
        System.out.println("Недопустимые символы в слове - %s" + checkWord );
        return false;
    }
    public static boolean checkLengthLogin(String login) throws WrongLoginException{
        if(login.length()>20){
            throw new WrongLoginException("слишком длинный логин");
        }
        return true;
    }
    public static boolean checkLengthPassword(String login){
        if(login.length()>19){
            System.out.println("слишком длинный пароль");
            return false;
        }
        return true;
    }
    public static boolean checkingPasswordMatch(String password, String confirmPassword) throws WrongPasswordException{
        if (password.equals(confirmPassword))
            return true;
        throw new WrongPasswordException("Пароли не совпадают");
    }
}