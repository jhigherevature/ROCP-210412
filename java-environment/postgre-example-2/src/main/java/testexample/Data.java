package testexample;

public class Data {
	
	String username;
	String pass;
	
	public boolean checkisOdd(int value) {
		if (value % 2 == 0) {
			return false;
		}
		
		return true;
	}

	public int saltedHash() {
		/* 
		 * All a 'salt' is with a hash, is some value that can be 
		 * 'controlled'/'predicted' which provides you with a method
		 * to change the hash in a predictable, yet seemingly random
		 * way...
		 * 
		 * 'revature123'
		 */
		return this.hashCode() + 
				this.username.charAt(0) + 
				this.username.charAt(this.username.length() - 1) + 
				this.username.length() + 
				this.pass.length();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Data other = (Data) obj;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}
	
	
}
