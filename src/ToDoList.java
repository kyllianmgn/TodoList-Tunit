import java.util.ArrayList;

public class ToDoList{
    private ArrayList<Item> itemList;
    static EmailSenderService emailSenderService;

    public ToDoList(User user) throws InstantiationException{
        if (user.isValid()){
            itemList = new ArrayList<Item>();
        }else{
            throw new InstantiationException("User not valid");
        }
    }

    public void addItem(Item item){
        try{
            if (itemList.size() <= 10){
                itemList.add(item);
                if (itemList.size() == 8){
                    emailSenderService.sendEmail();
                }
            }else{
                throw new ItemListFullException();
            }
        } catch (ItemListFullException e) {
            throw new RuntimeException(e);
        }
    }
}
