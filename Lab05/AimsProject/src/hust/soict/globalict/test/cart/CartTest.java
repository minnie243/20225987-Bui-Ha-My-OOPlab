package hust.soict.globalict.test.cart;

import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.media.DigitalVideoDisc;

public class CartTest {
    public CartTest() {
    }

    public static void main(String[] var0) {
        Cart var1 = new Cart();
        DigitalVideoDisc var2 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95F);
        var1.addMedia(var2);
        DigitalVideoDisc var3 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95F);
        var1.addMedia(var3);
        DigitalVideoDisc var4 = new DigitalVideoDisc("Aladin", "Animation","Grim", 90,18.99F);
        var1.addMedia(var4);
        var1.print();
        var1.searchByID(2);
        var1.searchByTitle("lion meow meow");
    }
}