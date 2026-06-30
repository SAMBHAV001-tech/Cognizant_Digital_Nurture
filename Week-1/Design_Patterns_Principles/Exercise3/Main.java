public class Main {
    public static void main(String[] args) {
        Computer basic = new Computer.Builder("Intel i3", "8GB", "256GB SSD")
                .build();

        Computer gaming = new Computer.Builder("Intel i9", "32GB", "1TB NVMe")
                .gpu("NVIDIA RTX 4090")
                .os("Windows 11")
                .build();

        Computer workstation = new Computer.Builder("AMD Ryzen 9", "64GB", "2TB SSD")
                .gpu("AMD Radeon RX 7900")
                .os("Ubuntu 22.04")
                .build();

        System.out.println("--- Basic Computer ---");
        System.out.println(basic);

        System.out.println("\n--- Gaming Computer ---");
        System.out.println(gaming);

        System.out.println("\n--- Workstation ---");
        System.out.println(workstation);
    }
}
