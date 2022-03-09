package com.company.chap5nin;

import java.io.*;
import java.util.Date;

class Test{
    void writeObject() throws Exception{
        FileOutputStream out = new FileOutputStream("./doc/theTime");
        ObjectOutputStream s = new ObjectOutputStream(out);
        s.writeObject("Today");
        s.writeObject(new Date(2019, 12, 25));
        s.flush();
        s.close();

    }

    void readObject() throws Exception{
        FileInputStream in = new FileInputStream("./doc/theTime");
        ObjectInputStream s = new ObjectInputStream(in);
        String today = (String)s.readObject();
        Date date = (Date)s.readObject();
        System.out.println(today);
        System.out.println(date);
        s.close();
    }

    void testBook() throws Exception{
        Book book = new Book(100032, "Java Language", "Wang Sir", 30);
        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("./doc/book.dat"));
        oout.writeObject(book);
        oout.close();

        book = null;
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("./doc/book.dat"));
        book = (Book)oin.readObject();
        oin.close();
        System.out.println(book);
    }

    void testExternal() throws Exception{
        User u = new User();
        u.setName("Lucas");
        u.setPassword("32sdfs");

        ObjectOutputStream oout = new ObjectOutputStream(new FileOutputStream("./doc/user.dat"));
        oout.writeObject(u);
        oout.close();

        u = null;
        ObjectInputStream oin = new ObjectInputStream(new FileInputStream("./doc/user.dat"));
        u = (User) oin.readObject();
        oin.close();
        System.out.println(u);
    }
}

class Book implements Serializable{
    int id;
    String name;
    String author;
    float price;
    public Book(int id, String name, String author, float price){
        this.id = id;
        this.name = name;
        this.author = author;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}

class User implements Externalizable {

    private String name;
    private transient String password;

    // 必须要有无参构造器
    public User() {
        System.out.println("constructor");
    }


    // 序列化User对象， 可以在这里使用密钥加密
    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal");
        out.writeObject(name);
        out.writeObject(password);
    }

    // 反序列化User对象， 可以在这里用密钥解密
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        System.out.println("readExternal");
        name = (String) in.readObject();
        password = (String) in.readObject();
    }

    // 不会被执行
    private void writeObject(ObjectOutputStream out) throws IOException {
        System.out.println("writeObject");
    }

    // 不会被执行
    private void readObject(ObjectInputStream in) throws IOException {
        System.out.println("readObject");
    }

    // 在writeExternal之前执行，只是为了说明执行顺序，实际不需要写。
    private Object writeReplace() throws ObjectStreamException {
//        this.setName("kobe");
        System.out.println("writeReplace");
        return this;
    }

    // 在readExternal之后执行，只是为了说明执行顺序，实际不需要写。
    private Object readResolve() throws ObjectStreamException {
//        this.setName("kobe");
        System.out.println("readresolve");
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

public class Exp10 {
    public static void main(String[] args) throws Exception{
        Test t = new Test();
        t.testExternal();
    }
}
