package action;

import dao.CustomerDao;
import model.Customer;

public class CustomerAction {

    public void add(Customer customer) {
        CustomerDao customerDao = new CustomerDao();
        customerDao.addCustomer(customer);
    }

    public Customer get(String telphone) {
        CustomerDao customerDao = new CustomerDao();
        Customer customer = null;
        customer = customerDao.queryCustomer(telphone);
        return customer;
    }

    public Customer get(String email, int i) {
        CustomerDao customerDao = new CustomerDao();
        Customer customer = null;
        customer = customerDao.queryCustomer(email, i);
        return customer;
    }

    public void registerByPhone(Customer customer) {
        CustomerDao customerDao = new CustomerDao();
        String telphone = "";
        String name = "";
        String password = "";

        telphone = customer.getTelphone();
        name = customer.getName();
        password = customer.getPassword();
        customerDao.addCustomerByPhone(telphone, password, name);
    }

    public void registerByEmail(Customer customer) {
        CustomerDao customerDao = new CustomerDao();
        customerDao.addCustomerByEmail(customer);
    }

//    public static void main(String[] args){
//        CustomerAction customerAction = new CustomerAction();
//        customerAction.registerByPhone(new Customer("12345","12345","12345","12345",1,1));
//        customerAction.registerByEmail(new Customer("123456","123456","123456","123456",1,1));
//    }
}
