import java.util.Scanner;

public class Bt05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        int[] numbers = new int[0];

        do {
            System.out.println("\n************************* MENU *****************************");
            System.out.println("1. Nhập giá trị 'n' phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương trong mảng");
            System.out.println("4. In ra vị trí các phần tử có giá trị bằng 'k' trong mảng");
            System.out.println("5. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("6. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Nhập số phần tử của mảng: ");
                    int size = scanner.nextInt();
                    numbers = new int[size];
                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < size; i++) {
                        System.out.print("Phần tử " + i + " = ");
                        numbers[i] = scanner.nextInt();
                    }
                    break;

                case 2:
                    if (numbers.length == 0) {
                        System.out.println("Mảng chưa được khởi tạo.");
                    } else {
                        System.out.println("Các giá trị trong mảng:");
                        for (int i = 0; i < numbers.length; i++) {
                            System.out.printf("[%d] = %d\n", i + 1, numbers[i]);
                        }
                    }
                    break;

                case 3:
                    if (numbers.length == 0) {
                        System.out.println("Mảng chưa được khởi tạo.");
                    } else {
                        int sum = 0, count = 0;
                        for (int num : numbers) {
                            if (num > 0) {
                                sum += num;
                                count++;
                            }
                        }
                        if (count > 0) {
                            System.out.println("Giá trị trung bình các số dương: " + (sum / (double) count));
                        } else {
                            System.out.println("Không có số dương trong mảng.");
                        }
                    }
                    break;

                case 4:
                    if (numbers.length == 0) {
                        System.out.println("Mảng chưa được khởi tạo.");
                    } else {
                        System.out.print("Nhập giá trị cần tìm kiếm: ");
                        int k = scanner.nextInt();
                        boolean found = false;
                        System.out.print("Vị trí các phần tử có giá trị bằng " + k + ": ");
                        for (int i = 0; i < numbers.length; i++) {
                            if (numbers[i] == k) {
                                System.out.print(i + " ");
                                found = true;
                            }
                        }
                        if (!found) {
                            System.out.println("Không tìm thấy phần tử " + k + " trong mảng.");
                        }
                        System.out.println();
                    }
                    break;

                case 5:
                    if (numbers.length == 0) {
                        System.out.println("Mảng chưa được khởi tạo.");
                    } else {
                        int primeCount = 0;
                        for (int num : numbers) {
                            boolean isPrime = num >= 2;
                            for (int i = 2; i <= Math.sqrt(num) && isPrime; i++) {
                                if (num % i == 0) {
                                    isPrime = false;
                                }
                            }
                            if (isPrime) {
                                primeCount++;
                            }
                        }
                        System.out.println("Số lượng số nguyên tố trong mảng: " + primeCount);
                    }
                    break;

                case 6:
                    System.out.println("Thoát chương trình...");
                    break;

                default:
                    System.out.println("Vui lòng nhập lại lựa chọn hợp lệ.");
            }
        } while (choice != 6);
    }
}
