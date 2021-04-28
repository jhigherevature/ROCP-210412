package services;

import main.CurrentUserRef;

public class CreateDonor {

	query donor_id
	query userpass_pass
	query account_id
	
	call donor constructor (above info)
	
	donor -> donordaoimpl
	
	CurrentUserRef.getCurrentUserRef().setDonorObj(donor);
	
}
