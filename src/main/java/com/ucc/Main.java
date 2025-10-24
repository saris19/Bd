package com.ucc;

import java.sql.Connection;
import java.sql.SQLException;
import com.ucc.Connection.DatabaseConnection;
import com.ucc.model.Actor;
import com.ucc.repository.ActorRepository;
import com.ucc.repository.IRepository;

public class Main {
    public static void main(String[] args) throws SQLException {

        try (Connection myConn = DatabaseConnection.getInstanceConnection()) {
            IRepository actorRepository = new ActorRepository();

            // 🔹 Insertar
            Actor actor = new Actor();
            actor.setActor_id(9999);
            actor.setFirst_name("PepitoCode2");
            actor.setLast_name("pepitoCode2");
            actorRepository.save(actor);

            // 🔹 Actualizar
            actor.setFirst_name("PepitoActualizado");
            actor.setLast_name("CodeActualizado");
            actorRepository.update(actor);

            // 🔹 Eliminar
            actorRepository.delete(9999);

            // 🔹 Mostrar todos
            actorRepository.findAll().forEach(System.out::println);

        } catch (Exception e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
    }
}
