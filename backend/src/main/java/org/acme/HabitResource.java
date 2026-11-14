package org.acme;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/api/habits")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class HabitResource {

    @Inject
    EntityManager em; // Gerenciador do banco de dados do JPA

    // 1. Listar todos os hábitos (GET /api/habits)
    @GET
    public List<Habit> listAll() {
        return em.createQuery("SELECT h FROM Habit h", Habit.class).getResultList();
    }

    // 2. Criar um novo hábito (POST /api/habits)
    @POST
    @Transactional // Obrigatório sempre que formos alterar o banco (insert, update, delete)
    public Response create(Habit newHabit) {
        em.persist(newHabit);
        return Response.status(Response.Status.CREATED).entity(newHabit).build();
    }

    // 3. Apagar um hábito pelo ID (DELETE /api/habits/{id})
    @DELETE
    @Path("/{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Habit habit = em.find(Habit.class, id);
        if (habit == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        em.remove(habit);
        return Response.noContent().build();
    }
}