package lib.models;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

@Table(name = "Book")
@Entity
public class Book {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookID;

    @NotEmpty(message = "Название не должно быть пустым")
    @Size(min = 2, max = 60, message = "Название книги должно быть между 2 и 30 символами")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Имя автора не должно быть пустым")
    @Size(min = 2, max = 50, message = "Имя автора должно быть между 2 и 50 символами")
    @Column(name = "author")
    private String author;

    @Min(value = 0, message = "Год книги должен быть введен")
    @Column(name = "year")
    private int year;

    @Column(name = "taked_at")
    @Temporal(TemporalType.TIMESTAMP)
    private Date takedAt;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person owner;

    @Transient
    private boolean isExpired;

    public Book() {
    }

    public Book(int bookID, String name, String author, int year) {
        this.bookID = bookID;
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public Person getOwner() {
        return owner;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public Date getTakedAt() {
        return takedAt;
    }

    public void setTakedAt(Date takedAt) {
        this.takedAt = takedAt;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public void setExpired(boolean expired) {
        isExpired = expired;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                '}';
    }
}
