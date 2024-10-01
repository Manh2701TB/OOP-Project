package org.example;

public class Book extends Document {
  private String genre;

  public Book(String title, String author, String genre) {
    super(title, author);
    this.genre = genre;
  }

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }

  @Override
  public void printInfo() {
    super.printInfo();
    System.out.println("Genre: " + genre);
  }
}

