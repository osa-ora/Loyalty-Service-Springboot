package ora.ora.repository;
		
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ora.ora.model.LoyaltyAccount;

@Repository
public interface LoyaltyAccountRepositry extends JpaRepository<LoyaltyAccount, Integer>{

	//public LoyaltyAccount findByName(String name);
	
}