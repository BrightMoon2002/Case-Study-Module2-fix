package model.idol;

public class IdolFactory {
    private IdolFactory() {}

    public static final Idol getIdol(IdolType idolType, String stageName, String dOB, double height, String body, String id) {
//        System.out.println("Enter the stage name of idol:");
//        Scanner inputStageName = new Scanner(System.in);
//        String stageName = inputStageName.nextLine();
//        System.out.println("Enter the id of idol:");
//        Scanner inputId = new Scanner(System.in);
//        String id = inputId.nextLine();
//        System.out.println("Enter the dob of idol:");
//        Scanner inputDOB = new Scanner(System.in);
//        String dOB = inputDOB.nextLine();
//        System.out.println("Enter the idol height");
//        Scanner inputHeight = new Scanner(System.in);
//        double height = inputHeight.nextDouble();
//        System.out.println("Enter the Body Measurements");
//        Scanner inputBody = new Scanner(System.in);
//        String body = inputBody.nextLine();
        switch (idolType) {
            case IDOLA:
                return  new IdolA(stageName, dOB, height, body, id);
            case IDOLB:
                return new IdolB(stageName, dOB, height, body, id);
            case IDOLC:
                return new IdolC(stageName, dOB, height, body, id);
            default:
                throw new IllegalArgumentException("This idol type is unsupported");
        }
    }
}

