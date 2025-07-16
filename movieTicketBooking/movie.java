import java.util.Scanner;

public class MovieBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean another = true;

        while (another) {
            double total = 0;

            // 1) Seat category
            System.out.println("Select seat category:");
            System.out.println("1. Regular ($10)\n2. Premium ($15)\n3. VIP ($20)");
            int seatOpt = sc.nextInt();
            switch (seatOpt) {
                case 1 -> total += 10;
                case 2 -> total += 15;
                case 3 -> total += 20;
                default -> System.out.println("Invalid seat choice");
            }

            // 2) Snacks
            System.out.println("Select snacks:");
            System.out.println("1. Popcorn ($5)\n2. Soda ($3)\n3. Chocolate ($4)\n4. None");
            int snackOpt = sc.nextInt();
            switch (snackOpt) {
                case 1 -> total += 5;
                case 2 -> total += 3;
                case 3 -> total += 4;
                case 4 -> {/* no snack */}
                default -> System.out.println("Invalid snack choice");
            }

            // 3) Movie
            System.out.println("Select movie:");
            System.out.println("1. Movie A ($12)\n2. Movie B ($10)\n3. Movie C ($8)");
            int movieOpt = sc.nextInt();
            switch (movieOpt) {
                case 1 -> total += 12;
                case 2 -> total += 10;
                case 3 -> total += 8;
                default -> System.out.println("Invalid movie choice");
            }

            // 4) Show total cost
            System.out.printf("Total cost: $%.2f%n", total);

            // 5) Ask whether to book another
            System.out.println("Book another ticket? (yes=1 / no=0)");
            int cont = sc.nextInt();
            another = (cont == 1);
        }

        System.out.println("Thank you! Enjoy your movie.");
        sc.close();
    }
}
