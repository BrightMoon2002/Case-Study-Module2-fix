package model.idol;

import java.io.Serializable;

public class IdolA extends Idol implements Serializable {



    public IdolA() {
    }

    public IdolA(String stageName, String dOB, double height, String bodyMeasurements, String service, double price, boolean status, int countChecker) {
        super(stageName, dOB, height, bodyMeasurements, service, price, status, countChecker);
    }

    public IdolA(String stageName, String dOB, double height, String bodyMeasurements, String id) {
        super(stageName, dOB, height, bodyMeasurements, id);
        super.setService("Full Service");
        super.setTip(500);
        super.setStatus(false);
        super.setCountChecker(0);
    }



}

