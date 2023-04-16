package bg.softuni.pizzashop.model.view;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class CommentView {

    private Long id;
    private String text;
    private String authorName;
    private LocalDateTime createTime;
}
