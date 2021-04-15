package objectclass;

public class Info {
	public int id;
	public String name;
	
	public Info(int id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Info other = (Info) obj;
//		if (id != other.id)
//			return false;
//		if (name == null) {
//			if (other.name != null)
//				return false;
//		} else if (!name.equals(other.name))
//			return false;
//		return true;
//	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Info) {
			if (this.id != ((Info)obj).id) {
				return false;
			} else if (!this.name.equals(((Info) obj).name)) {
				return false;
			}
		}
		return true;
	}

	@Override
	public String toString() {
		return "Info [id=" + id + ", name=" + name + "]";
	}
	
//	public String toString() {
//		return "Info [id=" + this.id + ", name=" + this.name + "]";
//	}
}
