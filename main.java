import Config.SettingsManager;
import Domain.Order;
import Domain.OrderConverter;
import Domain.Product;
import Domain.ProductConverter;
import Repository.InMemoryRepository;
import Repository.RepositoryFactory;
import Service.Service;
import Ui.Ui;

import java.time.LocalDate;
import java.util.List;

public class main {
    public static void main(String[] args) {
        // Charging settings from a settings file
        SettingsManager settings = new SettingsManager("Config\\settings.properties");

        // Creating the Repository factory
        RepositoryFactory factory = new RepositoryFactory(settings);

        // Instantiation the Repository
        InMemoryRepository<Product> productsRepository = factory.createRepository("Products", new ProductConverter());
        InMemoryRepository<Order> orderRepository = factory.createRepository("Orders", new OrderConverter());

        // Creating some product examples
        Product givenProduct1 = new Product("CocaCola", "Food", 2);
        Product givenProduct2 = new Product("Iphone16", "Technology", 3);
        Product givenProduct3 = new Product("Sofa", "Furniture", 10);
        Product givenProduct4 = new Product("Batman", "Entertainment", 10);
        Product givenProduct5 = new Product("Matilda", "Books", 10);

        productsRepository.add(givenProduct1);
        productsRepository.add(givenProduct2);
        productsRepository.add(givenProduct3);
        productsRepository.add(givenProduct4);
        productsRepository.add(givenProduct5);

        // Creating some order examples
        List<Integer> products1 = List.of(givenProduct1.getID(), givenProduct1.getID(), givenProduct2.getID());
        List<Integer> products2 = List.of(givenProduct3.getID(), givenProduct4.getID());
        List<Integer> products3 = List.of(givenProduct5.getID(), givenProduct5.getID());

        Order order1 = new Order(LocalDate.of(2024, 12, 12), products1);
        Order order2 = new Order(LocalDate.of(2024, 12, 11), products2);
        Order order3 = new Order(LocalDate.of(2024, 12, 10), products3);

        orderRepository.add(order1);
        orderRepository.add(order2);
        orderRepository.add(order3);

        // Creating service and user interface
        Service orderProductService = new Service(orderRepository, productsRepository);
        Ui ui = new Ui(orderProductService);

        // Start the user interface
        ui.start();
    }
}
