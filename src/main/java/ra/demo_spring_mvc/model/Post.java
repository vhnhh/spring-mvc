package ra.demo_spring_mvc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {
    private Integer id;
    private String author, title, content, imgUrl;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date time;
}
