import java.rmi.RemoteException;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import net.sf.json.JSONObject;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

public class Test {

	public static void main(String[] args) throws ServiceException {
		String url="http://localhost:8083/Exm1/services/GetInfoService.GetInfoServiceHttpEndpoint/";
		Service service=new Service();
		Call call=(Call)service.createCall();
		call.setTargetEndpointAddress(url);
		call.setOperationName(new QName("http://webservice.yang.com","getInfo"));
		call.addParameter(new QName("http://webservice.yang.com","sno"),
				XMLType.XSD_STRING,javax.xml.rpc.ParameterMode.IN);
		call.setReturnType(XMLType.XSD_STRING);
		call.setUseSOAPAction( true );
		call.setSOAPActionURI( "http://webservice.yang.com/getInfo");
		try {
			String result =call.invoke( new Object[]{"201208010127"}).toString();
			System.out.println(result);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
