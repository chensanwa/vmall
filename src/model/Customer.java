package model;

//用户基本信息
public class Customer {

    private String telphone;    //电话号码
    private String email;       //电子邮箱
    private String password;    //密码
    private String name;        //姓名
    private int age;            //年龄
    private float money;        //钱包金额

    public Customer() {

    }

    public Customer(String telphone, String email, String password, String name, int age, int money) {
        this.email = email;
        this.telphone = telphone;
        this.password = password;
        this.name = name;
        this.age = age;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMoney() {

        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public int getAge() {

        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelphone(String telphone) {
        this.telphone = telphone;
    }

    public String getTelphone() {

        return telphone;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getPassword() {

        return password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "telphone='" + telphone + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", money=" + money +
                '}';
    }
}
