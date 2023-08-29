package web.mem.vo;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.sql.Date;


@Entity(name = "MEMBER")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MEM_NO", insertable = false, updatable = false)
    private Integer memNo;
    @Column(name = "MEM_NAME", updatable = false)
    private String memName;
    @Column(name = "MEM_PID", updatable = false)
    private String memPid;
    @Column(name = "MEM_GENDER", updatable = false)
    private Byte memGender;
    @Column(name = "MEM_PIC", insertable = false)
    private Byte[] memPic;
    @Column(name = "MEM_EMAIL")
    private String memEmail;
    @Column(name = "MEM_PWD")
    private String memPwd;
    @Column(name = "MEM_PH")
    private String memPh;
    @Column(name = "MEM_ADDRS")
    private String memAddress;
    @Column(name = "MEM_BIRTH", updatable = false)
    private Date memBirth;
    @Column(name = "MEM_AUTH")
    private Byte memAuth;
    @Column(name = "MEM_VIO")
    private Byte memVio;

}
