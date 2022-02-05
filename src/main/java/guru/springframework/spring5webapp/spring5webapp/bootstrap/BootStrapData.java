package guru.springframework.spring5webapp.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book( "Domain Driven Design", "123123");
        Publisher badBooks = new Publisher("Book Shop", "An Address");
        eric.getBooks().add(ddd);
        ddd.getAuthor().add(eric);


        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(badBooks);


        Author rod = new Author("Rod", "Johnson");
        Book noEJ8 = new Book("J2EE Development without EJB", "321321");

        rod.getBooks().add(noEJ8);
        noEJ8.getAuthor().add(rod);

        authorRepository.save(rod);
        bookRepository.save(noEJ8);

        System.out.println("Started in BootStrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());
    }
}
