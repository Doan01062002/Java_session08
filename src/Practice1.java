import java.util.Arrays;
import java.util.Scanner;

public class Practice1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int [] numbers = new int[0];
        int choice = 0;
        do {
            System.out.println("\n ****************************** MENU ************************** \n");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong mảng");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, các phần tử còn lại ở giữa mảng theo thứ tự tăng dần");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát");

            System.out.print("Nhâp lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice){
                case 1:
                    System.out.print("Nhập số phần tử trong mảng: ");
                    int size = scanner.nextInt();
                    numbers = new int[size];

                    System.out.println("Vui lòng nhập các phần tử trong mảng");
                    for (int i = 0; i < numbers.length; i++) {
                        System.out.print("Phần tử " + i + " = ");
                        numbers[i] = scanner.nextInt();
                    }
                    break;
                case 2:
                    System.out.print("Các phần tử trong mảng: ");
                    for (int i = 0; i < numbers.length; i++) {
                        System.out.print(numbers[i] + ", ");
                    }
                    break;
                case 3:
                    int sum = 0;
                    int count = 0;
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] > 0) {
                            sum += numbers[i];
                            count++;
                        }
                    }
                    System.out.printf("Các phần tử dương trong mảng là: %d", (sum/count));
                    break;
                case 4:
                    System.out.print("Nhập giá trị bạn muốn tìm trong mảng: ");
                    int findNumber = scanner.nextInt();
                    boolean checkFindNumber = false;
                    System.out.print("Vị trí các phần tử trong mảng là: ");
                    for (int i = 0; i < numbers.length; i++) {
                        if (numbers[i] == findNumber) {
                            System.out.print(i);
                            checkFindNumber = true;
                        }
                    }
                    if (checkFindNumber == false) {
                        System.out.printf("\n Không tìm thấy phần tử %d trong mảng", findNumber);
                    }
                    break;
                case 5:
                    for (int i = 0; i < numbers.length -1; i++) {
                        for (int j = 0; j < numbers.length - 1 -i; j++) {
                            if (numbers[j] < numbers[j+1]) {
                                int temp = numbers[j];
                                numbers[j] = numbers[j+1];
                                numbers[j+1] = temp;
                            }
                        }
                    }

                    System.out.println("Mảng sau khi sắp xếp là: ");
                    for (int i = 0; i < numbers.length; i++) {
                        System.out.print(numbers[i] + ", ");
                    }
                    break;
                case 6:
                    int primeCount = 0;
                    for (int num : numbers) {
                        if (num > 1) {
                            boolean isPrime = true;
                            for (int j = 2; j * j <= num; j++) {
                                if (num % j == 0) {
                                    isPrime = false;
                                    break;
                                }
                            }
                            if (isPrime) primeCount++;
                        }
                    }
                    System.out.println("Số lượng số nguyên tố: " + primeCount);
                    break;
                case 7:
                    int evenCount = 0, oddCount = 0, otherCount = 0;

                    for (int num : numbers) {
                        if (num % 2 == 0 && num % 3 == 0) evenCount++;
                        else if (num % 2 != 0 && num % 3 == 0) oddCount++;
                        else otherCount++;
                    }

                    int[] evenDivisibleBy3 = new int[evenCount];
                    int[] oddDivisibleBy3 = new int[oddCount];
                    int[] others = new int[otherCount];

                    int evenIndex = 0, oddIndex = 0, otherIndex = 0;

                    for (int num : numbers) {
                        if (num % 2 == 0 && num % 3 == 0) evenDivisibleBy3[evenIndex++] = num;
                        else if (num % 2 != 0 && num % 3 == 0) oddDivisibleBy3[oddIndex++] = num;
                        else others[otherIndex++] = num;
                    }

                    int n = evenDivisibleBy3.length;
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (evenDivisibleBy3[j] > evenDivisibleBy3[j + 1]) {
                                int temp = evenDivisibleBy3[j];
                                evenDivisibleBy3[j] = evenDivisibleBy3[j + 1];
                                evenDivisibleBy3[j + 1] = temp;
                            }
                        }
                    }

                    n = others.length;
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (others[j] > others[j + 1]) {
                                int temp = others[j];
                                others[j] = others[j + 1];
                                others[j + 1] = temp;
                            }
                        }
                    }

                    n = oddDivisibleBy3.length;
                    for (int i = 0; i < n - 1; i++) {
                        for (int j = 0; j < n - i - 1; j++) {
                            if (oddDivisibleBy3[j] < oddDivisibleBy3[j + 1]) {
                                int temp = oddDivisibleBy3[j];
                                oddDivisibleBy3[j] = oddDivisibleBy3[j + 1];
                                oddDivisibleBy3[j + 1] = temp;
                            }
                        }
                    }

                    int index = 0;
                    for (int num : evenDivisibleBy3) numbers[index++] = num;
                    for (int num : others) numbers[index++] = num;
                    for (int num : oddDivisibleBy3) numbers[index++] = num;

                    System.out.print("Mảng sau khi sắp xếp: ");
                    for (int num : numbers) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 8:
                    System.out.print("Nhập giá trị m: ");
                    int m = scanner.nextInt();

                    int[] newNumbers = new int[numbers.length + 1];
                    for (int i = 0; i < numbers.length; i++) {
                        newNumbers[i] = numbers[i];
                    }
                    newNumbers[numbers.length] = m;

                    int n1 = newNumbers.length;
                    for (int i = 0; i < n1 - 1; i++) {
                        for (int j = 0; j < n1 - i - 1; j++) {
                            if (newNumbers[j] < newNumbers[j + 1]) {
                                int temp = newNumbers[j];
                                newNumbers[j] = newNumbers[j + 1];
                                newNumbers[j + 1] = temp;
                            }
                        }
                    }

                    numbers = newNumbers;

                    System.out.print("Mảng sau khi chèn m và sắp xếp giảm dần: ");
                    for (int num : numbers) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ vui lòng nhập lại");
            }
        }while (choice != 9);
    }
}
