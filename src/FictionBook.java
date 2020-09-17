public class FictionBook extends Book {
    public String category;
    public FictionBook() {

    }

    public FictionBook(String category) {
        this.category = category;
    }

    public FictionBook(String bookCode, String name, double price, String author, String category) {
        super(bookCode, name, price, author);
        this.category = category;
        totalPrice += price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
