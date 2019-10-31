package ItemController;

import Entity.Item;
import ItemService.ItemService;

public class ItemController {
    private ItemService itemService = new ItemService();

    public Item save(Item item) {
        return itemService.save(item);
    }

    public Item update(Item item) {
        return itemService.update(item);
    }

    public Item delete(long id) {
        return itemService.delete(id);
    }

    public Item findById(long id) {
        return itemService.findById(id);
    }
}
