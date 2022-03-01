package pi.spring.Services;

import java.util.List;

import pi.spring.Entities.Post;

public interface IPostService {
	 public List<Post> retrieveAllPost();
	 public Post addPost(Post p);
	 public Post deletePost(Integer postId);
	 public Post updatePost(Post p);
}
