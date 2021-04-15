package designpatterns;

import java.io.Serializable;

/*
 * Beans are a subtype of POJO (all java classes
 * start off as POJOs), which adhere to more strict
 * application of structure. 
 * 
 * Beans provide a more rigid structure to 
 * follow when creating Java Classes and objects.
 * 
 * To be considered a Bean a Java class MUST:
 * 		-Mark all fields private
 * 		-Include accessor and mutator methods
 * 		-Fields are ONLY accessed using accessor
 * 		-Include a no-args constructor
 * 		-Provide an overridden version of:
 * 			-hashCode()
 * 			-equals()
 * 			-toString()
 */
public class Bean implements Serializable {
	private String word = "Hello";
	private int id = 1234;
	
	public Bean() {
		// included to follow convention
	}
	
	/*
	 *  Parameterized constructors are NOT required
	 *  for a bean, though you will almost always
	 *  see at least one included
	 */
	public Bean(String word, int id) {
		this.word = word;
		this.id = id;
	}
	
	/*
	 *  Note that accessor and mutator methods
	 *  within a bean are not required to be
	 *  public. But they should exist to clearly
	 *  define how we want to read or write to
	 *  the fields on an object.
	 *  
	 *  Often, you will see all access and mutator
	 *  methods as public.
	 */
	public String getWord() {
		return word;
	}
	
	protected void setWord(String word) {
		this.word = word;
	}
	
	int getId() {
		return id;
	}
	
	private void setId(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((word == null) ? 0 : word.hashCode());
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
		Bean other = (Bean) obj;
		if (id != other.id)
			return false;
		if (word == null) {
			if (other.word != null)
				return false;
		} else if (!word.equals(other.word))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Bean [word=" + word + ", id=" + id + "]";
	}
}
