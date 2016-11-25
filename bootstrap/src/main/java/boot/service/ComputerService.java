package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import boot.dao.ComputerRepository;
import boot.model.Computer;

@Service @Transactional
public class ComputerService {
	private final ComputerRepository computerRepository;

	public ComputerService(ComputerRepository computerRepository) {
		super();
		this.computerRepository = computerRepository;
	}
	public List<Computer> findAll(){
		List<Computer> computers = new ArrayList<Computer>();
		for (Computer computer : computerRepository.findAll()) {
			computers.add(computer);
		}
		return computers;
	}
	
	public void save(Computer computer){
		computerRepository.save(computer);
	}
	
	public void delete(int id){
		computerRepository.delete(id);
	}
	
	public Computer findcomputer(int id){
		return computerRepository.findOne(id);
	}
	
}

