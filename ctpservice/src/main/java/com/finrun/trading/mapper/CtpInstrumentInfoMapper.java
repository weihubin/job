package com.finrun.trading.mapper;

import com.finrun.trading.model.CtpInstrumentInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by weihubin on 2018-05-29.
 */
@Mapper
public interface CtpInstrumentInfoMapper<T> {
    /**
     * 新增合约信息
     * @param t
     * @return
     */
    int insert(T t);

    /**
     * 删除数据库所有记录
     * @return
     */
    int deleteAll();

    /**
     * 根据合约id 查找合约
     * @param t
     * @return
     */
    CtpInstrumentInfo qryInstrumentInfoById(T t);
}
