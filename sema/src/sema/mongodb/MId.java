package sema.mongodb;

import org.bson.types.ObjectId;

import sema.model.SId;

public class MId implements SId {
	public MId(ObjectId id) {
		super();
		this.oid = id;
	}

	private ObjectId oid;
	
	public ObjectId getOId(){
		return oid;
	}

	@Override
	public String getIdStr() {
		if(oid==null) return "";
		return oid.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((oid == null) ? 0 : oid.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		MId other = (MId) obj;
		if (oid == null) {
			if (other.oid != null) {
				return false;
			}
		} else if (!oid.equals(other.oid)) {
			return false;
		}
		return true;
	}



}
