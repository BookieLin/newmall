package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Author:vincent
 * @Description:
 * @Date:Create in 下午 8:48 2018/1/5 0005
 */
public interface DaoMapper<T>  extends Mapper<T>,MySqlMapper<T> {
}
