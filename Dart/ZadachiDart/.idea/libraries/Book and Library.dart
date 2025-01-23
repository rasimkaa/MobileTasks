class Book {
  String title;
  String author;
  int year;

  Book(this.title, this.author, this.year);
}

class Library {
  List<Book> books = [];

  void addBook(Book book) {
    books.add(book);
  }

  List<Book> findByAuthor(String author) {
    return books.where((book) => book.author == author).toList();
  }

  List<Book> findByYear(int year) {
    return books.where((book) => book.year == year).toList();
  }
}

void main() {
  Library library = Library();
  library.addBook(Book('Девушка с татуировкой дракона', 'Стиг Ларссон', 2005));
  library.addBook(Book('1984', 'Джордж Оруэлл', 1949));

  var booksByOrwell = library.findByAuthor('Джордж Оруэлл');
  for (var book in booksByOrwell) {
    print('Книга: ${book.title}, Автор: ${book.author}');
  }
}
