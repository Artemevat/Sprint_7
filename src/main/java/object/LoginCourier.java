package object;

public class LoginCourier {
    private String login;
    private String password;
    private Integer id;

    //конструктор со всеми параметрами
    public LoginCourier(String login, String password){
        this.login = login;
        this.password = password;
    }

    //конструктор без параметров
    public LoginCourier(){
    }

    //геттер для поля login
    public String getLogin() {
        return login;
    }
    //сеттер для поля login
    public void setLogin(String login) {
        this.login = login;
    }
    //геттер для поля password
    public String getPassword() {
        return password;
    }
    //сеттер для поля password
    public void setPassword(String password) {
        this.password = password;
    }
    //геттер для поля id курьера
    public Integer getId(){
        return id;
    }
    //сеттер для поля id курьера
    public void setId(Integer id){
        this.id = id;
    }
}
