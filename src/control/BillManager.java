package control;

import model.Bill;
import storage.FileManagerBill;

import java.util.List;

public class BillManager implements IGeneralManager<Bill> {
    private List<Bill> billList;
    private FileManagerBill fileManagerBill;

    public List<Bill> getBillList() {
        return billList;
    }

    public void setBillList(List<Bill> billList) {
        this.billList = billList;
    }

    public FileManagerBill getFileManagerBill() {
        return fileManagerBill;
    }

    public void setFileManagerBill(FileManagerBill fileManagerBill) {
        this.fileManagerBill = fileManagerBill;
    }

    @Override
    public List<Bill> findAll() {
        return billList;
    }

    @Override
    public void saveList(Bill bill) {
        billList.add(bill);
        fileManagerBill.writeList(billList);

    }

    @Override
    public void removeByIndex(int index) {
        billList.remove(index);
        fileManagerBill.writeList(billList);
    }

    @Override
    public void updateByIndex(int index, Bill bill) {
        billList.set(index, bill);
        fileManagerBill.writeList(billList);
    }

    @Override
    public Bill searchById(String id) {
        Bill bill = null;
        for (int i = billList.size()-1; i >= 0; i--) {
            if (billList.get(i).getCode().equalsIgnoreCase(id)) {
                bill = billList.get(i);
                break;
            }
        }
        return bill;
    }

    @Override
    public Bill searchByName(String name) {
        Bill bill = null;
        for (int i = billList.size() -1; i >= 0; i--) {
            if (billList.get(i).getUser().getUsername().equalsIgnoreCase(name)) {
                bill = billList.get(i);
                break;
            }
        }
        return bill;
    }

    @Override
    public void showAllList() {
        for (Bill bill: billList
        ) {
            System.out.println(bill);
        }
    }
}
