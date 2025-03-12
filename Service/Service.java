package Service;

import Domain.Order;
import Domain.Product;
import Repository.InMemoryRepository;

import java.util.List;

public class Service {
    private final InMemoryRepository<Order> ordersRepository;
    private final InMemoryRepository<Product> productsRepository;

    public Service(InMemoryRepository<Order> givenOrdersRepository, InMemoryRepository<Product> givenProductsRepository) {
        this.ordersRepository = givenOrdersRepository;
        this.productsRepository = givenProductsRepository;
    }

    //=======================Product functions===========================
    public void addProduct(Product product){
        productsRepository.add(product);
    }
    public boolean updateProduct(int ID, Product product){
        return productsRepository.updateByID(ID, product);
    }
    public void deleteProductByID(int ID){
        productsRepository.deleteByID(ID);
    }
    public Product getProductByID(int ID){
        return productsRepository.getByID(ID);
    }
    public List<Product> getAllProducts(){
        return productsRepository.getAll();
    }


    //=======================Order functions===========================
    public void addOrder(Order order){
        ordersRepository.add(order);
    }
    public boolean updateOrder(int ID, Order order){
        return ordersRepository.updateByID(ID, order);
    }
    public void deleteOrderByID(int ID){
        ordersRepository.deleteByID(ID);
    }


    public List<Order> getAllOrders(){
        return ordersRepository.getAll();
    }

}
