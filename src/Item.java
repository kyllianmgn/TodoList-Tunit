import lombok.Getter;

import java.time.LocalDate;

@Getter
public class Item {
    private String name;
    private String content;
    private LocalDate creationDate;

    public Item(String name, String content, LocalDate creationDate) {
        this.name = name;
        checkContent(content);
        this.content = content;
        this.creationDate = creationDate;
    }

    public void checkContent(String content) {
        if (content == null || content.isEmpty()) {
            throw new IllegalArgumentException("Content isn't valid.");
        }
        if (content.length() > 1000) {
            throw new IllegalArgumentException("Content length's is over 1000.");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContent(String content) {
        checkContent(content);
        this.content = content;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
