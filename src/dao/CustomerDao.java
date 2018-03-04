package dao;

import util.DBUtil;
import model.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDao {

//    public static void main(String [] args){
//        CustomerDao customerDao = new CustomerDao();
//        customerDao.addCustomerByPhone("12345","12345","12345");
//        customerDao.addCustomerByEmail(new Customer("123456","123456","123456","123456",1,1));
//    }

    public void addCustomer(Customer customer) {
        Connection connection = DBUtil.getConn();
        String sql = "insert into userinfor(telphone,email,password,name,age,money)" +
                "values(?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getTelphone());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.setInt(4, customer.getAge());
            preparedStatement.setFloat(5, customer.getMoney());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCustomerByPhone(String telphone, String password, String name) {
        Connection connection = DBUtil.getConn();
        String sql = "insert into userinfor(telphone,password,name)" +
                "values(?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, telphone);
            preparedStatement.setString(2, password);
            preparedStatement.setString(3, name);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addCustomerByEmail(Customer customer) {
        Connection connection = DBUtil.getConn();
        String sql = "insert into userinfor(telphone,email,password,name)" +
                "values(?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, customer.getTelphone());
            preparedStatement.setString(2, customer.getEmail());
            preparedStatement.setString(3, customer.getPassword());
            preparedStatement.setString(4, customer.getName());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Customer queryCustomer(String telphone) {
        Customer customer = null;
        Connection connection = DBUtil.getConn();
        String sql = "select telphone,email,password,name,age,money from userinfor " +
                "where telphone=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, telphone);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setTelphone(resultSet.getString("telphone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));
                customer.setName(resultSet.getString("name"));
                customer.setAge(resultSet.getInt("age"));
                customer.setMoney(resultSet.getFloat("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }

    public Customer queryCustomer(String email, int i) {
        Customer customer = null;
        Connection connection = DBUtil.getConn();
        String sql = "select telphone,email,password,name,age,money from userinfor " +
                "where email=? ";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                customer = new Customer();
                customer.setTelphone(resultSet.getString("telphone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setPassword(resultSet.getString("password"));
                customer.setName(resultSet.getString("name"));
                customer.setAge(resultSet.getInt("age"));
                customer.setMoney(resultSet.getFloat("money"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customer;
    }
}
