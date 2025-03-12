package Repository;

import Config.SettingsManager;
import Domain.Product;
import Domain.ProductConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepositoryFactoryTest {
    private SettingsManager settings = new SettingsManager("Tests\\Resources\\settings.properties");
    private RepositoryFactory repositoryFactory = new RepositoryFactory(settings);

    @Test
    void createRepository() {
        InMemoryRepository<Product> repository = repositoryFactory.createRepository("Products", new ProductConverter());
        assertTrue(repository instanceof TextFileRepository<Product>);
    }
}