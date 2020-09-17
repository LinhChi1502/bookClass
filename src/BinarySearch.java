public class BinarySearch {
    public int binarySearch(Book[] arr, int l, int r, double price) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // Nếu arr[mid] = x, trả về chỉ số và kết thúc
            if (arr[mid].getPrice() == price)
                return mid;

            // Nếu arr[mid] > x, gọi đệ quy tìm kiếm bên trái
            if (arr[mid].getPrice() > price)
                return binarySearch(arr, l, mid - 1, price);

            // Ngược lại, nếu arr[mid] < x, gọi đệ quy tìm kiếm bên phải
            return binarySearch(arr, mid + 1, r, price);
        }

        // Trong trường hợp không tìm thấy
        return -1;
    }
}
