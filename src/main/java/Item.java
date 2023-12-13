import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Item {
    private String name;
    private String content;
    private LocalDate creationDate;

    public Item(String name, String content) {
        this.name = name;
        this.content = content;
        this.creationDate = LocalDate.now();
    }

    public boolean checkContent() {
        if (this.content == null || this.content.isEmpty()) {
            throw new IllegalArgumentException("Content isn't valid.");
        }
        if (this.content.length() > 1000) {
            throw new IllegalArgumentException("Content length's is over 1000.");
        }
        return true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        checkContent();
        this.content = content;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
