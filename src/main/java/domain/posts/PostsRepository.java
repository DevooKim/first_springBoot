package domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//DB Layer 접근자
//단순히 인터페이스 생성 후 JpaRepository<Entity class, PK type>을 상속하면 기본적인 CRUD메소드가 자동으로 생성된다.
//Entity 클래스와 기본 Entity Repository는 함께 위치해야한다.
public interface PostsRepository extends JpaRepository<Posts, Long> {

}
