package com.ibm.sbt.services.client.connections.forums.model;

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

import java.util.List;

import org.w3c.dom.Node;

import com.ibm.commons.util.StringUtil;
import com.ibm.commons.xml.NamespaceContext;
import com.ibm.commons.xml.xpath.XPathExpression;
import com.ibm.sbt.services.client.base.AtomEntity;
import com.ibm.sbt.services.client.base.AtomXPath;
import com.ibm.sbt.services.client.base.BaseService;
import com.ibm.sbt.services.client.base.ConnectionsConstants;
import com.ibm.sbt.services.client.base.datahandlers.XmlDataHandler;
import com.ibm.sbt.services.client.connections.forums.ForumService;
import com.ibm.sbt.services.client.connections.forums.ForumsXPath;

/**
 * Base model object to be used with Forums, Topics and Replies
 * 
 * @author Manish Kataria 
 */


public class BaseForumEntity extends AtomEntity {

	private final String FORUMID = "urn:lsid:ibm.com:forum:";

	/**
	 * Constructor
	 *  
	 * @param ForumService
	 * @param ForumId
	 */
	public BaseForumEntity(ForumService forumsService, String id) {
		super(forumsService,id);
		setService(forumsService);
		setAsString(ForumsXPath.uid, id);
	}
	/**
     * Constructor
     * @param ForumService
     */
    public BaseForumEntity(ForumService forumsService) {
            super(forumsService);
            setService(forumsService);
    }
    
    
	/**
     * Constructor
     * @param BaseService
     * @param Node
     * @param NamespaceContext
     * @param XPathExpression
     */
	public BaseForumEntity(BaseService service, Node node, NamespaceContext namespaceCtx, XPathExpression xpathExpression) {
		super(service, node, namespaceCtx, xpathExpression);
	}
	
	public BaseForumEntity(){}


	/**
    * To get Uuid of Forum Entity
	*
	* @method getUid
	* @return String
	*/ 
	public String getUid(){
		String id = getAsString(ForumsXPath.uid);
		if(StringUtil.isNotEmpty(id)){
			if(StringUtil.startsWithIgnoreCase(id, FORUMID)){
				id = id.substring(FORUMID.length());
			}
		}
		return id;
	}

	@Override
	public Author getAuthor(){
		return new Author(getService(),new XmlDataHandler((Node)this.getDataHandler().getData(), 
	    		ConnectionsConstants.nameSpaceCtx, (XPathExpression)AtomXPath.author.getPath()));
	}

	@Override
	public Contributor getContributor(){
		return new Contributor(getService(), new XmlDataHandler((Node)this.getDataHandler().getData(), 
	    		ConnectionsConstants.nameSpaceCtx, (XPathExpression)AtomXPath.contributor.getPath()));
	}

	public String createdBy(){
		return this.getAuthor().getName();
	}

	public String updatedBy(){
		return this.getContributor().getName();
	}


	/**
	 * @sets the tags
	 */
	// FIXME this method should also be removed from here. 
	public void setTags(List<String> tags) {
		if(!tags.isEmpty()){
			for (int i = 0; i < tags.size(); i++){
				fields.put(ForumsXPath.tags.toString() + i , tags.get(i));
			}
		}
	}

	/**
	 * @sets the tags
	 */
	public void setTags(String tags) {
		setAsString(ForumsXPath.tags, tags);
	}

	@Override
	public ForumService getService(){
		return (ForumService)super.getService();
	}

	@Override
	public XmlDataHandler getDataHandler(){
		return (XmlDataHandler)super.getDataHandler();
	}

	/*
	 * Method used to extract the forum uuid for an id string.
	 */
	public String extractForumUuid(String uid) {
		if (StringUtil.isNotEmpty(uid) && StringUtil.startsWithIgnoreCase(uid, FORUMID)) {
			return uid.substring(FORUMID.length());
		} else {
			return uid;
		}
	}; 

}
