import java.util.ArrayList;

public class ToDoList{
    private ArrayList<Item> itemList;
    private EmailSenderService emailSenderService;

    public void addItem(Item item){
        try{
            if (itemList.size() <= 10){
                itemList.add(item);
                if (itemList.size() == 8){
                    this.emailSenderService.sendEmail();
                }
            }else{
                throw new ItemListFullException();
            }
        } catch (ItemListFullException e) {
            throw new RuntimeException(e);
        }
    }
}
