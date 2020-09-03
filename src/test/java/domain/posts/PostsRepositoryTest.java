package domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest //H2 데이터베이스를 자동으로 실행해준다.
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After  //단위테스트가 끝날 때마다 수행되는 메소드
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void loadContent() {
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder()    //테이블에 insert/update 쿼리를 실행, id가 있다면 update / 없으면 insert
        .title(title)
        .content(content)
        .author("author")
        .build());

        List<Posts> postsList = postsRepository.findAll();  //테이블에서 모든 데이터 조회

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}
