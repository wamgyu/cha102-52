package web.booking.vo;

import core.Core;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="bookinglist")
public class BookingListVo extends Core {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOOKING_NO", insertable = false)
    private Integer bookingno;
    @Column(name = "TABLE_NO")
    private  Integer tableno;
    @Column(name = "BOOKING_CHECK_STATE", insertable = false)
    private  Integer bookingcheckstate;
    @Column(name = "NOTE_OTHER")
    private  String noteother;
    @Column(name = "PERIOD_TIME")
    private  Integer periodtime;
    @Column(name= "BOOK_DATE")
    private Date bookdate;
}

