package boying.domain.book;

import boying.domain.BaseModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString
@EqualsAndHashCode
public class Video extends BaseModel{
    private long id;
    private String name;
    private String publisherName;
    private VideoType type;
    private StateCode stateCode;
}

