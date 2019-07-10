package sortAlgorithm;

import java.util.Comparator;

/**
 * Project Name : BasicDataStructureAndAlgorithm
 * Creator : chengjingwentang
 * Date : 2019-07-04
 * Time : 19:46
 * Description :
 */
public class Product implements Comparable<Product> {


    private int price;
    private int sale;

    public Product(int price, int sale) {
        this.price = price;
        this.sale = sale;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + price +
                ", sale=" + sale +
                '}';
    }


    @Override
    public int compareTo(Product o) {
        if (this.getSale() == o.getSale()) {
            return this.getPrice() - o.getPrice();
        }
        return this.getSale() - o.getSale();
    }
}

class ProductCompare implements Comparator<Product> {

    @Override
    public int compare(Product o1, Product o2) {
        return o1.getSale() - o2.getSale();
    }
}
