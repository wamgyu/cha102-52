package web.booking.service;

import core.coreService.CoreService;
import web.booking.vo.TableBookingVo;

import java.sql.Date;
import java.util.List;

public interface BookingChooseService extends CoreService {
    List<TableBookingVo> selectByDate(Date date, int tableno);
    //更新狀態
    TableBookingVo selectByState(Integer stateNo,Date bookDate,Integer tableNo);
}
