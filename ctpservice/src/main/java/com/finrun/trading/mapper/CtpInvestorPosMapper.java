package com.finrun.trading.mapper;

import org.apache.ibatis.annotations.Mapper;

/**
 * Created by weihubin on 2018-05-30.
 */
@Mapper
public interface CtpInvestorPosMapper<T> {
    /**
     * 新增
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 根据主键查询记录记录数
     * @param t
     * @return
     */
    int qryCountByPrimKey(T t);


    int updateAllByPrimKey(T t);

}
