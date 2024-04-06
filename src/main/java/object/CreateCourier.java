package object;

public class CreateCourier {
    private String login;
    private String password;
    private String firstName;

    //конструктор со всеми параметрами
    public CreateCourier(String login, String password, String firstName){
        this.login = login;
        this.password = password;
        this.firstName = firstName;
    }
    //конструктор без параметров
    public CreateCourier(){
    }
    //геттер для поля login
    public String getLogin() {
        return login;
    }
    //сеттер для поля логин
    public void setLogin(String login) {
        this.login = login;
    }
    //геттер для поля пароль
    public String getPassword() {
        return password;
    }
    //сеттер для поля пароль
    public void setPassword(String password) {
        this.password = password;
    }
    //геттер для поля имя курьера
    public String getFirstName() {
        return firstName;
    }
    //сеттер для поля имя курьера
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
