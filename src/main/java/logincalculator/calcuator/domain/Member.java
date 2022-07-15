package logincalculator.calcuator.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@NoArgsConstructor/*(access= AccessLevel.PROTECTED)*/
@Entity
@Getter @Setter
public class Member {
    @Id @GeneratedValue
    @Column(name="member_id")
    private Long id;

    @NotEmpty
    private String userName;

    @NotEmpty
    private String password;
    @OneToMany(mappedBy = "member",fetch = FetchType.LAZY)
    private List<History> historyList;
	@Builder
    public Member(Long id, String username, String password) {
        this.id = id;
        this.userName = username;
        this.password = password;
    }

}
