package product.model;

public class Cart {
    private int id;
    private String name;
    private int quantity;
    private String productName;
    private String status;

    public Cart(int id, String name, int quantity,String productName,String status) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.productName = productName;
        this.status = status;
    }

    public Cart() {
    }

    public Cart(String raw) {
        String [] strings = raw.split(";");
        this.id = Integer.parseInt(strings[0]);
        this.name = strings[1];
        this.quantity = Integer.parseInt(strings[2]);
        this.productName = strings[3];
        this.status = strings[4];
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return id + ";" + name+";" +quantity+";" +productName+";" +status;
    }
}
