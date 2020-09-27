package net.codejava;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional

public class PService {
	
	@Autowired
    private PRepository repo;
     
    public List<Project> listAll() {
        return repo.findAll();
    }
     
    public void save(Project pr) {
        repo.save(pr);
    }
     
    public Project get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }

}
