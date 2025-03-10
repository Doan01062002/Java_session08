import java.util.Scanner;

public class Practice2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[0][0];
        int n = 0, m = 0;
        int choice;

        do {
            System.out.println("\n*************** MENU ***************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng");
            System.out.println("4. In các phần tử và tổng trên biên, đường chéo chính, đường chéo phụ");
            System.out.println("5. Sắp xếp các phần tử tăng dần theo cột");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp đường chéo chính giảm dần");
            System.out.println("8. Chèn một mảng một chiều vào mảng hai chiều");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Nhập số hàng: ");
                    n = scanner.nextInt();
                    System.out.print("Nhập số cột: ");
                    m = scanner.nextInt();
                    matrix = new int[n][m];

                    System.out.println("Nhập các phần tử của mảng:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print("matrix[" + i + "][" + j + "] = ");
                            matrix[i][j] = scanner.nextInt();
                        }
                    }
                    break;

                case 2:
                    System.out.println("Mảng hiện tại:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.print(matrix[i][j] + " ");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    int countDiv2And3 = 0;
                    for (int[] row : matrix) {
                        for (int num : row) {
                            if (num % 2 == 0 && num % 3 == 0) {
                                countDiv2And3++;
                            }
                        }
                    }
                    System.out.println("Số phần tử chia hết cho 2 và 3: " + countDiv2And3);
                    break;

                case 4:
                    int sum = 0;
                    System.out.println("Phần tử trên biên, đường chéo chính, đường chéo phụ:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1 || i == j || i + j == m - 1) {
                                System.out.print(matrix[i][j] + " ");
                                sum += matrix[i][j];
                            } else {
                                System.out.print("  ");
                            }
                        }
                        System.out.println();
                    }
                    System.out.println("Tổng các phần tử trên biên, đường chéo chính, đường chéo phụ: " + sum);
                    break;

                case 5:
                    for (int col = 0; col < m; col++) {
                        for (int i = 0; i < n - 1; i++) {
                            for (int j = i + 1; j < n; j++) {
                                if (matrix[i][col] > matrix[j][col]) {
                                    int temp = matrix[i][col];
                                    matrix[i][col] = matrix[j][col];
                                    matrix[j][col] = temp;
                                }
                            }
                        }
                    }
                    System.out.println("Mảng sau khi sắp xếp tăng dần theo cột.");
                    break;

                case 6:
                    System.out.println("Các số nguyên tố trong mảng:");
                    for (int[] row : matrix) {
                        for (int num : row) {
                            if (num > 1) {
                                boolean isPrime = true;
                                for (int j = 2; j * j <= num; j++) {
                                    if (num % j == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                                if (isPrime) {
                                    System.out.print(num + " ");
                                }
                            }
                        }
                    }
                    System.out.println();
                    break;

                case 7:
                    int[] diagonal = new int[Math.min(n, m)];
                    for (int i = 0; i < diagonal.length; i++) {
                        diagonal[i] = matrix[i][i];
                    }

                    for (int i = 0; i < diagonal.length - 1; i++) {
                        for (int j = i + 1; j < diagonal.length; j++) {
                            if (diagonal[i] < diagonal[j]) {
                                int temp = diagonal[i];
                                diagonal[i] = diagonal[j];
                                diagonal[j] = temp;
                            }
                        }
                    }

                    for (int i = 0; i < diagonal.length; i++) {
                        matrix[i][i] = diagonal[i];
                    }

                    System.out.println("Đã sắp xếp đường chéo chính giảm dần.");
                    break;

                case 8:
                    System.out.print("Nhập số phần tử của mảng 1 chiều: ");
                    int p = scanner.nextInt();
                    int[] array1D = new int[p];

                    System.out.println("Nhập các phần tử:");
                    for (int i = 0; i < p; i++) {
                        System.out.print("array1D[" + i + "] = ");
                        array1D[i] = scanner.nextInt();
                    }

                    System.out.print("Nhập chỉ số dòng cần chèn: ");
                    int rowIndex = scanner.nextInt();

                    if (rowIndex < 0 || rowIndex > n) {
                        System.out.println("Chỉ số dòng không hợp lệ!");
                    } else {
                        int[][] newMatrix = new int[n + 1][m];
                        for (int i = 0, k = 0; i < n + 1; i++) {
                            if (i == rowIndex) {
                                for (int j = 0; j < m; j++) {
                                    newMatrix[i][j] = (j < p) ? array1D[j] : 0;
                                }
                            } else {
                                for (int j = 0; j < m; j++) {
                                    newMatrix[i][j] = matrix[k][j];
                                }
                                k++;
                            }
                        }
                        matrix = newMatrix;
                        n++;
                        System.out.println("Mảng sau khi chèn:");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                System.out.print(matrix[i][j] + " ");
                            }
                            System.out.println();
                        }
                    }
                    break;

                case 9:
                    System.out.println("Thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
            }
        } while (choice != 9);

        scanner.close();
    }
}
