package cse213.midautumn;

public class Product {
    private String name;
    private int id;
    private String material;
    private String quantity;

    public Product(String name, int id, String material, String quantity) {
        this.name = name;
        this.id = id;
        this.material = material;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", material='" + material + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
