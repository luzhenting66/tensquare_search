package cn.pipilu.tensquare.search.response;

import cn.pipilu.tensquare.search.pojo.ArticleEntity;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

@Data
@ToString
public class QueryArticleResp implements Serializable {

    private static final long serialVersionUID = -3318661163309466508L;

    private List<ArticleEntity> data;
    private long total;
    private int size;
    private int totalPage;
}
