package hellojpa;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

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
            Member member = em.find(Member.class, 150L); // 객체 찾아와서
            member.setName("ZZZZZ"); // 셋 네임으로 바꿔주기만 해도 적용됨
//            em.persist(member); // 오히려 persist 쓰면 안됨

            tx.commit(); // 적용하기 -> 이 때 쿼리가 날아감
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
