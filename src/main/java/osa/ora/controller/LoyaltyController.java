package osa.ora.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ora.ora.model.LoyaltyAccount;
import ora.ora.model.LoyaltyTransaction;
import ora.ora.repository.LoyaltyAccountRepositry;
import ora.ora.repository.LoyaltyTransactionRepositry;

@RestController
@RequestMapping("/loyalty/v1")
public class LoyaltyController {
	@Autowired
	private LoyaltyAccountRepositry accountRepositry;
	@Autowired
	private LoyaltyTransactionRepositry transactionRepositry;
	
	/**
	 * Rest Service to return the loyalty account
	 * @param account id
	 * @return the LoyaltyAccount
	 */
	@GetMapping("/balance/{account}")
	public LoyaltyAccount getBalance(@PathVariable(value = "account") Integer account) {
		System.out.println("Get Balance: "+account);
		LoyaltyAccount loyalty = accountRepositry.getOne(account);
		if (loyalty == null) {
			loyalty = new LoyaltyAccount(-1, -1, -1, false);
		} else {
			System.out.println("Account data:" + loyalty.getBalance());
		}
		return loyalty;
	}
	/**
	 * Rest service to return transactions of specific loyalty account
	 * @param account
	 * @return LoyaltyTransaction[]
	 */
	@GetMapping("/transactions/{account}")
	public LoyaltyTransaction[] getTransactions(@PathVariable(value = "account") Integer account) {
		System.out.println("Get Balance: "+account);
    	LoyaltyAccount loyalty=accountRepositry.getOne(account);
    	if(loyalty==null){
    		loyalty=new LoyaltyAccount(-1,-1,-1,false);
    	}else{
    		System.out.println("Account data:"+loyalty.getBalance());
    		LoyaltyTransaction[] transactions=transactionRepositry.getLoyaltyTransactions(loyalty.getId());
    		return transactions;
    	}
        return null;
	}
	/**
	 * Rest service to add a new LoyaltyAccount
	 * @param account
	 * @return the created LoyaltyAccount
	 */
	@PostMapping("/add")
	public LoyaltyAccount addAccount(@RequestBody LoyaltyAccount account) {
    	LoyaltyAccount loyalty=accountRepositry.save(account);	
    	return loyalty;
	}
	/**
	 * Rest service to add a new LoyaltyTransaction in a LoyaltyAccount
	 * @param loyaltyTransaction
	 * @return the created LoyaltyTransaction
	 */
	@PostMapping("/transactions/add")
	public LoyaltyTransaction addTransaction(@RequestBody LoyaltyTransaction loyaltyTransaction) {
    	System.out.println("Get Balance: "+loyaltyTransaction.getAccount_id());
    	LoyaltyAccount loyalty=accountRepositry.getOne(loyaltyTransaction.getAccount_id());
    	if(loyalty==null){
    		return null;
    	}else{
    		loyalty.setBalance(loyalty.getBalance()+loyaltyTransaction.getPoints());
    		if(accountRepositry.save(loyalty)!=null){
    			LoyaltyTransaction transaction=transactionRepositry.save(loyaltyTransaction);
    			return transaction;
    		}else{
    			return null;
    		}
    		
    	}
    }
}
