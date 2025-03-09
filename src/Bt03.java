import java.util.Scanner;

public class Bt03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String email, password;

        while (true) {
            System.out.print("Nhập email: ");
            email = scanner.nextLine();

            int atCount = 0, dotCount = 0;
            boolean isValid = true;

            if (email.length() == 0 ||
                    !((email.charAt(0) >= 'a' && email.charAt(0) <= 'z') ||
                            (email.charAt(0) >= 'A' && email.charAt(0) <= 'Z') ||
                            (email.charAt(0) >= '0' && email.charAt(0) <= '9'))) {
                isValid = false;
            }

            for (int i = 0; i < email.length(); i++) {
                char c = email.charAt(i);
                if (c == '@') atCount++;
                if (c == '.') dotCount++;

                if (!(Character.isLetterOrDigit(c) || c == '.' || c == '_' || c == '-' || c == '@')) {
                    isValid = false;
                    break;
                }
            }

            if (atCount != 1 ||
                    !(email.endsWith(".com") || email.endsWith(".vn") || email.endsWith(".org"))) {
                isValid = false;
            }

            if (isValid) break;
            System.out.println("Email không hợp lệ. Vui lòng nhập lại!");
        }

        while (true) {
            System.out.print("Nhập mật khẩu: ");
            password = scanner.nextLine();

            boolean hasUpper = false, hasLower = false, hasDigit = false, hasSpecial = false;

            if (password.length() >= 8) {
                for (int i = 0; i < password.length(); i++) {
                    char c = password.charAt(i);
                    if (c >= 'A' && c <= 'Z') hasUpper = true;
                    if (c >= 'a' && c <= 'z') hasLower = true;
                    if (c >= '0' && c <= '9') hasDigit = true;
                    if (c == '@' || c == '#' || c == '$' || c == '%' || c == '!' || c == '&' || c == '*') hasSpecial = true;
                }
            }

            if (hasUpper && hasLower && hasDigit && hasSpecial) break;
            System.out.println("Mật khẩu không hợp lệ. Vui lòng nhập lại!");
        }

        System.out.println("Email và mật khẩu hợp lệ!");
        scanner.close();
    }
}
