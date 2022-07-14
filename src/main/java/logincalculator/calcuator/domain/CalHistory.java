package logincalculator.calcuator.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity
@NoArgsConstructor
public class CalHistory {
    @Id
    @GeneratedValue
    @Column(name="history_id")
    private Long id;

    private String formula;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="member_id")
    @JsonIgnore
    private Member member;
}
