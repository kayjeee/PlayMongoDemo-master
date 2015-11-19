
import java.net.UnknownHostException;

import play.GlobalSettings;
import play.Logger;
import play.Configuration;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

import controllers.MorphiaObject;

public class Global extends GlobalSettings {

@Override
	public void onStart(play.Application arg0) {
		super.beforeStart(arg0);
		Logger.debug("** onStart **"); 
		try {
			Configuration config = Configuration.root().getConfig("jongo");
			String host = config.getString("mongodb.host");

			   String uri =config.getString("mongodb.uri");
		  
			   System.out.print(uri);
			   System.out.print(host);
			MorphiaObject.mongo = new Mongo("bne1so6syjbe6sh-mongodb.services.clever-cloud.com");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		Configuration config = Configuration.root().getConfig("jongo");
	      		String test = "bne1so6syjbe6sh";
     
     
		MorphiaObject.morphia = new Morphia();
		MorphiaObject.datastore = MorphiaObject.morphia.createDatastore(MorphiaObject.mongo, "test");
		MorphiaObject.datastore.ensureIndexes();   
		MorphiaObject.datastore.ensureCaps();  

		Logger.debug("** Morphia datastore: " + MorphiaObject.datastore.getDB());
	}
}
