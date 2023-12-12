package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Hibernate;

import java.util.List;
import java.util.Set;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            // 멤버 등록
//            Member member = new Member();
//            member.setId(2L);
//            member.setName("helloB");
//            em.persist(member);

            // 멤버 찾기
//            Member findMember = em.find(Member.class, 1L);
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name = " + findMember.getName());

            // 멤버 삭제
//            Member findMember = em.find(Member.class, 1L);
//            em.remove(findMember);

            // 멤버 수정
//            Member findMember = em.find(Member.class, 1L);
//            findMember.setName("helloJPA");
            // 저장은 따로 안해도 수정은 성공한다
//            em.persist(findMember);

            // 리스트로 나타내기
//            List<Member> result = em.createQuery("select m from Member as m", Member.class)
//                    .setFirstResult(1)
//                    .setMaxResults(10)
//                    .getResultList();
//            for (Member member : result) {
//                System.out.println("member.name = " + member.getName());
//            }

            // 비영속 상태
//            Member member = new Member();
//            member.setId(101L);
//            member.setName("HelloJPA");
            // 영속 상태
//            System.out.println("=== BEFORE ===");
//            em.persist(member); // 아직 db에 저장하지 않음, 1차 캐시에 저장되어있는 상태
//            System.out.println("=== AFTER ===");

//            Member findMember = em.find(Member.class, 101L); // 1차 캐시에서 찾아오므로 쿼리를 날리지 않음
//            System.out.println("findMember.id = " + findMember.getId());
//            System.out.println("findMember.name  = " + findMember.getName());

//            Member findMember1 = em.find(Member.class, 101L); // db에서 가져와 1차캐시에 넣어놓고 찾아준다.(쿼리 O)
//            Member findMember2 = em.find(Member.class, 101L); // 1차캐시에서 바로 가져온다.(쿼리 X)
//            System.out.println("result = " + (findMember1 == findMember2)); // true

            // 비영속
//            Member member1 = new Member(150L, "A");
//            Member member2 = new Member(160L, "B");
            // 영속 -> 이 때 1차캐시에 저장함과 동시에 쓰기 지연 SQL 저장소에 쿼리문이 저장됨
//            em.persist(member1);
//            em.persist(member2);
//            System.out.println("====== 쿼리 확인 =====");

            // 변경 감지로 엔티티 수정 - JPA는 값이 바뀌면 트랜젝션이 커밋되는 시점에 변경을 반영한다.
//            Member member = em.find(Member.class, 150L); // 객체 찾아와서
//            member.setName("ZZZZZ"); // 셋 네임으로 바꿔주기만 해도 적용됨
//            em.persist(member); // 오히려 persist 쓰면 안됨

            // 플러시(직접 db에 반영)
//            Member member = new Member(200L, "member200");
//            em.persist(member);
//            em.flush(); // commit 전에 미리 db에 반영하고싶을 때 수동 플러시

            // 준영속
//            Member member = em.find(Member.class, 150L); // 찾아올 때 영속상태
//            member.setName("AAAAA");
//            // JPA에서 관리하지 않는 준영속 상태가 됨 -> name 업데이트(commit)가 되지 않는다.
//            em.detach(member); // 특정 Entity만
//            em.clear(); // em안에 영속성 컨텍스트 전부 지움
//            em.close(); // 영속성 컨텍스트를 종료


//            Member member1 = new Member();
//            member1.setUsername("member1");
//            em.persist(member1);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            em.persist(member2);
//
//            em.flush();
//            em.clear();


//            Member findMember = em.getReference(Member.class, member.getId());
//            System.out.println("findMember.id = " + findMember.getId()); // 가짜를 가져왔기 때문에 쿼리를 날리지 않음
//            System.out.println("findMember.username = " + findMember.getUsername()); // db에서 가져와야하기 때문에 쿼리를 날림

//
//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.find(Member.class, member2.getId());
//            System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass())); // true

//            Member m1 = em.find(Member.class, member1.getId());
//            Member m2 = em.getReference(Member.class, member2.getId());
//            System.out.println("m1 == m2 : " + (m1.getClass() == m2.getClass())); // false


//            Member m1 = em.find(Member.class, member1.getId());
//            System.out.println("m1 = " + m1.getClass()); // m1 = class hellojpa.Member
//
//            Member reference = em.getReference(Member.class, member1.getId());
//            System.out.println("reference = " + reference.getClass()); // reference = class hellojpa.Member


//            Member refMember = em.getReference(Member.class, member1.getId());
//            System.out.println("refMember = " + refMember.getClass()); // Proxy
//            Hibernate.initialize(refMember); // 강제 초기화


