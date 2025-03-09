import java.util.Scanner;

public class Bt02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Vui lòng nhập kích thước của mảng");
        int size = scanner.nextInt();

        if (size > 0) {
            int [] numbers = new int[size];
            System.out.println("Vui lòng nhập các phần tử của mảng");
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }

            int sum = 0;
            boolean check = true;
            for (int i = 0; i < size; i++) {
                if (numbers[i]%3 == 0) {
                    sum += numbers[i];
                    check = false;
                }
            }
            if (check == true) {
                System.out.println("Không có phần tử nào chia hết cho 3");
            }else {
                System.out.println("Tổng các phần tử chia hết cho 3 là: " + sum);
            }

        }else {
            System.out.println("Kích thước không hợp lệ");
        }
    }
}
