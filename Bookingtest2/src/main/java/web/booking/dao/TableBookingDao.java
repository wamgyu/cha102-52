package web.booking.dao;

import core.coreDAO.CoreDao;
import org.jetbrains.annotations.NotNull;
import web.booking.vo.BookingVo;
import web.booking.vo.TableBookingVo;

import java.sql.Date;
import java.util.List;

public interface TableBookingDao extends CoreDao<TableBookingVo, Integer> {


    Integer updateById(@NotNull TableBookingVo newtablebook);
    public List<TableBookingVo> SelectByChoose(Date date, int tableno);
    public TableBookingVo updateByState(Integer stateNo,Date bookDate,Integer tableNo);
    public Integer test(TableBookingVo tableBookingVo);

}
