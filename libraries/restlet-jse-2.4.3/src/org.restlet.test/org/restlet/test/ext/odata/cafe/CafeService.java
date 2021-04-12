/**
 * Copyright 2005-2020 Talend
 * 
 * The contents of this file are subject to the terms of one of the following
 * open source licenses: Apache 2.0 or or EPL 1.0 (the "Licenses"). You can
 * select the license that you prefer but you may not use this file except in
 * compliance with one of these Licenses.
 * 
 * You can obtain a copy of the Apache 2.0 license at
 * http://www.opensource.org/licenses/apache-2.0
 * 
 * You can obtain a copy of the EPL 1.0 license at
 * http://www.opensource.org/licenses/eclipse-1.0
 * 
 * See the Licenses for the specific language governing permissions and
 * limitations under the Licenses.
 * 
 * Alternatively, you can obtain a royalty free commercial license with less
 * limitations, transferable or non-transferable, directly at
 * https://restlet.talend.com/
 * 
 * Restlet is a registered trademark of Talend S.A.
 */

package org.restlet.test.ext.odata.cafe;

import org.restlet.ext.odata.Query;
import org.restlet.ext.odata.Service;

/**
 * Generated by the generator tool for the WCF Data Services extension for the
 * Restlet framework.<br>
 * 
 * @see <a href="http://localhost:8111/Cafe.svc/$metadata">Metadata of the
 *      target WCF Data Services</a>
 * 
 */
public class CafeService extends Service {

    /**
     * Constructor.
     * 
     */
    public CafeService() {
        super("http://localhost:8111/Cafe.svc");
    }

    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception
     */
    public void addEntity(Cafe entity) throws Exception {
        addEntity("/Cafes", entity);
    }

    /**
     * Creates a query for cafe entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<Cafe> createCafeQuery(String subpath) {
        return createQuery(subpath, Cafe.class);
    }

    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception
     */
    public void addEntity(Item entity) throws Exception {
        addEntity("/Items", entity);
    }

    /**
     * Creates a query for item entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<Item> createItemQuery(String subpath) {
        return createQuery(subpath, Item.class);
    }

    /**
     * Adds a new entity to the service.
     * 
     * @param entity
     *            The entity to add to the service.
     * @throws Exception
     */
    public void addEntity(Contact entity) throws Exception {
        addEntity("/Contacts", entity);
    }

    /**
     * Creates a query for contact entities hosted by this service.
     * 
     * @param subpath
     *            The path to this entity relatively to the service URI.
     * @return A query object.
     */
    public Query<Contact> createContactQuery(String subpath) {
        return createQuery(subpath, Contact.class);
    }

}