//            Team team = new Team();
//            team.setName("teamA");
//            em.persist(team);
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setTeam(team);
//            em.persist(member1);
//
//            em.flush();
//            em.clear();
//
//            Member m = em.find(Member.class, member1.getId());
//
//            System.out.println("m = " + m.getTeam().getClass());
//
//            System.out.println("=========");
//            m.getTeam().getName(); // 초기화 시점
//            System.out.println("=========");


            // 영속성 전이(CASCADE)
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//            // child는 persist하지 않기 때문에 에러
//            // -> Parent OneToMany에 cascade로 해결
//            // child도 persist가 된다


            // 고아 객체
//            Child child1 = new Child();
//            Child child2 = new Child();
//
//            Parent parent = new Parent();
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent = em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);


            // 임베디드 타입
//            Member member = new Member();
//            member.setUsername("hello");
//            member.setHomeAddress(new Address("city", "street", "10000"));
//            member.setWorkPeriod(new Period());
//
//            em.persist(member);


//            Address address = new Address("city", "street", "10000");
//
//            Member member1 = new Member();
//            member1.setUsername("member1");
//            member1.setHomeAddress(address);
//            em.persist(member1);
//
//            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
//            member1.setHomeAddress(newAddress);
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(address);
//            em.persist(member2);

            // member1만 newCity로 바꾸려했지만
//            member1.getHomeAddress().setCity("newCity");
            // 실행결과 member2도 같이 newCity로 변경됨
            // address의 복사본인 copyAddress를 만들어서 따로 지정해줘야함


            // 값 타입 컬렉션
            // 값 타입 저장
//            Member member = new Member();
//            member.setUsername("member1");
//            member.setHomeAddress(new Address("homeCity", "street", "10000"));
//
//            member.getFavoriteFoods().add("치킨");
//            member.getFavoriteFoods().add("족발");
//            member.getFavoriteFoods().add("피자");
//
//            member.getAddressHistory().add(new AddressEntity("old1", "street", "10000"));
//            member.getAddressHistory().add(new AddressEntity("old2", "street", "10000"));
//
//            em.persist(member);
//
//            em.flush();
//            em.clear();

            // 값 타입 조회
//            System.out.println("============= START =============");
//            Member findMember = em.find(Member.class, member.getId());
//
//            List<Address> addressHistory = findMember.getAddressHistory();
//            for (Address address : addressHistory) {
//                System.out.println("address = " + address.getCity());
//            }
//
//            Set<String> favoriteFoods = findMember.getFavoriteFoods();
//            for (String favoriteFood : favoriteFoods) {
//                System.out.println("favoriteFood = " + favoriteFood);
//            }

            // 값 타입 수정
//            System.out.println("============= START =============");
//            Member findMember = em.find(Member.class, member.getId());
//
//            // homeCity -> newCity
//            Address newHome = findMember.getHomeAddress();
//            findMember.setHomeAddress(new Address("newCity", newHome.getStreet(), newHome.getZipcode()));
//
//            // 치킨 -> 한식
//            findMember.getFavoriteFoods().remove("치킨");
//            findMember.getFavoriteFoods().add("한식");
//
//            findMember.getAddressHistory().remove(new Address("old1", "street", "10000"));
//            findMember.getAddressHistory().add(new Address("newCity1", "street", "10000"));

            // 값 타입 컬렉션에 변경 사항이 있으면, 주인 엔티티와 연관된 모든 데이터를 삭제하고, 값 타입 결렉션에 있는 현재 값을 모두 다시 저장한다.

            // ===========================================================

            // JPGL - 객체지향 SQL
//            List<Member> result = em.createQuery(
//                    "select m from Member m where m.username like 'kim'",
//                    Member.class
//            ).getResultList();
//
//            for (Member member : result) {
//                System.out.println("member = " + member);
//            }

            // JPA Criteria - 복잡해서 유지보수에 어려움
//            CriteriaBuilder cb = em.getCriteriaBuilder();
//            CriteriaQuery<Member> query = cb.createQuery(Member.class);
//
//            Root<Member> m = query.from(Member.class);
//
//            CriteriaQuery<Member> cq = query.select(m);
//
//            String username = "asdf";
//            if (username != null) {
//                cq.where(cb.equal(m.get("username"), "kim"));
//            }
//
//            List<Member> resultList = em.createQuery(cq).getResultList();

            // QueryDSL - 자바 코드로 JPQL을 작성

            // Native SQL - 특정 DB에 의존적인 기능
//            em.createNativeQuery("select MEMBER_ID, city, street, zipcode, USERNAME from MEMBER")
//                            .getResultList();

            tx.commit(); // 변경 내용을 db에 반영(플러시) -> 이 때 쿼리가 날아감
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }

        emf.close();
    }
}
