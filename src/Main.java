import java.util.stream.*;

public class Main {

    public static void main(String[] args) {
       // System.out.println("Hello World!");

       // Exercise01();
        //Exercise02(2,3);
        //System.out.println(Exercise02(2,3));
        //Exercise 0.3:
     // Book b1 = new Book();
        //        Book b2 = new Book();

           // b1.numberOfPages=20;
        //        b2.numberOfPages=30;
        //        System.out.println("bOOK1 : "+b1.numberOfPages);
        //        System.out.println("bOOK1 : "+b2.numberOfPages);
//b1.setNumberOfPages(999);
  //      System.out.println("bOOK1 : "+b1.getNumberOfPages());

//Exercise 0.4:  ( Objects and pass by value )
// Create a function in the main class ( class example ) that is called createLArgeBook.
// Make the function create a new book with 100 pages and return it
// Call the function from main and check that main received a book with 100 pages.
      // Book b= createLArgeBook();
        // System.out.println("bOOK1 : "+b.getNumberOfPages());

        //Exercise 0.5:
        // Create a function in the main class called add1page that accepts a book param
        // Make th function increment the book’s number of pages by 1
        // Call the function from main and check that it works
       // Book b= Book.createLArgeBook();
//        System.out.println("bOOK1 : "+b.getNumberOfPages());
//b.add1page();
     //   System.out.println("bOOK1 : "+b.getNumberOfPages());
//Exercise 0.6:
// Change the Book class to have a constructor that takes the number of pages as a parameter
// change main accordingly
        //Book b= new Book(101);
        // System.out.println("bOOK1 : "+b.getNumberOfPages());
// Exercise 0.7:
//  Create a function called increaseNumbers that accepts 3 numbers, increases all of them by 10, and returns all 3 numbers to main
       // ????

//        Arrays:
//        Excercise 1:
//        Create an array of 5 integers, fill them with values
//        Write a function sum , which receives the array as a parameter and returns the sum of the elements
//        Optional Advanced: Write a function min which finds the smallest element in the array
//        int arr[]={1,2,3,4,5};
//        int a = sumOfArr(arr);
//        System.out.println("Summary of array : "+a);
//        System.out.println("Minimom of array : "+ minOfArr(arr));

//Arrays: EXercise 1.2:
// Create an array of 5 books, each with a different number of pages
// Write a function sum that takes the array and returns the total count of all pages

//        Book[] books = new Book[5];
//        books[0]= new Book(200);
//        books[1]= new Book(300);
//        books[2]= new Book(400);
//        books[3]= new Book(500);
//        books[4]= new Book(600);
//        System.out.println("totalCountPfAllPages : "+ totalCountPfAllPages(books));

        //Arrays: Exercise 1.3:
        // Create a 2 Dimensional array of doubles (3X2) and fill it with values
        // Write a function that for each row , prints the sum of the numbers in the row
//        int[][] multiples = new int[3][2];
//        int nosCols = multiples[0].length;  // 2
//        int nosRows = multiples.length;     // 3
//        for(int i=0;i<nosRows ;i++)
//        {
//            for(int j=0;j<nosCols ; j++)
//            {
//                multiples[i][j]=i+j;
//                System.out.print(" "+ multiples[i][j]+" ");
//            }
//            System.out.println("");
//        }
//        sumOfNumbersRow(multiples);

//Arrays and Constructors:
//Excercise 2:
// Create an array that can hold 5 books
// Write a function fillBooks that receives the array as a parameter and puts 5 new books with titles in the array
// Write a function listBooks which receives the array as a parameter and and prints the titles of all the books
//Excercise 2b:
// Add a constructor to class Book that takes a String title argument ???
//        Book[] books = new Book[5];
//        listBooks(fillBooks(books));

        //Encapsulation:
        //Excercise 3:
        // Create a class book with a field called title
        // Make the field private, and create a public setTitle function, and getTitle function
        // From main, create some books, and set their titles, and then print their titles, and test your code
        // Now change your code so that the setTitle function always makes the title upper case (e.g. WAR AND PEACE ), no matter what was sent in
/// >>>  solution done in step before added to uppercase in constructore
//
//Book b = new Book();
//b.setBookTile("xvcffdvfdgvfgbvfb");
//b.printTitle();



//Packages:
//Excercise 4:
// In your store excercise, put Book in the package storeProgram.storeItems
// Put the class Store in the package storeProgram itself ( not package storeProgram.storeItems )
// ???

        // Inheritance:
        // Excercise 5:
        //  Make a class Person with String name
        //  Make a class Employee with name and int employeeNumber
        //  in Class Example  Make a static function void setPersonName( String firstName, String lastName, Person person )
        //  which takes first name, last name, combines them e.g. "Gonen Israeli" and sets the person name to the combined name
        //  Make sure your function works for employees and regular persons without copy paste

//        Person person = new Person();
//        Employee e = new Employee();
//e.setPersonName( "firstName", "lastName",  person );
        // Create a circle with radius 1
//        Circle circle1 = new Circle();
//        System.out.println("The area of the circle of radius "  + circle1.radius + " is " + circle1.getArea());


//Inheritance and Polymorphism
//Excercise 6:
//•    Create a Store class that will hold CDs and Books.
//•    Create methods for adding CDs and Books to the Store. Create methods to retrieve them from the Store.
//•    Make CD and Book
// extend Item.
//•    Item will have name and price, and a printInfo function
//•    Create a CD class that adds a band member
//•    Create a Book class add an author member.
//•    Change the Store to have only one array member ( for books and cds )
//•    Change the client to work with items.
//*                In the Store class, Add a function printAllItems to loop through the array and print all books and cds




    }

    private static void listBooks(Book[] fillBooks) {
        for (Book book:fillBooks) {
            book.printTitle();

        }
    }

    private static Book[] fillBooks(Book[] books) {

        books[0]= new Book("First Book");
        books[1]= new Book("Second Book");
        books[2]= new Book("Third Book");
        books[3]= new Book("Forth Book");
        books[4]= new Book("Fifth Book");

        return books;
    }

    private static void sumOfNumbersRow(int[][] multiples) {

        int nosCols = multiples[0].length;  // 2
        int nosRows  = multiples.length;     // 3

//        System.out.println("nosRows "+nosRows );
//        System.out.println("nosCols "+nosCols );


        int sumOfRow =0;

        for(int i=0;i<nosRows ;i++)
        {
            for(int j=0;j<nosCols ; j++)
                            sumOfRow+=  multiples[i][j];


            System.out.println("sumOfRow["+i+"]: "+ sumOfRow );
            sumOfRow =0;
        }

    }

    private static int totalCountPfAllPages(Book[] books) {

        int summary =0;
        for (Book book:books) {
            summary += book.getNumberOfPages();

        }
        return  summary;

    }

    private static int minOfArr(int[] arr) {
        int min=arr[0];

        for (int i=1 ;i< arr.length;i++   )
        {
            if (min>arr[i])
                min=arr[i];

        }
        return min;


    }

    private static int sumOfArr(int[] arr) {
        return (IntStream.of(arr).sum());
        
    }


    public static void increaseNumbers(Integer a, Integer b, Integer c) {
        a+=10;
        b+=10;
        c+=10;


    }


    private static int Exercise02(int i, int i1) {
        //Exercise 0.2:
        // Write a program with a function called add, which takes 2 intergers and returns their sum
        // From main, call add(2,3) and print the returned value
        return i+i1;
    }

    private static void Exercise01() {
        // Exercise 0.1:
        // Write a program that prints the numbers from 1 to 10 using a for loop
        for (   int i =1 ; i<11; i++)
            System.out.println(i);
    }

}


