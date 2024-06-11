package pe.edu.upc.gift_service.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "ProductImageDetail")
public class ProductImageDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProductImageDetail;
    @Column(name = "imageRoute", nullable = false)
    private String imageRoute;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product products;

    public ProductImageDetail() {
    }

    public ProductImageDetail(int idProductImageDetail, String imageRoute, Product products) {
        this.idProductImageDetail = idProductImageDetail;
        this.imageRoute = imageRoute;
        this.products = products;
    }

    public int getIdProductImageDetail() {
        return idProductImageDetail;
    }

    public void setIdProductImageDetail(int idProductImageDetail) {
        this.idProductImageDetail = idProductImageDetail;
    }

    public String getImageRoute() {
        return imageRoute;
    }

    public void setImageRoute(String imageRoute) {
        this.imageRoute = imageRoute;
    }

    public Product getProducts() {
        return products;
    }

    public void setProducts(Product products) {
        this.products = products;
    }
}
