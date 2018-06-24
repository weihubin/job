package com.finrun.trading.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by weihubin on 2018-05-25.
 */
@Mapper
public interface CtpDepthMarketDataMapper<T> {
    /**
     * 新增行情数据
     * @param t
     * @return
     */
    int insert(T t);
}
