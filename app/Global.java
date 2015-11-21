
import java.net.UnknownHostException;

import play.GlobalSettings;
import play.Logger;
import play.Configuration;
import com.google.code.morphia.Morphia;
import com.mongodb.Mongo;

import controllers.MorphiaObject;
import controllers.MongoDB;
public class Global extends GlobalSettings {

@Override
	public void onStart(play.Application arg0) {
		super.beforeStart(arg0);
		   	Logger.debug("** onStart **");

        MongoDB.connect();

        MongoDB.connect();

     
	
		try {
		
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
