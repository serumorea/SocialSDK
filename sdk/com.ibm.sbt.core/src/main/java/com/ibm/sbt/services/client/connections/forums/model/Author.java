/*
 * � Copyright IBM Corp. 2013
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */

package com.ibm.sbt.services.client.connections.forums.model;

import com.ibm.sbt.services.client.base.BaseService;
import com.ibm.sbt.services.client.base.datahandlers.DataHandler;
import com.ibm.sbt.services.client.connections.common.Person;
import com.ibm.sbt.services.client.connections.forums.ForumsXPath;


/**
 * Actor class for persisting Author information from Forums Entry 
 * @author Manish Kataria
 */

@Deprecated
public class Author extends Person {

	public Author(BaseService svc, DataHandler<?> dataHandler) {
		super(svc, dataHandler);
	}
	
//	private String name;
//	private String uid;
//	private String email;
//	private String state;
//	DataHandler<?> dataHandler;
//	public Author(DataHandler<?> dataHandler) {
//		this.dataHandler = dataHandler;
//	}
//	
	/*
	 *  Keeping this method for now to prevent breakage for existing users.
	 *  New users should use getId() instead of getUserId()
	 */
	@Deprecated
	public String getUserid() {
		return super.getId();
	}
//
//	
//	public String getName() {
//		return dataHandler.getAsString(ForumsXPath.actorName);
//	}
//	
//	public String getEmail() {
//		return dataHandler.getAsString(ForumsXPath.actorEmail);
//	}
//
//
//	public String getState() {
//		return dataHandler.getAsString(ForumsXPath.actorUserState);
//	}


}
