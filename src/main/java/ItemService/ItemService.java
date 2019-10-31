package ItemService;

import Entity.Item;
import ItemDAO.ItemDAO;

import java.util.Date;

public class ItemService {
    private ItemDAO itemDAO = new ItemDAO();

    public Item save(Item item) {
        item.setDateCreated(new Date());
        item.setLastUpdatedDate(new Date());
        return itemDAO.save(item);
    }

    public Item update(Item item) {
       return itemDAO.update(item);
    }

    public Item delete(long id) {
       return itemDAO.delete(id);
    }

    public Item findById(long id) {
        return itemDAO.findById(id);
    }
}
