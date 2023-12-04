package hellojpa;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Member {
    @Id
    private Long id;
//    @Column(unique = true, length = 10) // DDL 생성 기능
    @Column(name = "name", nullable = false)
    private String username;
    private int age;
    @Enumerated(EnumType.STRING) // ORDINARY 사용하면 혼동 위험이 있으니 사용하지 말것
    private RoleType roleType;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date LastModifiedDate;
    private LocalDate testLocalDate; // 년, 월, 일
    private LocalDateTime testLocalDateTime; // 년, 월, 일, 시각
    @Lob // 매핑하는 필드 타입이 문자면 CLOB 매핑, 나머지는 BLOB 매핑
    private String description;
    @Transient // DB에 관계없이 메모리에만 사용하고 싶을 때
    private int temp;

    public Member() {
    }

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return LastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        LastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
