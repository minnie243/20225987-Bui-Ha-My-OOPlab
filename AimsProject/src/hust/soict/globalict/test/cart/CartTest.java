package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.DigitalVideoDisc;
public class CartTest{
    public static void main(String[] args) {
        //create a new cart
        Cart cart = new Cart();

        //create a new dvd
        Media dvd1 = new Media("The Lion King", "Animation", 19.95f);
        //add the dvd to the cart
        cart.addMedia(dvd1);

        Media dvd2 = new Media("Star Wars", "Science Fiction", 24.95f);
        cart.addMedia(dvd2);

        Media dvd3 = new Media("Aladdin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        //Test the print method
        cart.print();

        //Test the search method
        cart.searchByID(2);
        cart.searchByTitle("lion meow meow");
    }
}