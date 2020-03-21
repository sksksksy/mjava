package zhp.win.mybatis;

import org.apache.ibatis.annotations.Mapper;
import zhp.win.entity.User;

import java.util.List;

@Mapper
public interface UserMybatits {
    public List<User> select();
}
