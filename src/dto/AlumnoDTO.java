package dto;

public class AlumnoDTO {
    private int id;
    private String nombre;
    private int idMunicipio;
    private String municipio;
    private int familiaNumerosa;

    // Constructor para crear un nuevo alumno
    public AlumnoDTO(String nombre, int idMunicipio, int familiaNumerosa2) {
        this.nombre = nombre;
        this.idMunicipio = idMunicipio;
        this.familiaNumerosa = familiaNumerosa2;
    }

    // Constructor para leer un alumno existente y mostrarlo en el READ
    public AlumnoDTO(int id, String nombre, String municipio, int familiaNumerosa) {
        this.id = id;
        this.nombre = nombre;
        this.municipio = municipio;
        this.familiaNumerosa = familiaNumerosa;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdMunicipio() {
        return idMunicipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public int getFamiliaNumerosa() {
        return familiaNumerosa;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdMunicipio(int idMunicipio) {
        this.idMunicipio = idMunicipio;
    }

    public void setFamiliaNumerosa(int familiaNumerosa) {
        this.familiaNumerosa = familiaNumerosa;
    }

	@Override
	public String toString() {
		return "AlumnoDTO [id=" + id + ", nombre=" + nombre + ", idMunicipio=" + idMunicipio + ", municipio="
				+ municipio + ", familiaNumerosa=" + familiaNumerosa + "]";
	}
    
    
}
