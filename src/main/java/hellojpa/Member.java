package hellojpa;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
    @ManyToOne
    @JoinColumn(name = "TEAM_ID", insertable = false, updatable = false) // 읽기 전용 필드를 사용해서 양방향처럼 사용
    private Team team;
//    @OneToOne
//    @JoinColumn(name = "LOCKER_ID")
//    private Locker locker;
//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    //    private int age;
//    @Enumerated(EnumType.STRING) // ORDINARY 사용하면 혼동 위험이 있으니 사용하지 말것
//    private RoleType roleType;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date LastModifiedDate;
//    private LocalDate testLocalDate; // 년, 월, 일
//    private LocalDateTime testLocalDateTime; // 년, 월, 일, 시각
//    @Lob // 매핑하는 필드 타입이 문자면 CLOB 매핑, 나머지는 BLOB 매핑
//    private String description;
//    @Transient // DB에 관계없이 메모리에만 사용하고 싶을 때
//    private int temp;
}
