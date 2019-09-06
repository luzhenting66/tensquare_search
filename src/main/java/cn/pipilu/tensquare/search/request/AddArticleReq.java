package cn.pipilu.tensquare.search.request;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class AddArticleReq implements Serializable{

    private static final long serialVersionUID = 1859039320551521406L;
    private String content;
    private String title;
}
