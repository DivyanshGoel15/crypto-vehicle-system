import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);
    static VehicleRegistry registry = new VehicleRegistry();
    static DigitalSignatureUtil ds;

    public static void main(String[] args) throws Exception {

        ds = new DigitalSignatureUtil();

        while (true) {
            System.out.println("\n1. SHA-256 Hash");
            System.out.println("2. Digital Signature");
            System.out.println("3. Register Vehicle");
            System.out.println("4. Get Vehicle");
            System.out.println("5. Exit");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            switch (choice) {

                case 1 -> hashMessage();
                case 2 -> digitalSignature();
                case 3 -> registerVehicle();
                case 4 -> getVehicle();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }

    static void hashMessage() {
        System.out.print("Enter message: ");
        String msg = sc.nextLine();
        System.out.println("Hash: " + HashUtil.sha256(msg));
    }

    static void digitalSignature() {
        try {
            System.out.print("Enter message: ");
            String msg = sc.nextLine();

            String signature = ds.sign(msg);
            System.out.println("Signature: " + signature);

            boolean valid = ds.verify(msg, signature);
            System.out.println("Valid: " + valid);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    static void registerVehicle() {
        System.out.print("Number Plate: ");
        String plate = sc.nextLine();

        System.out.print("Owner: ");
        String owner = sc.nextLine();

        System.out.print("Model: ");
        String model = sc.nextLine();

        registry.registerVehicle(plate, owner, model);
    }

    static void getVehicle() {
        System.out.print("Enter Plate: ");
        String plate = sc.nextLine();

        registry.getVehicle(plate);
    }
}