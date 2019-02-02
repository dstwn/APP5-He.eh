package id.dstwn.pantiq.activity.panti.response;

import java.util.List;
//import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

//@Generated("com.robohorse.robopojogenerator")
public class ResponsePanti{

	@SerializedName("panti")
	private List<PantiItem> panti;

	@SerializedName("status")
	private boolean status;

	public void setPanti(List<PantiItem> panti){
		this.panti = panti;
	}

	public List<PantiItem> getPanti(){
		return panti;
	}

	public void setStatus(boolean status){
		this.status = status;
	}

	public boolean isStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"ResponsePanti{" + 
			"panti = '" + panti + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}