import java.util.Scanner;

public class ArrayCRUD {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int maxSize = 100;  // Kích thước tối đa của mảng
        int[] array = new int[maxSize]; // Mảng cố định
        int size = 0; // Số lượng phần tử hiện tại trong mảng
        int choice;

        do {
            System.out.println("\n*************** MENU CRUD ***************");
            System.out.println("1. Thêm phần tử vào mảng");
            System.out.println("2. Hiển thị danh sách phần tử");
            System.out.println("3. Cập nhật phần tử");
            System.out.println("4. Xóa phần tử");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (size < maxSize) {
                        System.out.print("Nhập số cần thêm: ");
                        int newNumber = scanner.nextInt();
                        array[size] = newNumber;
                        size++;
                        System.out.println("Đã thêm " + newNumber + " vào mảng.");
                    } else {
                        System.out.println("Mảng đã đầy, không thể thêm phần tử mới.");
                    }
                    break;

                case 2:
                    if (size == 0) {
                        System.out.println("Mảng rỗng!");
                    } else {
                        System.out.println("Danh sách phần tử:");
                        for (int i = 0; i < size; i++) {
                            System.out.println("[" + i + "] = " + array[i]);
                        }
                    }
                    break;

                case 3:
                    if (size == 0) {
                        System.out.println("Mảng rỗng! Không có gì để cập nhật.");
                    } else {
                        System.out.print("Nhập chỉ số cần cập nhật: ");
                        int updateIndex = scanner.nextInt();
                        if (updateIndex >= 0 && updateIndex < size) {
                            System.out.print("Nhập giá trị mới: ");
                            int updatedValue = scanner.nextInt();
                            array[updateIndex] = updatedValue;
                            System.out.println("Đã cập nhật phần tử tại vị trí " + updateIndex);
                        } else {
                            System.out.println("Chỉ số không hợp lệ!");
                        }
                    }
                    break;

                case 4:
                    if (size == 0) {
                        System.out.println("Mảng rỗng! Không có gì để xóa.");
                    } else {
                        System.out.print("Nhập chỉ số cần xóa: ");
                        int deleteIndex = scanner.nextInt();
                        if (deleteIndex >= 0 && deleteIndex < size) {
                            for (int i = deleteIndex; i < size - 1; i++) {
                                array[i] = array[i + 1]; // Dời các phần tử lên
                            }
                            size--; // Giảm kích thước mảng
                            System.out.println("Đã xóa phần tử tại vị trí " + deleteIndex);
                        } else {
                            System.out.println("Chỉ số không hợp lệ!");
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
