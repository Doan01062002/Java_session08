import java.util.Scanner;

public class Bt01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Vui lòng nhập kích thước của mảng");
        int size = scanner.nextInt();

        int [] numbers = new int[size];
        if (size > 0) {
            System.out.println("Nhập các phần tử trong mảng");
            for (int i = 0; i < size; i++) {
                numbers[i] = scanner.nextInt();
            }

            int max = numbers[0];
            int min = numbers[0];
            for (int i = 1; i < numbers.length; i++) {
                if (numbers[i] >= max) {
                    max = numbers[i];
                }
                if (numbers[i] <= min) {
                    min = numbers[i];
                }
            }

            System.out.println("Giá trị lớn nhất là: " + max);
            System.out.println("Giá trị nhỏ nhất là: " + min);
        }else {
            System.out.println("Kích thước không hợp lệ");
        }
    }
}
