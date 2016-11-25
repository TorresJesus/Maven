package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Friend;

public interface FriendRepository extends CrudRepository<Friend, Integer>{

}
