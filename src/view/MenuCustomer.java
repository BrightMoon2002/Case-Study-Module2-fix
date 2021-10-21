package view;

import control.*;
import login.Account;
import login.AccountFactory;
import login.AccountType;
import model.pay.Bill;
import model.idol.Idol;
import model.room.Room;
import storage.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class MenuCustomer {
    private static MenuLogin menuLogin = new MenuLogin();


    public MenuCustomer() {
    }


    public static void menuCustomer() {
        IdolManager idolManager = new IdolManager();
        RoomManager roomManager = new RoomManager();
        CustomerManager customerManager = new CustomerManager();
        BillManager billManager = new BillManager();
        AccountManager userManager = new AccountManager();

        LoginManager loginManager = new LoginManager();
        FileManagerLogin fileManagerLogin = FileManagerLogin.getInstance();
        loginManager.setFileManagerLogin(fileManagerLogin);
        List<Account> loginList = fileManagerLogin.readList();
        loginManager.setAccountList(loginList);

        FileManagerBill fileManagerBill = FileManagerBill.getInstance();
        billManager.setFileManagerBill(fileManagerBill);
        List<Bill> billList = fileManagerBill.readList();
        billManager.setBillList(billList);

        FileManagerAccount fileManagerUser = FileManagerAccount.getInstance();
        userManager.setFileManagerUser(fileManagerUser);
        List<Account> accountList = fileManagerUser.readList();
        userManager.setUserList(accountList);


        FileManagerIdol fileManagerIdol = FileManagerIdol.getInstance();
        idolManager.setFileManagerIdol(fileManagerIdol);
        List<Idol> idolList = fileManagerIdol.readList();
        idolManager.setIdolList(idolList);

        FileManagerRoom fileManagerRoom = FileManagerRoom.getInstance();
        roomManager.setFileManagerRoom(fileManagerRoom);
        List<Room> roomList = fileManagerRoom.readList();
        roomManager.setRoomList(roomList);

        while (true) {
            Account account = userManager.searchByName(loginManager.getAccountList().get(0).getUsername());
            System.out.println("--------Menu of Customer:-----------");
            System.out.println("1. Change password:");
            System.out.println("2. Change information of account");
            System.out.println("3. display list idol");
            System.out.println("4. display list room");
            System.out.println("5. pick idol and room");
            System.out.println("0 . exit");
            Scanner inputChoice = new Scanner(System.in);
            int choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the password you want to change:");
                    Scanner inputPassword = new Scanner(System.in);
                    String password = inputPassword.nextLine();
                    userManager.changePassword(accountList.indexOf(account),password);
                    break;
                case 2:
                    userManager.updateByIndex(accountList.indexOf(account), creatNewAccount());
                    break;
                case 3:
                    idolManager.showAllList();
                    break;
                case 4:
                    roomManager.showAllList();
                    break;
                case 5:
                    System.out.println("Enter the id of idol you want her to serve you");
                    Scanner inputId = new Scanner(System.in);
                    String id = inputId.nextLine();
                    Idol idol = idolManager.searchById(id);
                    System.out.println("Enter the id of room you want to use");
                    Scanner inputIdRoom = new Scanner(System.in);
                    String idRoom = inputIdRoom.nextLine();
                    Room room = roomManager.searchById(idRoom);
                    if (!idol.isStatus() && !room.isStatus()) {
                        Bill bill = new Bill(idol, room, account, LocalTime.now());
                        idolManager.getIdolList().get(idolManager.getIdolList().indexOf(idol)).setStatus(true);
                        roomManager.getRoomList().get(roomList.indexOf(room)).setStatus(true);
                        billManager.saveList(bill);
                        idolManager.updateByIndex(idolList.indexOf(idol), idol);
                        roomManager.updateByIndex(roomList.indexOf(room), room);
                        billManager.showAllList();
                    } else {
                        System.out.println("room or idol is busy, please choose again");
                    }
                    break;
                case 0:
                    menuLogin.loginMenu();
                    break;
            }
        }


    }

    private static Account creatNewAccount() {
        System.out.println("Enter the new username: ");
        Scanner inputNewUserName = new Scanner(System.in);
        String userName = inputNewUserName.nextLine();
        System.out.println("Enter the new password: ");
        Scanner inputNewPassword = new Scanner(System.in);
        String newPassword = inputNewPassword.nextLine();
        System.out.println("Enter the new id: ");
        Scanner inputNewId = new Scanner(System.in);
        String newId = inputNewId.nextLine();
        System.out.println("Enter the new fullName");
        Scanner inputNewName = new Scanner(System.in);
        String fullName = inputNewName.nextLine();
        Account newUser = AccountFactory.getAccount(AccountType.CUSTOMER, userName, newPassword, newId, fullName);
        return newUser;
    }
}
