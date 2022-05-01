package com.yu.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yu.app.pojo.GoodsProperty;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface GoodsPropertyMapper extends BaseMapper<GoodsProperty> {
    @Update("UPDATE goods_property SET is_default = 0 ;")
    void resetIsDefault();

}
