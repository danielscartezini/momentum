package org.acme;

import java.util.List;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/api/habits")    // Define a url de comunicacao com a API 
@Produces(MediaType.APPLICATION_JSON)   // O endpoint converte a resposta para JSON
@Consumes(MediaType.APPLICATION_JSON)   // O endpoint vai receber requisicoes em JSON
public class HabitResource {
    
    @Inject // conexao com o banco de dados
    EntityManager em;

// Requisições HTTP para gerenciar hábitos
    // Endpoint para query dos hábitos
    @GET 
    public List<Habit> getHabit() {
        return em.createQuery("SELECT h FROM Habit h", Habit.class).getResultList();
    }
    
    // Endpoint para adicionar um novo hábito
    @POST
    @Transactional  // Os endpoints que modificam o banco de dados (POST, DELETE) precisam ser transacionais
    public void addHabit(Habit habit) {
        em.persist(habit);  // Habit habit =  o habito que vem do frontend em um JSON, que é convertido para um objeto Habit pelo @Consumes(MediaType.APPLICATION_JSON)
    }

    // Endpoint para deletar um hábito pelo ID
    @DELETE 
    @Transactional  // Os endpoints que modificam o banco de dados (POST, DELETE) precisam ser transacionais
    @Path("/{id}") // Onde o ID vai ser passado na URL
    public void deleteHabit(@PathParam("id") Long id) { // a variavel id vai receber o valor do ID passado na URL
        Habit habit = em.find(Habit.class, id);
        if (habit != null) {
            em.remove(habit);
        }
    }
}