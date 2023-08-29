package web.mem.dao;

import core.coreDAO.CoreDao;
import web.mem.vo.MemVo;

public interface MemDao extends CoreDao<MemVo, Integer> {
    boolean updateById(MemVo newMemVo);
    MemVo selectByMemName(String memName);
//    MemVo selectForLogin(String memName, String memPwd);
}
