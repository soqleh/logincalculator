package logincalculator.calcuator.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @NotEmpty
    private String userId;
    @NotEmpty
    private String userRealName;
    @NotEmpty
    private String pw;
    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private List<CalHistory> historyList;

}
