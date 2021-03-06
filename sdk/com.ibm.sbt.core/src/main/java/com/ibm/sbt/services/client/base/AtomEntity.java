/*
 * @ Copyright IBM Corp. 2013
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
package com.ibm.sbt.services.client.base;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Node;

import com.ibm.commons.util.StringUtil;
import com.ibm.commons.xml.NamespaceContext;
import com.ibm.commons.xml.xpath.XPathExpression;
import com.ibm.sbt.services.client.base.datahandlers.FieldEntry;
import com.ibm.sbt.services.client.base.datahandlers.XmlDataHandler;
import com.ibm.sbt.services.client.connections.common.Person;

/**
 * @author mwallace
 *
 */
public class AtomEntity extends BaseEntity {

	/**
	 * Construct an AtomEntity instance.
	 * 
	 * @param service
	 * @param data
	 * @param namespaceCtx
	 * @param xpathExpression
	 */
	public AtomEntity(BaseService service, Node node, NamespaceContext namespaceCtx, XPathExpression xpathExpression) {
		super(service, new XmlDataHandler(node, namespaceCtx, xpathExpression));
	}
	
	/**
	 * Construct an AtomEntity instance.
	 * 
	 * @param service
	 * @param dataHandler
	 */
	public AtomEntity(BaseService service, XmlDataHandler dataHandler) {
		super(service, dataHandler);
	}
	
	
	/**
	 * Construct an AtomEntity instance.
	 * 
	 * @param service
	 */
	public AtomEntity(BaseService service) {
		super(service, null);
	}
	/**
	 * Construct an AtomEntity instance.
	 * 
	 * @param service
	 * @param id
	 */
	public AtomEntity(BaseService service, String id) {
		super(service, null);
		setAsString(AtomXPath.id, id);
		
	}
	/**
	 * Default Constructor.
	 */
	public AtomEntity() {
	}
	
    /**
     * Return the value of id from ATOM entry document.
     * 
     * @method getId
     * @return {String} ID of the ATOM entry
     */
    public String getId() {
        return this.getAsString(AtomXPath.id);
    }

    /**
     * Sets Id of ATOM entry.
     * 
     * @method setId
     * @param {String} ID of the ATOM entry
     */
    public void setId(String id) {
        setAsString(AtomXPath.id, id);
    }

    /**
     * Return the value of title from ATOM entry document.
     * 
     * @method getTitle
     * @return {String} ATOM entry title
     */
    public String getTitle() {
        return this.getAsString(AtomXPath.title);
    }

    /**
     * Sets title of ATOM entry.
     * 
     * @method setTitle
     * @param {String} title ATOM entry title
     */
    public void setTitle(String title) {
        this.setAsString(AtomXPath.title, title);
    }
    
    /**
     * Return the value of summary from ATOM entry document.
     * 
     * @method getSummary
     * @return {String} ATOM entry summary
     */
    public String getSummary() {
        return this.getAsString(AtomXPath.summary);
    }

    /**
     * Sets summary of ATOM entry.
     * 
     * @method setSummary
     * @param {String} title ATOM entry summary
     */
    public void setSummary(String summary) {
        this.setAsString(AtomXPath.summary, summary);
    }
    
    /**
     * Return the content from ATOM entry document.
     * 
     * @method getContent
     * @return {Object} Content
     */
    public String getContent() {
        return this.getAsString(AtomXPath.content);
    }

    /**
     * Sets content of ATOM entry.
     * 
     * @method setContent
     * @param {String} content
     */
    public void setContent(String content) {
        this.setAsString(AtomXPath.content, content);
    }

    /**
     * Gets a author from ATOM entry document.
     * 
     * @method getAuthor
     * @return {Member} author of the ATOM entry document
     */
    public Person getAuthor() {
    	return new Person(getService(), new XmlDataHandler((Node)this.getDataHandler().getData(), 
    			ConnectionsConstants.nameSpaceCtx, (XPathExpression)AtomXPath.author.getPath()));
    }

    /**
     * Gets a contributor from ATOM entry document.
     * 
     * @method getContributor
     * @return {Member} contributor of the ATOM entry document
     */
    public Person getContributor() {
    	return new Person(getService(), new XmlDataHandler((Node)this.getDataHandler().getData(), 
    			ConnectionsConstants.nameSpaceCtx, (XPathExpression)AtomXPath.contributor.getPath()));
    }
    
    /**
     * Return the published date from ATOM entry document.
     * 
     * @method getPublished
     * @return {Date} Published date of the ATOM entry document
     */
    public Date getPublished() {
        return this.getAsDate(AtomXPath.published);
    }

    /**
     * Return the last updated date from ATOM entry document.
     * 
     * @method getUpdated
     * @return {Date} Last updated date of the ATOM entry document
     */
    public Date getUpdated() {
        return this.getAsDate(AtomXPath.updated);
    }
    
    /**
     * Return the alternate url of the ATOM entry document.
     * 
     * @method getAlternateUrl
     * @return {String} Alternate url
     */
    public String getAlternateUrl() {
        return this.getAsString(AtomXPath.alternateUrl);
    }
            
    /**
     * Return the self url of the ATOM entry document.
     * 
     * @method getSelfUrl
     * @return {String} Self url
     */
    public String getSelfUrl() {
        return this.getAsString(AtomXPath.selfUrl);
    }
    
    /**
     * Return the edit url of the ATOM entry document.
     * 
     * @method getEditUrl
     * @return {String} Edit url
     */
    public String getEditUrl() {
        return this.getAsString(AtomXPath.editUrl);
    }

    /**
     * Create ATOM entry XML
     * 
     * @returns
     */
    public String createPostData() {
        return "";
    }
    
    /**
     * Return extra entry data to be included in post data for this entity.
     * 
     * @returns {String}
     */
    public String createEntryData() {
    	return "";
    }
    
    /**
     * Return the list of category terms that do not have a scheme attribute
     * @return
     */
	public List<String> getBaseTags() {
		return getAsList(AtomXPath.tags);
	}
	
	/**
	 * Set the tags
	 * @param tags
	 */
	public void setBaseTags(List<String> tags) {
		setAsList(AtomXPath.tags, tags);
	}
	
	
	protected void setAsSet(FieldEntry field, Set<String> value) {
		fields.put(field.getName(), value);
	}
	
	protected void setAsList(FieldEntry field, List<String> value) {
		fields.put(field.getName(), value);
	}
	
	@SuppressWarnings("unchecked")
	protected Set<String> getAsSet(FieldEntry field) {
		if (fields.containsKey(field.getName())){
			return (Set<String>)fields.get(field.getName());
		}
		if (dataHandler != null) {
			return new HashSet<String>(Arrays.asList((dataHandler.getAsArray(field))));
		}
		throw new NullPointerException(StringUtil.format("Field {0} was not found or had no value",field.getName()));
	}
	
	@SuppressWarnings("unchecked")
	protected List<String> getAsList(FieldEntry field) {
		if (fields.containsKey(field.getName())){
			return (List<String>)fields.get(field.getName());
		}
		if (dataHandler != null) {
			return Arrays.asList((dataHandler.getAsArray(field)));
		}
		throw new NullPointerException(StringUtil.format("Field {0} was not found or had no value",field.getName()));
	}
}
