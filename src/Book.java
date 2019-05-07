public class Book {

    int numberOfPages;

    public String getBookTile() {
        return bookTile;
    }

    public void setBookTile(String bookTile) {
        this.bookTile = "WAR AND PEACE";
    }

    private String bookTile;

    public int getNumberOfPages() {
        return this.numberOfPages;
    }

    public void setNumberOfPages(int num) {
        this.numberOfPages = num;
    }

    public Book() {}

    public Book(int numPages) {
        this.numberOfPages = numPages;

    }
    public Book(String title) {
        this.bookTile = title.toUpperCase(); // Title : FIRST BOOK
    }


    public static  Book createLArgeBook() {
        Book book = new Book(100);
      //  book.setNumberOfPages(100);
        return(book);

    }
    public void add1page()
    {
        increaseBookPage();
    }
    public void increaseBookPage()
    {
        this.numberOfPages++;
    }

    public void printTitle()
    {
        System.out.println("Title : "+  this.bookTile);

    }


}
