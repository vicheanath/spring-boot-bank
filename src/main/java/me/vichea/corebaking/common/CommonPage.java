package me.vichea.corebaking.common;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CommonPage<T> {
    private Integer pageNum;
    private Integer pageSize;
    private Integer totalPage;
    private Long total;
    private T data;

    public static <T> CommonPage<T> restPage(T data, Integer pageNum, Integer pageSize, Long total){
        CommonPage<T> result = new CommonPage<>();
        result.setData(data);
        result.setPageNum(pageNum);
        result.setPageSize(pageSize);
        result.setTotal(total);
        result.setTotalPage((int) Math.ceil((double) total / pageSize));
        return result;
    }

    public static <T> CommonPage<T> restPage(T data){
        CommonPage<T> result = new CommonPage<>();
        result.setData(data);
        return result;
    }

    public static <T> CommonPage<T> restPage(){
        CommonPage<T> result = new CommonPage<>();
        return result;
    }


}
