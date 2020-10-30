package com.pattern.factory;

import java.util.Objects;

/**
 * 简单工厂
 */
public class SingleFactoryPattern {

    public static void main(String[] args) {
        int productType = 0;
        System.out.println("============");
        Product product = SimpleFactory.makeProduct(productType);
        if (Objects.nonNull(product)){
            product.show();
        }
        System.out.println("============");
    }

    public interface  Product{
        void show();
    }

    static class ConcreteProduct1 implements Product{
        public void show() {
            System.out.println("产品1展示------");
        }
    }

    static class ConcreteProduct2 implements Product{
        public void show(){
            System.out.println("产品2展示------");
        }
    }

    final class Const{
        static final int PRODUCT_A = 0;
        static final int PRODUCT_B = 1;
    }

    static class SimpleFactory{
        public static Product makeProduct(int type){
            Product product = null;
            switch (type){
                case Const.PRODUCT_A:
                    product = new ConcreteProduct1();
                    break;
                case Const.PRODUCT_B:
                    product = new ConcreteProduct2();
                    break;
            }
            return product;
        }
    }


}
