package model;

public class PersonDTO {

    private int id;
    private String nombre;

    public PersonDTO() {
    }

    public PersonDTO(int id) {
        this.id = id;
    }

    public PersonDTO(String nombre) {
        this.nombre = nombre;
    }

    public PersonDTO(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "PersonDTO{" + "id=" + id + ", nombre=" + nombre + '}';
    }

}
