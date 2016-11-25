package boot.dao;

import org.springframework.data.repository.CrudRepository;

import boot.model.Computer;

public interface ComputerRepository extends CrudRepository<Computer, Integer>{

}
