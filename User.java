package org.example;

import java.util.ArrayList;

public class User {
  private String name;
  private ArrayList<Document> borrowedDocuments;

  public User(String name) {
    this.name = name;
    this.borrowedDocuments = new ArrayList<>();
  }

  public String getName() {
    return name;
  }

  public ArrayList<Document> getBorrowedDocuments() {
    return borrowedDocuments;
  }

  public void borrowDocument(Document document) {
    borrowedDocuments.add(document);
  }

  public void returnDocument(Document document) {
    borrowedDocuments.remove(document);
  }

  public void printUserInfo() {
    System.out.println("User: " + name);
    System.out.println("Borrowed Documents:");
    for (Document doc : borrowedDocuments) {
      doc.printInfo();
    }
  }
}
