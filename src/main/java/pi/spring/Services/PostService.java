package pi.spring.Services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import pi.spring.Entities.Post;
import pi.spring.Repositories.PostRepository;

@Service
public class PostService implements IPostService {

@Autowired
PostRepository postRepository;
	@Override
	public List<Post> retrieveAllPost() {
		List<Post> posts = (List<Post>) postRepository.findAll();
		{
		for (Post post :posts)
			System.out.println(" post : " +post);
		}
		return posts;
	}

	@Override
	public Post addPost(Post p) {
		
		return postRepository.save(p);
	}

	@Override
	public Post deletePost(Integer postId) {
		
		return postRepository.deleteById(postId);;
	}

	@Override
	public Post updatePost(Post p) {
		
		return postRepository.save(p);
	}
	

}