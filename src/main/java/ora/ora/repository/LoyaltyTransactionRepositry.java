package ora.ora.repository;
		
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ora.ora.model.LoyaltyTransaction;

@Repository
public interface LoyaltyTransactionRepositry extends JpaRepository<LoyaltyTransaction, Integer>{
	
	//Query(value = "SELECT * FROM loyalty_transaction WHERE ACCOUNT_ID = ?1", nativeQuery = true)
	@Query(value = "SELECT a FROM LoyaltyTransaction a WHERE ACCOUNT_ID = ?1", nativeQuery = false)
	LoyaltyTransaction[] getLoyaltyTransactions(int id);
	
}