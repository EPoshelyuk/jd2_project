package it.academy.main;

import it.academy.entity.Sensor;
import it.academy.entity.SensorType;
import it.academy.entity.Unit;
import it.academy.entity.User;
import it.academy.entity.enums.UserRole;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;


public class Main {

    public static void main(String[] args) throws Exception {
        StandardServiceRegistry registry =
                new StandardServiceRegistryBuilder()
                        .configure()
                        .build();
        SessionFactory factory =
                new MetadataSources(registry)
                        .buildMetadata()
                        .buildSessionFactory();

        SensorType type = new SensorType(null, "pressure");
        Unit unit = new Unit(null, "bar");

        Sensor sensor = new Sensor();
        sensor.setName("Sensor 1");
        sensor.setModel("PC33-56");
        sensor.setType(type);
        sensor.setRangeFrom(10);
        sensor.setRangeTo(50);
        sensor.setUnit(unit);
        sensor.setLocation("Room1");

        User user = new User();
        user.setLogin("1admin");
        user.setPassword("1234");
        user.setUserRole(UserRole.ADMINISTRATOR);

        Session session = factory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(user);
            session.save(type);
            session.save(unit);
            session.save(sensor);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            throw e;
        } finally {
            session.close();
        }

    }
}

