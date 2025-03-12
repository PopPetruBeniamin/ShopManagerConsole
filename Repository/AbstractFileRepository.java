package Repository;

import Domain.Entity;

public abstract class AbstractFileRepository<T extends Entity> extends InMemoryRepository<T> {
    protected String file;

    public AbstractFileRepository(String fileName) {
        this.file = fileName;
    }

    // Métodos abstractos para que las subclases definan el formato específico
    @Override
    public void add(T entity) {
        super.add(entity);
        writeToFile();
    }

    @Override
    public void deleteByID(int id) {
        super.deleteByID(id);
        writeToFile();
    }

    @Override
    public boolean updateByID(int ID, T updatedItem) {
        boolean itWasUpdated = super.updateByID(ID, updatedItem);
        writeToFile();
        return itWasUpdated;
    }

    protected abstract void writeToFile();

    protected abstract void loadFromFile();
}

