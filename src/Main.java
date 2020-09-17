
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] bookList = new Book[10];
        for (int i = 0; i < 5; i++) {
            System.out.println("Nhập sách lập trình số " + (i + 1));
            System.out.println("Nhập bookcode: ");
            String bookcode = sc.nextLine();
            System.out.println("Nhập tên: ");
            String name = sc.nextLine();
            System.out.println("Nhập giá: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.println("Nhập tác giả: ");
            String author = sc.nextLine();
            System.out.println("Nhập ngôn ngữ: ");
            String language = sc.nextLine();
            System.out.println("Nhập framework: ");
            String framework = sc.nextLine();
            bookList[i] = new ProgrammingBook(bookcode,name,price,author,language,framework);
        }
        for (int i = 5; i < 10; i++) {
            System.out.println("Nhập sách fiction số " + (i + 1) + ": ");
            System.out.println("Nhập bookcode: ");
            String bookcode = sc.nextLine();
            System.out.println("Nhap ten: ");
            String name = sc.nextLine();
            System.out.println("Nhap gia: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.println("Nhap tac gia: ");
            String author = sc.nextLine();
            System.out.println("Nhap category: ");
            String category = sc.nextLine();
            bookList[i] = new FictionBook(bookcode, name, price, author, category);
        }

        // in ra tổng giá
        System.out.println(Book.getTotalPrice());

        // đếm số sách có language là Java
        int count = 0;
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i] instanceof ProgrammingBook) {
                String languageOfBook = ((ProgrammingBook) bookList[i]).getLanguage();
                if (languageOfBook.equals("Java")) {
                    count++;
                }
            }
        }
        System.out.println("Số sách lập trình có language là Java là " + count);

        // tìm sách theo giá
        System.out.println("Nhập giá muốn tìm: ");
        double priceInput = sc.nextDouble();
        for (int i = 0; i < bookList.length; i++) {
            if (bookList[i].getPrice() == priceInput) {
                System.out.println(bookList[i].getName());
            }
        }
        // sắp xếp theo giá kiểu nổi bọt
        for (int i = 0; i < bookList.length; i++) {
            for (int j = i + 1; j < bookList.length - 1; j++) {
                if (bookList[i].getPrice() > bookList[j].getPrice()) {
                    Book temp = new Book();
                    bookList[i] = bookList[j];
                    bookList[j] = temp;
                }
            }
        }
        System.out.println(bookList.toString());

        // sắp xếp theo giá kiểu chèn
        for (int i = 0; i < bookList.length; i++) {
            Book temp = bookList[i];
            int j = i - 1;
            while (j >= 0 && temp.getPrice() < bookList[j].getPrice()) {
                bookList[j + 1] = bookList[j];
                j--;
            }
            bookList[j + 1] = temp;
        }
        System.out.println(bookList.toString());

        // sắp xếp theo giá kiểu chọn
        for (int i = 0; i < bookList.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < bookList.length; j++) {
                if (bookList[j].getPrice() < bookList[min].getPrice()) {
                    min = j;
                }
            }
            if (min != i) {
                Book temp = bookList[min];
                bookList[min] = bookList[i];
                bookList[i] = temp;
            }
        }
        System.out.println(bookList.toString());

        // tìm kiếm giá của sách có tên nhập vào theo tìm kiếm nhị phân
        System.out.println("Nhập vào giá cần tìm: ");
        double bookPrice = sc.nextDouble();
        BinarySearch binary = new BinarySearch();
        int result = binary.binarySearch(bookList,0,bookList.length - 1, bookPrice);
        if (result == -1) {
            System.out.println("Không tìm thấy kết quả");
        } else {
            System.out.println(bookList[result].getName());
        }
    }
}
