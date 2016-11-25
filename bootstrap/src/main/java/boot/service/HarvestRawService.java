package boot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;


import boot.dao.HarvestRawRepository;

import boot.model.HarvestRaw;

@Service @Transactional
public class HarvestRawService {
	private final HarvestRawRepository harvestRawRepository;

	public HarvestRawService(HarvestRawRepository harvestRawRepository) {
		super();
		this.harvestRawRepository = harvestRawRepository;
	}
	public List<HarvestRaw> findAll(){
		List<HarvestRaw> computers = new ArrayList<HarvestRaw>();
		for (HarvestRaw harvestRaw : harvestRawRepository.findAll()) {
			computers.add(harvestRaw);
		}
		return computers;
	}
	
	public void save(HarvestRaw harvestRaw){
		harvestRawRepository.save(harvestRaw);
	}
	
	public void delete(int id){
		harvestRawRepository.delete(id);
	}
	
	public HarvestRaw findHarvestRaw(int id){
		return harvestRawRepository.findOne(id);
	}
	
}



