package top.ingxx.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/***
 * 分页VO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageVo {
    //总记录数
    private long total;
    //当前页面数据
    private List rows;
}
