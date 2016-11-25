package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.FriendRepository;
import boot.model.Friend;

@Service
@Transactional
public class FriendService {
	private final FriendRepository friendRepository;

	public FriendService(FriendRepository friendRepository) {
		super();
		this.friendRepository = friendRepository;
	}

	public List<Friend> findAll() {
		List<Friend> friends = new ArrayList<Friend>();
		for (Friend friend : friendRepository.findAll()) {
			friends.add(friend);
		}
		return friends;
	}
	public void save(Friend friend){
		friendRepository.save(friend);
	}
	public void delete(int id){
		friendRepository.delete(id);
	}
	public Friend findFriend(int id){
		return friendRepository.findOne(id);
	}
}
