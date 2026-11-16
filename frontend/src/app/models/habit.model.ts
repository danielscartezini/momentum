// A Model define o formato dos dados (tanto na requisição quanto na resposta) que serão enviados e recebidos do backend.
export interface HabitModel {
    id: number;
    habitName: string;
    habitDescription: string;
}