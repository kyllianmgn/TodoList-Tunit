import java.util.ArrayList;

public class ToDoList{
    private ArrayList<Item> itemList;

    public void addItem(Item item){
        try{
            if (itemList.size() <= 10){
                itemList.add(item);
            }else{
                throw new ItemListFullException();
            }
        } catch (ItemListFullException e) {
            throw new RuntimeException(e);
        }
    }
}
