package com.github.dingey.auth;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
public class AuthPager<T> {
    private int pageNum;
    private int pageSize;
    private List<T> list;
    private long total;
    private int startRow;
    private int endRow;
    private int pages;
    private int prePage;
    private int nextPage;
    private int[] navigatepageNums;

    @SuppressWarnings("unchecked")
    public static <E> AuthPager of(E e) {
        AuthPager pager = new AuthPager();
        BeanUtils.copyProperties(e, pager);
        return pager;
    }
}
