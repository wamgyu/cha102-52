package web.emp.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serial;
import java.io.Serializable;

@Entity(name = "FUNCTION")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FuncVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "FUNC_NO")
    private String funcNo;
    @Column(name = "FUNC_NAME")
    private String funcName;

}
