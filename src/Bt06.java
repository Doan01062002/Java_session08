import java.util.Scanner;

public class Bt06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stringVar = "";
        int numVar = 0;
        int choice, subChoice;

        do {
            System.out.println("=== MENU CHINH ===");
            System.out.println("1. Xử lý chuỗi");
            System.out.println("2. Xử lý số nguyên");
            System.out.println("3. Thoát chương trình");
            System.out.print("Chọn chức năng (1-3): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    do {
                        System.out.println("=== MENU XU LY CHUOI ===");
                        System.out.println("1. Nhập chuỗi");
                        System.out.println("2. Lượng bộ khoảng trắng trong chuỗi");
                        System.out.println("3. Đếm số lần xuất hiện của từ khóa");
                        System.out.println("4. Chuyển đổi chuỗi thành dạng chuẩn (viết hoa chữ cái đầu mỗi từ)");
                        System.out.println("5. Quay lại menu chính");
                        System.out.print("Chọn chức năng (1-5): ");
                        subChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (subChoice) {
                            case 1:
                                System.out.print("Nhập chuỗi: ");
                                stringVar = scanner.nextLine();
                                break;
                            case 2:
                                int countSpaces = 0;
                                for (char c : stringVar.toCharArray()) {
                                    if (c == ' ') {
                                        countSpaces++;
                                    }
                                }
                                System.out.println("Số khoảng trắng: " + countSpaces);
                                break;
                            case 3:
                                System.out.print("Nhập từ khóa để đếm: ");
                                String keyword = scanner.nextLine();
                                int countKeywords = 0;
                                String[] words = stringVar.split("\\s+");
                                for (String word : words) {
                                    if (word.equalsIgnoreCase(keyword)) {
                                        countKeywords++;
                                    }
                                }
                                System.out.println("Số lần xuất hiện của '" + keyword + "': " + countKeywords);
                                break;
                            case 4:
                                String[] wordss = stringVar.split("\\s+");
                                StringBuilder result = new StringBuilder();
                                for (String word : wordss) {
                                    if (!word.isEmpty()) {
                                        result.append(Character.toUpperCase(word.charAt(0)))
                                                .append(word.substring(1).toLowerCase())
                                                .append(" ");
                                    }
                                }
                                System.out.println("Chuỗi sau khi chuẩn hóa: " + result.toString().trim());
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    } while (subChoice != 5);
                    break;
                case 2:
                    do {
                        System.out.println("=== MENU XU LY SO NGUYEN ===");
                        System.out.println("1. Nhập số nguyên");
                        System.out.println("2. Tính tổng các chữ số trong số");
                        System.out.println("3. Kiểm tra số nguyên tố");
                        System.out.println("4. Tìm tra mảng có phần tử lớn nhất");
                        System.out.println("5. Quay lại menu chính");
                        System.out.print("Chọn chức năng (1-5): ");
                        subChoice = scanner.nextInt();
                        scanner.nextLine();

                        switch (subChoice) {
                            case 1:
                                System.out.print("Nhập số nguyên: ");
                                numVar = scanner.nextInt();
                                break;
                            case 2:
                                int sum = 0;
                                int tempNum = Math.abs(numVar);
                                while (tempNum > 0) {
                                    sum += tempNum % 10;
                                    tempNum /= 10;
                                }
                                System.out.println("Tổng các chữ số: " + sum);
                                break;
                            case 3:
                                if (numVar <= 1) {
                                    System.out.println(numVar + " không phải là số nguyên tố");
                                } else {
                                    boolean isPrime = true;
                                    for (int i = 2; i <= Math.sqrt(numVar); i++) {
                                        if (numVar % i == 0) {
                                            isPrime = false;
                                            break;
                                        }
                                    }
                                    if (isPrime) {
                                        System.out.println(numVar + " là số nguyên tố");
                                    } else {
                                        System.out.println(numVar + " không phải là số nguyên tố");
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Nhập số phần tử của mảng: ");
                                int size = scanner.nextInt();
                                int[] arr = new int[size];
                                System.out.println("Nhập các phần tử của mảng:");
                                for (int i = 0; i < size; i++) {
                                    arr[i] = scanner.nextInt();
                                }
                                int max = arr[0];
                                for (int i = 1; i < size; i++) {
                                    if (arr[i] > max) {
                                        max = arr[i];
                                    }
                                }
                                System.out.println("Phần tử lớn nhất trong mảng: " + max);
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Lựa chọn không hợp lệ!");
                        }
                    } while (subChoice != 5);
                    break;
                case 3:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 3);
        scanner.close();
    }
}