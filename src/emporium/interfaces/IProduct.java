package emporium.interfaces;


public interface IProduct {

    void setProductName(String name);
    String getProductName();

    void setProductDepartment(String productDepartment);
    String getProductDepartment();

    void setProductUnit(String productUnit);
    String getProductUnit();

    void setProductCod(String productCod);
    String getProductCod();

    void setProductCharacteristic(String productCharacteristic);
    String getProductCharacteristic();

    void setProductQuantity(int productQuantity);
    int getProductQuantity();

    void setProductPrice(double productPrice);
    double getProductPrice();
}
