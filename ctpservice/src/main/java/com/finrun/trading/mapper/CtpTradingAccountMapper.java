package com.finrun.trading.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * Created by weihubin on 2018-05-29.
 */
@Mapper
public interface CtpTradingAccountMapper<T> {
    /**
     * 新增
     * @param t
     * @return
     */
    int insert(T t);

    int qryCountById(@Param("brokerId")String brokerId, @Param("accountId")String accountId);

    /**
     * 根据id，字段全部更新
     * @param t
     * @return
     */
    int updateAllById(T t);

}
