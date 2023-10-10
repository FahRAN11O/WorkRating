package com.wr.operations;

import org.mindrot.jbcrypt.BCrypt;

public class DataCrypter {
	
	
	public String crypter(String value) {
		
		return org.mindrot.jbcrypt.BCrypt.hashpw(value, BCrypt.gensalt());
	}
	
	public boolean verifierCrypt(String value, String valueCrypted) {
		return BCrypt.checkpw(value, valueCrypted);
	}

}
