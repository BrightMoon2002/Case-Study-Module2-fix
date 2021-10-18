package control;

import login.Customer;
import storage.FileManagerCustomer;

import java.util.List;

public class CustomerManager implements IGeneralManager<Customer> {
    private List<Customer> customerList;
    private FileManagerCustomer fileManagerCustomer;

    public List<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }

    public FileManagerCustomer getFileManagerCustomer() {
        return fileManagerCustomer;
    }

    public void setFileManagerCustomer(FileManagerCustomer fileManagerCustomer) {
        this.fileManagerCustomer = fileManagerCustomer;
    }

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void saveList(Customer customer) {
        customerList.add(customer);
        fileManagerCustomer.writeList(customerList);
    }

    @Override
    public void removeByIndex(int index) {
        customerList.remove(index);
        fileManagerCustomer.writeList(customerList);
    }

    @Override
    public void updateByIndex(int index, Customer customer) {
        customerList.set(index, customer);
        fileManagerCustomer.writeList(customerList);
    }

    @Override
    public Customer searchById(String id) {
        Customer customer = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId().equalsIgnoreCase(id)) {
                customer = customerList.get(i);
                break;
            }
        }

        return customer;
    }

    @Override
    public Customer searchByName(String name) {
        Customer customer = null;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getUsername().equalsIgnoreCase(name)) {
                customer = customerList.get(i);
                break;
            }
        }

        return customer;
    }

    @Override
    public void showAllList() {
        for (Customer c: customerList
        ) {
            System.out.println(c);
        }
    }
}
