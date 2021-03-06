package pl.sdacademy.vending.model;


import java.util.LinkedList;
import java.util.Queue;

public class Tray {
    private String symbol;
    private Long price;
    private Queue<Product> products;


    private Tray(Builder builder) {
        this.symbol = builder.symbol;
        this.price = builder.price;
        this.products = builder.products;

    }

    public static Builder builder(String symbol){
        return new Builder(symbol);
    }

    public String getSymbol() {
        return symbol;

    }


    public Long getPrice() {
        return price;
    }



    public static class Builder {
        private String symbol;
        private Long price;
        private Queue<Product> products;

        private Builder(String symbol) {
            if (symbol ==null){
                throw new IllegalArgumentException("Tray symbol cannot be null");
            }
            this.symbol = symbol;
            this.products = new LinkedList();


        }

        public Builder price (Long price) {
            this.price = price;
            return this;
        }
        public Builder product (Product product) {
            this.products.add(product);
            return this;
        }

        public Tray build() {
            if (price ==null){
                price = 990L;
            }
            return new Tray(this);
        }

    }
}
