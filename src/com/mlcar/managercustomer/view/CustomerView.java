package com.mlcar.managercustomer.view;

import com.mlcar.managercustomer.bean.Customer;
import com.mlcar.managercustomer.service.CustomerList;
import utils.CMUtility;

import java.awt.*;
import java.util.Scanner;

/**
 * @Description 视图层, 显示数据
 * @auther Admin
 * @date 2020/5/23 9:08
 */
public class CustomerView {

    private CustomerList customerList = new CustomerList(10);

    public CustomerView() {
        Customer customer = new Customer("lili", '女', 12, "197979", "131231@qq.com");
        customerList.addCustomer(customer);
    }
    /**
     * @Description 显示用户界面
     *  * @param
     * @return {@link }
     * @throws
     * @auther Admin
     * @date 2020/5/23 11:08
     */
    public void enterMainMenu() {
        boolean isFlag = true;
        while(isFlag) {
            System.out.println("\n-------------------客户操作管理系统-------------------");
            System.out.println("                     1 添加客户");
            System.out.println("                     2 修改客户");
            System.out.println("                     3 删除客户");
            System.out.println("                     4 客户列表");
            System.out.println("                     5 退出");
            System.out.print("          请选择(1-5):");
            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomer();
                    break;
                case '5':
                    System.out.println("确认是否退出(Y/N)");
                    char iscomfirm = CMUtility.readConfirmSelection();
                    if(iscomfirm == 'Y'){
                        System.out.println("退出");
                        isFlag = false;
                    }

            }
        }
    }

    /**
     * @Description 添加客户的操作
     *  * @param
     * @return {@link }
     * @throws
     * @auther Admin
     * @date 2020/5/23 11:08
     */
    private void addNewCustomer() {
        System.out.println("添加客户的操作");
        Customer customer = new Customer();
        customer.setName("zhangsan");
        customer.setGender('男');
        customer.setAge(12);
        customer.setPhone("78652192");
        customer.setEmail("123123@qq.com");
        customerList.addCustomer(customer);
    }
    /**
     * @Description 修改客户的操作
     *  * @param
     * @return {@link }
     * @throws
     * @auther Admin
     * @date 2020/5/23 11:08
     */
    private void modifyCustomer() {
        if(customerList.getTotal() == 0){
            System.out.println("没有记录!");
        }
        Customer[] custs = customerList.getAllCustomers();
        System.out.println("请输入修改信息编号:");
        Scanner scan = new Scanner(System.in);
        int index = scan.nextInt();
        System.out.println(custs[index].getName()+":");
        String name = scan.nextLine();


    }
    private void deleteCustomer() {
        System.out.println("删除客户的操作");
    }
    /**
     * @Description 展示客户信息列表
     *  * @param
     * @return {@link }
     * @throws
     * @auther Admin
     * @date 2020/5/23 11:08
     */
    private void listAllCustomer() {
        System.out.println("-------------------客户列表-------------------");

        if(customerList.getTotal() == 0){
            System.out.println("没有记录!");
        }else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for (int i = 0; i < custs.length; i++) {
                Customer cust = custs[i];
                System.out.println(i+1 + "\t" + cust.getName() + "\t" + cust.getGender() + "\t" + cust.getAge() + "\t" + cust.getPhone() + "\t" + cust.getEmail());

            }
        }

        System.out.println("-------------------客户列表完成-------------------");
    }

    public static void main(String[] args) {
        CustomerView view  = new CustomerView();
        view.enterMainMenu();

    }

}
