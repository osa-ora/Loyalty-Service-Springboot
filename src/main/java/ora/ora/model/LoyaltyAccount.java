package ora.ora.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "loyalty_account")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class LoyaltyAccount implements Serializable {
	/**
	 * Default serial version
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "balance")
	private int balance;
	@Column(name = "tier")
	private int tier;
	@Column(name = "enabled")
	private boolean enabled;
	public LoyaltyAccount(){
	}
	public LoyaltyAccount(int id, int balance,int tier, boolean enabled){
		this.id=id;
		this.balance=balance;
		this.tier=tier;
		this.enabled=enabled;
		
	}
	@JsonProperty
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@JsonProperty
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	@JsonProperty
	public int getTier() {
		return tier;
	}
	public void setTier(int tier) {
		this.tier = tier;
	}
	@JsonProperty
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	@Override
    public String toString() {
        return "Account {" + "id=" + id + ", account_no=" + balance + 
                ", tier=" + tier + ", enabled=" + enabled + 
                "}";
    }
}
