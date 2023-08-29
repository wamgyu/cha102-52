package web.booking.util;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter

public class MyObject {
    @SerializedName("bookingno")
    private Integer bookingNumber;
//    private Integer memno;
//    private Integer bookingstate;
//    private Date bookingdate;
}
