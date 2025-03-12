package Repository;

import Domain.Entity;
import Repository.Exceptions.RepositoryExceptions;
import Repository.Exceptions.RepositoryExceptions.EntityNotFoundException;

import java.sql.DataTruncation;
import java.util.ArrayList;
import java.util.List;

public class InMemoryRepository<T extends Entity> implements GenericRepository<T> {
    protected final List<T> items = new ArrayList<>();

    @Override
    public void add(T item) {
        if(getByID(item.getId()) == null) {
            items.add(item);
        }
        else {
            throw new RuntimeException("Duplicate Id");
        }
    }

    @Override
    public void deleteByID(int ID) {
        boolean removed = items.removeIf(entity -> entity.getId() == ID);
        if(!removed) {
            throw new EntityNotFoundException("The item was not found!!");
        }
    }

    @Override
    public boolean updateByID(int ID, T updatedItem) {
        T searchedItem = getByID(ID);
        if(searchedItem != null) {
            searchedItem.updateFrom(updatedItem);
            return true;
        }
        return false;  // Product not found
    }

    @Override
    public T getByID(int ID) {
        for(T item : items) {
            if(item.getId() == ID) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<T> getAll() {
        return new ArrayList<>(items);
    }
}
