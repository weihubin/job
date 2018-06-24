package com.finrun.trading.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by weihubin on 2018-05-30.
 */
@Mapper
public interface CtpDealMsgMapper<T> {
    /**
     * 新增
     * @param t
     * @return
     */
    int insert(T t);
}
