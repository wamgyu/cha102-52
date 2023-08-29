package web.mem.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jetbrains.annotations.NotNull;
import web.mem.vo.MemVo;

import java.util.List;

public class MemDaoImpl implements MemDao {

    public Integer insert(MemVo memVo) {
        getSession().persist(memVo);
        return 1;
    }

    public Integer deleteById(Integer memNo) {
        MemVo memVo = getSession().get(MemVo.class, memNo);
        getSession().remove(memVo);
        return -1;
    }
    public Integer update(MemVo memVo){
        try{
            getSession().merge(memVo);
            return 1;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }
    }
    public boolean updateById(@NotNull MemVo newMemVo) {
        Session session = getSession();
        MemVo oldMemVO = session.get(MemVo.class, newMemVo.getMemNo());
        try {
            final String name = newMemVo.getMemName();
            if (name != null) {
                oldMemVO.setMemName(name);
            }
            final Byte[] pic = newMemVo.getMemPic();
            if (pic != null) {
                oldMemVO.setMemPic(pic);
            }
            final String email = newMemVo.getMemEmail();
            if (email != null) {
                oldMemVO.setMemEmail(email);
            }
            final String password = newMemVo.getMemPwd();
            if (password != null) {
                oldMemVO.setMemPwd(password);
            }
            final String phone = newMemVo.getMemPh();
            if (phone != null) {
                oldMemVO.setMemPh(phone);
            }
            final String address = newMemVo.getMemAddress();
            if (address != null) {
                oldMemVO.setMemAddress(address);
            }
            final Byte authority = newMemVo.getMemAuth();
            if (authority != null) {
                oldMemVO.setMemAuth(authority);
            }
            final Byte violation = newMemVo.getMemVio();
            if (violation != null) {
                oldMemVO.setMemVio(violation);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<MemVo> selectAll() {
        final String hql = "FROM MemVo ORDER BY memNo";
        return getSession().createQuery(hql, MemVo.class).getResultList();
    }
    public MemVo selectByMemName(String memName){
        final String hql = "FROM MemVo WHERE memName = :memName";
        return getSession().createQuery(hql, MemVo.class)
                .setParameter("memName", memName)
                .uniqueResult();
    }

//    public  MemVo selectForLogin(String memName, String memPwd){
//    }

}
