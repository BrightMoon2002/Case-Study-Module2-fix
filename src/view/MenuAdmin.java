package view;

import control.*;
import login.Account;
import login.AccountFactory;
import login.AccountType;
import model.Bill;
import model.idol.Idol;
import model.idol.IdolFactory;
import model.idol.IdolType;
import model.room.Room;
import model.room.RoomFactory;
import model.room.RoomType;
import storage.*;

import java.time.LocalTime;
import java.util.List;
import java.util.Scanner;

public class MenuAdmin {
    public MenuAdmin() {
    }
    private static MenuLogin menuLogin = new MenuLogin();

    public static void menuAdmin() {
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
            System.out.println("Menu of Admin:");
            System.out.println("1. Change password:");
            System.out.println("2. Change information of account");
            System.out.println("3. add new Idol");
            System.out.println("4. add new Room");
            System.out.println("5. display list idol");
            System.out.println("6. display list room");
            System.out.println("7. display list Bill");
            System.out.println("8. Check Bill");
            System.out.println("9. remove User By Id");
            System.out.println("10. remove Idol by Id");
            System.out.println("11. Remove Room by Id");
            System.out.println("12. Creat new Member");
            System.out.println("0. back");
            Scanner inputChoice = new Scanner(System.in);
            int choice = inputChoice.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter the password you want to change:");
                    Scanner inputPassword = new Scanner(System.in);
                    String password = inputPassword.nextLine();
                    userManager.changePassword(accountList.indexOf(account), password);
                    break;
                case 2:
                    userManager.updateByIndex(accountList.indexOf(account), creatNewAccount());
                    break;
                case 3:
                    System.out.println("Enter the type of Idol (A, B or C):");
                    Scanner inputType = new Scanner(System.in);
                    String type = inputType.nextLine();
                    System.out.println("Enter the stage name of idol:");
                    Scanner inputStageName = new Scanner(System.in);
                    String stageName = inputStageName.nextLine();
                    System.out.println("Enter the id of idol:");
                    Scanner inputId = new Scanner(System.in);
                    String id = inputId.nextLine();
                    System.out.println("Enter the dob of idol:");
                    Scanner inputDOB = new Scanner(System.in);
                    String dOB = inputDOB.nextLine();
                    System.out.println("Enter the idol height");
                    Scanner inputHeight = new Scanner(System.in);
                    double height = inputHeight.nextDouble();
                    System.out.println("Enter the Body Measurements");
                    Scanner inputBody = new Scanner(System.in);
                    String body = inputBody.nextLine();
                    Idol idol = new Idol();
                    if (type.equals("A")) {
                        idol = IdolFactory.getIdol(IdolType.IDOLA, stageName, dOB, height, body, id);
                        idolManager.saveList(idol);
                    } else if (type.equals("B")) {
                        idol = IdolFactory.getIdol(IdolType.IDOLB, stageName, dOB, height, body, id);
                        idolManager.saveList(idol);
                    } else if (type.equals("C")) {
                        idol = IdolFactory.getIdol(IdolType.IDOLC, stageName, dOB, height, body, id);
                        idolManager.saveList(idol);
                    } else {
                        System.out.println("No type of Idol is support");
                    }

                    break;
                case 4:
                    System.out.println("Enter the type of Room(VIP, DELUXE, KING");
                    Scanner inputTypeRoom = new Scanner(System.in);
                    String typeRoom = inputTypeRoom.nextLine();
                    System.out.println("Enter the code of Room");
                    Scanner inputCode = new Scanner(System.in);
                    String code = inputCode.nextLine();
                    Room room = new Room();
                    switch (typeRoom) {
                        case "VIP":
                            room = RoomFactory.getRoom(RoomType.VIPROOM, code);
                            roomManager.saveList(room);

                            break;
                        case "DELUXE":
                            room = RoomFactory.getRoom(RoomType.DELUXERROOM, code);
                            roomManager.saveList(room);
                            break;
                        case "KING":
                            room = RoomFactory.getRoom(RoomType.KINGROOM, code);
                            roomManager.saveList(room);
                            break;
                        default:
                            System.out.println("NO TYPE ROOM LIKE THAT");
                            break;
                    }
                    break;
                case 5:
                    idolManager.showAllList();
                    break;
                case 6:
                    roomManager.showAllList();
                    break;
                case 7:
                    billManager.showAllList();
                case 8:
                    System.out.println("Enter the id of Customer you want to check bill to pay today:");
                    Scanner inputIdOfCustomer = new Scanner(System.in);
                    String idOfCustomer = inputIdOfCustomer.nextLine();
                    Bill bill = billManager.searchByName(userManager.searchById(idOfCustomer).getUsername());
                if (bill != null) {
                    bill.setCheckout(LocalTime.now());
                    System.out.println("Enter the code of Bill");
                    Scanner inputCode1 = new Scanner(System.in);
                    String code1 = inputCode1.nextLine();
                    bill.setCode(code1);
                    billManager.updateByIndex(billList.indexOf(bill), bill);
                    System.out.println("the money  need to pay is: " + billManager.getBillList().get(billManager.getBillList().indexOf(bill)).getMoneyToPay());
                    idolManager.getIdolList().get(idolList.indexOf(bill.getIdol())).setStatus(false);
                    roomManager.getRoomList().get(roomList.indexOf(bill.getRoom())).setStatus(false);

                }
                    break;
                case 9:
                case 10:
                case 11:
                case 12:
                case 0:
                    menuLogin.loginMenu();

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

