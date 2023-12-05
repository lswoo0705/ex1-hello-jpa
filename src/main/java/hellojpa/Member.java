package hellojpa;

import jakarta.persistence.*;

@Entity
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 50)

public class Member {
    @Id
    @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;
    @Column(name = "USERNAME")
    private String username;
//    @Column(name = "TEAM_ID")
//    private Long teamId;

    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

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
