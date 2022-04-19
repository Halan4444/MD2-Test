package product.model;

public class Cart {
    private int id;
    private int quantity;

    public Cart(int id, int quantity) {
        this.id = id;
        this.quantity = quantity;

    }

    public Cart() {
    }

    public Cart(String raw) {
        String [] strings = raw.split(";");
        this.id = Integer.parseInt(strings[0]);
        this.quantity = Integer.parseInt(strings[1]);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void getQuantity(int currentQuantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return id + ";" + quantity;
    }
}
