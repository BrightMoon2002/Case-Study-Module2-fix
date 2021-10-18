package model.idol;

import java.io.Serializable;

    public class IdolB extends Idol implements Serializable {
        public IdolB() {
        }


        public IdolB(String stageName, String dOB, double height, String bodyMeasurements, String service, double price, boolean status, int countChecker) {
            super(stageName, dOB, height, bodyMeasurements, service, price, status, countChecker);
        }

        public IdolB(String stageName, String dOB, double height, String bodyMeasurement, String id) {
            super(stageName, dOB, height, bodyMeasurement,  id);
            super.setService("HJ,BJ");
            super.setTip(300);
            super.setStatus(false);
            super.setCountChecker(0);
        }

        @Override
        public String getStageName() {
            return super.getStageName();
        }

        @Override
        public void setStageName(String stageName) {
            super.setStageName(stageName);
        }

        @Override
        public String getdOB() {
            return super.getdOB();
        }

        @Override
        public void setdOB(String dOB) {
            super.setdOB(dOB);
        }

        @Override
        public double getHeight() {
            return super.getHeight();
        }

        @Override
        public void setHeight(double height) {
            super.setHeight(height);
        }

        @Override
        public String getBodyMeasurements() {
            return super.getBodyMeasurements();
        }

        @Override
        public void setBodyMeasurements(String bodyMeasurements) {
            super.setBodyMeasurements(bodyMeasurements);
        }

        @Override
        public String getService() {
            return super.getService();
        }

        @Override
        public void setService(String service) {
            super.setService(service);
        }

        @Override
        public double getTip() {
            return super.getTip();
        }

        @Override
        public void setTip(double tip) {
            super.setTip(tip);
        }

        @Override
        public boolean isStatus() {
            return super.isStatus();
        }

        @Override
        public void setStatus(boolean status) {
            super.setStatus(status);
        }

        @Override
        public int getCountChecker() {
            return super.getCountChecker();
        }

        @Override
        public void setCountChecker(int countChecker) {
            super.setCountChecker(countChecker);
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }


