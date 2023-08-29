package web.booking.dao;

import core.coreDAO.CoreDao;
import org.jetbrains.annotations.NotNull;
import web.booking.vo.GameTableVo;
import web.booking.vo.TableBookingVo;

public interface GameTableDao extends CoreDao {
    Integer insert(GameTableVo gametablevo);

    Integer deleteById(Integer tableno);

    Integer update(GameTableVo gametablevo);

    Integer updateById(@NotNull GameTableVo newgametablevo);

}
