package soap.common;

/**
 * Created by ZhangPY on 2020/3/5
 * Belong Organization OVERUN-9299
 * overun9299@163.com
 * Explain:
 */
public interface UserService {

    /**
     * 通过id获取用户信息
     * @param id
     * @return
     */
    public User getUserIfoById(Integer id);
}
