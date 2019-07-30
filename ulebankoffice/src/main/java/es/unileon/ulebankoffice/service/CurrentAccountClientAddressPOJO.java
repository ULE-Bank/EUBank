package es.unileon.ulebankoffice.service;

import javax.validation.Valid;

/**
 * @author Razvan Raducu
 *
 */
public class CurrentAccountClientAddressPOJO {
	
	@Valid
	private ClientPOJO client;
	
	@Valid
	private AddressPOJO address;
	
	@Valid
	private CurrentAccountPOJO currentAccount;
	
	public ClientPOJO getClient() {
		return client;
	}
	public void setClient(ClientPOJO client) {
		this.client = client;
	}
	public AddressPOJO getAddress() {
		return address;
	}
	public void setAddress(AddressPOJO address) {
		this.address = address;
	}
	public CurrentAccountPOJO getCurrentAccount() {
		return currentAccount;
	}
	public void setCurrentAccount(CurrentAccountPOJO currrentAccount) {
		this.currentAccount = currrentAccount;
	}
	
	

}
