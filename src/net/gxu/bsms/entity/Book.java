package net.gxu.bsms.entity;

/**
 *  实体类 书籍
 */
public class Book {
    private int id;
    private String name;
    private String author;
    private String publish;
    private float price;
    private int amount;

    public Book() {
    }

    public Book(int id, String name, String author, String publish, float price) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.price = price;
    }

    public Book(int id, String name, String author, String publish, float price, int amount) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.publish = publish;
        this.price = price;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", publish='" + publish + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getPublish() {
        return publish;
    }

    public void setPublish(String publish) {
        this.publish = publish;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
