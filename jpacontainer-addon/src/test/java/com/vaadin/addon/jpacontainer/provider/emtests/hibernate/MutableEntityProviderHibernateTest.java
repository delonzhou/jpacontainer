/*
${license.header.text}
 */
package com.vaadin.addon.jpacontainer.provider.emtests.hibernate;

import com.vaadin.addon.jpacontainer.provider.MutableLocalEntityProvider;
import com.vaadin.addon.jpacontainer.provider.emtests.AbstractMutableLocalEntityProviderEMTest;
import com.vaadin.addon.jpacontainer.testdata.Address;
import com.vaadin.addon.jpacontainer.testdata.EmbeddedIdPerson;
import com.vaadin.addon.jpacontainer.testdata.Name;
import com.vaadin.addon.jpacontainer.testdata.Person;
import com.vaadin.addon.jpacontainer.testdata.PersonSkill;
import com.vaadin.addon.jpacontainer.testdata.Skill;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.hibernate.ejb.Ejb3Configuration;

/**
 * Entity Manager test for {@link MutableLocalEntityProvider} that uses
 * Hibernate as the entity manager implementation.
 * 
 * @author Petter Holmström (IT Mill)
 * @since 1.0
 */
public class MutableEntityProviderHibernateTest extends
		AbstractMutableLocalEntityProviderEMTest {

	protected EntityManager createEntityManager() throws Exception {
		Ejb3Configuration cfg = new Ejb3Configuration().setProperty(
				"hibernate.dialect", "org.hibernate.dialect.HSQLDialect")
				.setProperty("hibernate.connection.driver_class",
						"org.hsqldb.jdbcDriver").setProperty(
						"hibernate.connection.url",
						getDatabaseUrl()).setProperty(
						"hibernate.connection.username", "sa").setProperty(
						"hibernate.connection.password", "").setProperty(
						"hibernate.connection.pool_size", "1").setProperty(
						"hibernate.connection.autocommit", "true").setProperty(
						"hibernate.cache.provider_class",
						"org.hibernate.cache.HashtableCacheProvider")
				.setProperty("hibernate.hbm2ddl.auto", "create-drop")
				.setProperty("hibernate.show_sql", "false")
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Address.class)
				.addAnnotatedClass(EmbeddedIdPerson.class)
				.addAnnotatedClass(Name.class)
				.addAnnotatedClass(PersonSkill.class)
				.addAnnotatedClass(Skill.class);
		EntityManagerFactory emf = cfg.buildEntityManagerFactory();
		return emf.createEntityManager();
	}
}
