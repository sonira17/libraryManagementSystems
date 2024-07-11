import java.util.*;

interface Library{
    // methods for performing CRUD operation
    public int addBook(int bookCount,String[] books,String bookName);
    public int deleteRecord(int bookCount);
    public int updateRecord(String[] books,int changeIndex,String book);
    public void AvailableBook(String[] books,int bookCount);
}

class SimpleLibrary implements Library{

    public int addBook(int bookCount,String[] books,String BookName){
       books[bookCount-1]=BookName;
       bookCount++;
       return bookCount;
    }
   public int deleteRecord(int bookCount){
         bookCount--;
         return bookCount;
    } 
    public int updateRecord(String[] books,int changeIndex,String book){
           books[changeIndex]=book;
           return 1;
      }
  public void AvailableBook(String[] books,int bookCount){
          for(int i=0;i<bookCount;i++){
              System.out.println(books[i]);
          }
    }
}

public class libraryManagementSystem {
     public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    SimpleLibrary library=new SimpleLibrary();
    int bookCount=5;
    String[] books=new String[]{"Java Books ","C++ Books", "C Books","Python Books",".Net Books"};
    boolean exit=false;
    while (!exit) {
        System.out.println("\nLibrary Management System:");
        System.out.println("1. Add Book");
        System.out.println("2. Remove Book");
        System.out.println("3. Display Books");
        System.out.println("4. Update Record");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
        int choice = sc.nextInt();
        sc.nextLine(); 
        int res=0;
        switch (choice) {
            case 1:
                System.out.print("Enter book Name: ");
                String bookName = sc.nextLine();
                res=library.addBook(bookCount,books,bookName);
                System.out.println("Book added Successfully and book count is "+res);
                break;
            case 2:
                System.out.print("Enter book number to delete: ");
                int temp=sc.nextInt();
                res=library.deleteRecord(temp);
                System.out.println("Book deleted Successfully and book count is "+res);
                break;
            case 3:
                library.AvailableBook(books,bookCount);
                break;
            case 4:
                System.out.print("Enter What do you want to do issue(1) or return(0) a book");
                int ch=sc.nextInt();
                sc.nextLine();
                 System.out.println("Enter book name");
                String BookName=sc.nextLine();
                updation(BookName,books,bookCount, ch);
                break;
            case 5:
                exit = true;
                break;
            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

}
// find the book  and update the book status
 static void updation(String BookName, String[] books,int bookCount,int ch){
     for(int i=0;i<bookCount;i++){
        if(books[i].equals(BookName)){
            if(ch==1){
               //ch=1 issue
          books[i]="";
          System.out.println("Book issued successfully");
          break;
            }
         }
        else if(ch==0){
            SimpleLibrary library=new SimpleLibrary();
            library.addBook(bookCount,books,BookName);
            System.out.println("Book received successfully");
            break;
        }
  }
}

  }

