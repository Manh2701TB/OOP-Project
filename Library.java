package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class Library {
  private ArrayList<Document> documents = new ArrayList<>();
  private ArrayList<User> users = new ArrayList<>();
  private Scanner scanner = new Scanner(System.in);

  public void showMenu() {
    int choice;
    do {
      System.out.println("Welcome to My Library!");
      System.out.println("[0] Exit");
      System.out.println("[1] Add Document");
      System.out.println("[2] Remove Document");
      System.out.println("[3] Update Document");
      System.out.println("[4] Find Document");
      System.out.println("[5] Display Documents");
      System.out.println("[6] Add User");
      System.out.println("[7] Borrow Document");
      System.out.println("[8] Return Document");
      System.out.println("[9] Display User Info");
      System.out.print("Choose an option: ");
      choice = scanner.nextInt();
      scanner.nextLine(); // Clear buffer

      switch (choice) {
        case 0:
          System.out.println("Goodbye!");
          break;
        case 1:
          addDocument();
          break;
        case 2:
          removeDocument();
          break;
        case 3:
          updateDocument();
          break;
        case 4:
          findDocument();
          break;
        case 5:
          displayDocuments();
          break;
        case 6:
          addUser();
          break;
        case 7:
          borrowDocument();
          break;
        case 8:
          returnDocument();
          break;
        case 9:
          displayUserInfo();
          break;
        default:
          System.out.println("Action is not supported");
      }
    } while (choice != 0);
  }

  private void addDocument() {
    System.out.print("Enter document title: ");
    String title = scanner.nextLine();
    System.out.print("Enter document author: ");
    String author = scanner.nextLine();
    Document document = new Document(title, author);
    documents.add(document);
    System.out.println("Document added successfully!");
  }

  private void removeDocument() {
    System.out.print("Enter document title to remove: ");
    String title = scanner.nextLine();
    Document document = findDocumentByTitle(title);
    if (document != null) {
      documents.remove(document);
      System.out.println("Document removed successfully!");
    } else {
      System.out.println("Document not found.");
    }
  }

  private void updateDocument() {
    System.out.print("Enter document title to update: ");
    String title = scanner.nextLine();
    Document document = findDocumentByTitle(title);
    if (document != null) {
      System.out.print("Enter new title: ");
      String newTitle = scanner.nextLine();
      System.out.print("Enter new author: ");
      String newAuthor = scanner.nextLine();
      document.setTitle(newTitle);
      document.setAuthor(newAuthor);
      System.out.println("Document updated successfully!");
    } else {
      System.out.println("Document not found.");
    }
  }

  private void findDocument() {
    System.out.print("Enter document title to find: ");
    String title = scanner.nextLine();
    Document document = findDocumentByTitle(title);
    if (document != null) {
      document.printInfo();
    } else {
      System.out.println("Document not found.");
    }
  }

  private Document findDocumentByTitle(String title) {
    for (Document doc : documents) {
      if (doc.getTitle().equalsIgnoreCase(title)) {
        return doc;
      }
    }
    return null;
  }

  private void displayDocuments() {
    if (documents.isEmpty()) {
      System.out.println("No documents available.");
    } else {
      System.out.println("Documents in library:");
      for (Document doc : documents) {
        doc.printInfo();
      }
    }
  }

  private void addUser() {
    System.out.print("Enter user name: ");
    String name = scanner.nextLine();
    User user = new User(name);
    users.add(user);
    System.out.println("User added successfully!");
  }

  private void borrowDocument() {
    System.out.print("Enter user name: ");
    String userName = scanner.nextLine();
    User user = findUserByName(userName);
    if (user == null) {
      System.out.println("User not found.");
      return;
    }

    System.out.print("Enter document title to borrow: ");
    String title = scanner.nextLine();
    Document document = findDocumentByTitle(title);
    if (document != null) {
      user.borrowDocument(document);
      System.out.println("Document borrowed successfully!");
    } else {
      System.out.println("Document not found.");
    }
  }

  private void returnDocument() {
    System.out.print("Enter user name: ");
    String userName = scanner.nextLine();
    User user = findUserByName(userName);
    if (user == null) {
      System.out.println("User not found.");
      return;
    }

    System.out.print("Enter document title to return: ");
    String title = scanner.nextLine();
    Document document = findDocumentByTitle(title);
    if (document != null && user.getBorrowedDocuments().contains(document)) {
      user.returnDocument(document);
      System.out.println("Document returned successfully!");
    } else {
      System.out.println("Document not found or not borrowed by this user.");
    }
  }

  private void displayUserInfo() {
    System.out.print("Enter user name: ");
    String name = scanner.nextLine();
    User user = findUserByName(name);
    if (user != null) {
      user.printUserInfo();
    } else {
      System.out.println("User not found.");
    }
  }

  private User findUserByName(String name) {
    for (User user : users) {
      if (user.getName().equalsIgnoreCase(name)) {
        return user;
      }
    }
    return null;
  }
}

