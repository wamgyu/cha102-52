package web.booking.dao;

import org.hibernate.Session;
import org.jetbrains.annotations.NotNull;
import web.booking.vo.GameTableVo;

import java.util.List;

public class GameTableDaoImpl implements GameTableDao{

    @Override
    public Integer insert(GameTableVo gametablevo){
        getSession().persist(gametablevo);
        return 1;
    }

    @Override
    public Integer deleteById(Integer tableno){
        GameTableVo gametablevo = getSession().get(GameTableVo.class, tableno);
        getSession().remove(gametablevo);
        return -1;
    }
    @Override
    public Integer update(GameTableVo gametablevo) {
        try {
            getSession().merge(gametablevo);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }
    @Override
    public Integer updateById(@NotNull GameTableVo newgametablevo){
        Session session = getSession();
        GameTableVo oldgametablevo = session.get(GameTableVo.class, newgametablevo.getTableno());
        try{
            final Integer table = newgametablevo.getTableno();
            if(table != null){
                oldgametablevo.setTableno(table);
            }

            final Integer type = newgametablevo.getTabletype();
            if(type != null){
                oldgametablevo.setTabletype(type);
            }
            return  1;
        }catch(Exception e){
            e.printStackTrace();
            return  -1;
        }
    }

//不知道為何一定要import Object類別
    @Override
    public Object insert(Object o) {
        return null;
    }

    @Override
    public Object deleteById(Object id) {
        return null;
    }

    @Override
    public Object update(Object o) {
        return null;
    }

    @Override
    public List<GameTableVo> selectAll(){
        final String hql = "FROM GameTableVo ORDER BY tableno";
        return getSession().createQuery(hql, GameTableVo.class).getResultList();
    }
}
