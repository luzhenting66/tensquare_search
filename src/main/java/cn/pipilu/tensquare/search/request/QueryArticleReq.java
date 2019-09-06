package cn.pipilu.tensquare.search.request;

import cn.pipilu.plus.common.validate.Validate;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@ToString
public class QueryArticleReq implements Serializable{

    private static final long serialVersionUID = -4702893127605343479L;
    @Validate(nullable = false,desc = "关键字缺失")
    private String keyword;
    private int pageNo;
    private int pageSize;
}
