package model.room;

import java.io.Serializable;

public class RoomVip extends Room implements Serializable {

    @Override
    boolean getStatus() {
        return false;
    }

    public RoomVip(String code, double price, boolean status) {
        super(code, price, status);
    }

    public RoomVip() {
    }

    public RoomVip(String code) {
        super(code);
        super.setStatus(false);
        super.setPrice(200);
    }

    @Override
    public String getCode() {
        return super.getCode();
    }

    @Override
    public void setCode(String code) {
        super.setCode(code);
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }

    @Override
    public boolean isStatus() {
        return super.isStatus();
    }

    @Override
    public void setStatus(boolean status) {
        super.setStatus(status);
    }
}
