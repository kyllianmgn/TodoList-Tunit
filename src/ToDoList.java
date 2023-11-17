import java.util.ArrayList;

import static java.time.temporal.ChronoUnit.MINUTES;

public class ToDoList {
    private ArrayList<Item> itemList;
    static EmailSenderService emailSenderService;

    public ToDoList(User user) throws InstantiationException {
        if (user.isValid()) {
            itemList = new ArrayList<>();
        } else {
            throw new InstantiationException("User not valid");
        }
    }

    public void addItem(Item item, User user) {
        try {
            if (itemList.size() <= 10 && user.isValid()) {
                itemList.add(item);
                if (itemList.size() == 8) {
                    emailSenderService.sendEmail(user.getEmail());
                }
            } else {
                throw new ItemListFullException();
            }
        } catch (ItemListFullException e) {
            throw new RuntimeException(e);
        }
    }

    public void save() {
        //sauvegarde en bdd
        throw new RuntimeException();
    }
}
