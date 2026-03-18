package thiGK.ntu65133085.nguyenthanhtai_fitCMS.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import thiGK.ntu65133085.nguyenthanhtai_fitCMS.models.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}