package object;

public class CreateOrder {
    private String firstName;
    private String lastName;
    private String address;
    private String metroStation;
    private String phone;
    private int rentTime;
    private String deliveryDate;
    private String comment;
    private String[] color;

    //конструктор с параметрами
    public CreateOrder(String firstName, String lastName, String address, String metroStation, String phone, int rentTime, String deliveryDate, String comment, String[] color){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.metroStation = metroStation;
        this.phone = phone;
        this.rentTime = rentTime;
        this.deliveryDate = deliveryDate;
        this.comment = comment;
        this.color = color;
    }
    //конструктор без параметров
    public CreateOrder(){

    }
    //геттер для поля имя
    public String getFirstName() {
        return firstName;
    }
    //сеттер для поля имя
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    //геттер для поля фамилия
    public String getLastName() {
        return lastName;
    }
    //сеттер для поля фамилия
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    //геттер для поля адрес
    public String getAddress() {
        return address;
    }
    //сеттер для поля адрес заказчика
    public void setAddress(String address) {
        this.address = address;
    }
    //геттер для поля ближайшая станция
    public String getMetroStation() {
        return metroStation;
    }
    //сеттер для поля ближайшая станция
    public void setMetroStation(String metroStation) {
        this.metroStation = metroStation;
    }
    //геттер для поля телефон
    public String getPhone() {
        return phone;
    }
    //сеттер для поля телефон
    public void setPhone(String phone) {
        this.phone = phone;
    }
    //геттер для поля количества дней
    public int getRentTime() {
        return rentTime;
    }
    //сеттер для поля количество дней
    public void setRentTime(int rentTime) {
        this.rentTime = rentTime;
    }
    //геттер для поля дата доставки
    public String getDeliveryDate() {
        return deliveryDate;
    }
    //сеттер для поля дата доставки
    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
    //геттер для поля комментарий
    public String getComment() {
        return comment;
    }
    //сеттер для поля комментарий
    public void setComment(String comment) {
        this.comment = comment;
    }
    //геттер для поля предпочитаемый цвет
    public String[] getColor() {
        return color;
    }
    //сеттер для поля предпочитаемый цвет
    public void setColor(String[] color) {
        this.color = color;
    }
}

