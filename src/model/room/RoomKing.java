package model.room;

import java.io.Serializable;


    public class RoomKing extends Room implements Serializable {
        public RoomKing(String code, double price, boolean status) {
            super(code, price, status);
        }

        public RoomKing() {
            super();
        }

        public RoomKing(String code) {
            super(code);
            super.setPrice(300);
            super.setStatus(false);
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
        boolean getStatus() {
            return false;
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

