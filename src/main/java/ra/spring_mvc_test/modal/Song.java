package ra.spring_mvc_test.modal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Song {
    private Integer duration;
    private String id, name, author, description, imgUrl, vidUrl;
    private boolean status;
}
